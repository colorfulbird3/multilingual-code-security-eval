```python
import os
import sys
import json
import time
import logging
import threading
import subprocess
from pathlib import Path
from typing import Optional, Dict, Any, List, Tuple
from dataclasses import dataclass, field, asdict
from enum import Enum
import hashlib
import shutil
import tempfile
import re
from datetime import datetime

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)
logger = logging.getLogger(__name__)


class ApplicationStatus(Enum):
    """Status of the application"""
    STOPPED = "stopped"
    RUNNING = "running"
    PAUSED = "paused"
    ERROR = "error"
    UNKNOWN = "unknown"


@dataclass
class ApplicationConfig:
    """Configuration for an application"""
    name: str
    version: str = "1.0.0"
    description: str = ""
    author: str = ""
    entry_point: str = "main.py"
    dependencies: List[str] = field(default_factory=list)
    environment: Dict[str, str] = field(default_factory=dict)
    timeout: int = 300  # seconds
    max_restarts: int = 3
    working_directory: str = "."
    log_level: str = "INFO"
    auto_start: bool = False
    health_check_interval: int = 30  # seconds
    resource_limits: Dict[str, Any] = field(default_factory=lambda: {
        "cpu": 100,  # percentage
        "memory": 512,  # MB
        "disk": 1024,  # MB
        "network": 100  # Mbps
    })


class Application:
    """Represents a single application instance"""
    
    def __init__(self, config: ApplicationConfig):
        self.config = config
        self.status = ApplicationStatus.STOPPED
        self.process: Optional[subprocess.Popen] = None
        self.start_time: Optional[float] = None
        self.restart_count = 0
        self.error_count = 0
        self.last_error: Optional[str] = None
        self.metrics: Dict[str, Any] = {}
        self._lock = threading.Lock()
        self._health_check_thread: Optional[threading.Thread] = None
        self._stop_event = threading.Event()
        
    def start(self) -> bool:
        """Start the application"""
        with self._lock:
            if self.status == ApplicationStatus.RUNNING:
                logger.warning(f"Application {self.config.name} is already running")
                return False
                
            try:
                # Create working directory if it doesn't exist
                work_dir = Path(self.config.working_directory)
                work_dir.mkdir(parents=True, exist_ok=True)
                
                # Set up environment
                env = os.environ.copy()
                env.update(self.config.environment)
                env["APP_NAME"] = self.config.name
                env["APP_VERSION"] = self.config.version
                
                # Start the process
                entry_path = work_dir / self.config.entry_point
                if not entry_path.exists():
                    raise FileNotFoundError(f"Entry point {entry_path} not found")
                
                self.process = subprocess.Popen(
                    [sys.executable, str(entry_path)],
                    cwd=str(work_dir),
                    env=env,
                    stdout=subprocess.PIPE,
                    stderr=subprocess.PIPE,
                    text=True,
                    bufsize=1
                )
                
                self.status = ApplicationStatus.RUNNING
                self.start_time = time.time()
                self.restart_count = 0
                self.error_count = 0
                self.last_error = None
                
                # Start health check thread
                self._stop_event.clear()
                self._health_check_thread = threading.Thread(
                    target=self._health_check_loop,
                    daemon=True
                )
                self._health_check_thread.start()
                
                logger.info(f"Application {self.config.name} started successfully")
                return True
                
            except Exception as e:
                self.status = ApplicationStatus.ERROR
                self.last_error = str(e)
                self.error_count += 1
                logger.error(f"Failed to start application {self.config.name}: {e}")
                return False
    
    def stop(self) -> bool:
        """Stop the application"""
        with self._lock:
            if self.status == ApplicationStatus.STOPPED:
                return True
                
            try:
                # Signal health check to stop
                self._stop_event.set()
                
                if self.process:
                    # Try graceful shutdown first
                    self.process.terminate()
                    try:
                        self.process.wait(timeout=10)
                    except subprocess.TimeoutExpired:
                        # Force kill if not responding
                        self.process.kill()
                        self.process.wait()
                
                self.status = ApplicationStatus.STOPPED
                self.process = None
                self.start_time = None
                
                logger.info(f"Application {self.config.name} stopped")
                return True
                
            except Exception as e:
                self.status = ApplicationStatus.ERROR
                self.last_error = str(e)
                logger.error(f"Error stopping application {self.config.name}: {e}")
                return False
    
    def pause(self) -> bool:
        """Pause the application"""
        with self._lock:
            if self.status != ApplicationStatus.RUNNING:
                return False
                
            try:
                if self.process:
                    # Send SIGSTOP to pause
                    self.process.send_signal(subprocess.signal.SIGSTOP)
                self.status = ApplicationStatus.PAUSED
                logger.info(f"Application {self.config.name} paused")
                return True
                
            except Exception as e:
                logger.error(f"Error pausing application {self.config.name}: {e}")
                return False
    
    def resume(self) -> bool:
        """Resume the application"""
        with self._lock:
            if self.status != ApplicationStatus.PAUSED:
                return False
                
            try:
                if self.process:
                    # Send SIGCONT to resume
                    self.process.send_signal(subprocess.signal.SIGCONT)
                self.status = ApplicationStatus.RUNNING
                logger.info(f"Application {self.config.name} resumed")
                return True
                
            except Exception as e:
                logger.error(f"Error resuming application {self.config.name}: {e}")
                return False
    
    def restart(self) -> bool:
        """Restart the application"""
        if self.restart_count >= self.config.max_restarts:
            logger.error(f"Application {self.config.name} exceeded max restarts")
            return False
            
        self.stop()
        time.sleep(1)  # Brief delay before restart
        success = self.start()
        if success:
            self.restart_count += 1
        return success
    
    def get_status(self) -> Dict[str, Any]:
        """Get application status and metrics"""
        with self._lock:
            return {
                "name": self.config.name,
                "status": self.status.value,
                "uptime": time.time() - self.start_time if self.start_time else 0,
                "restart_count": self.restart_count,
                "error_count": self.error_count,
                "last_error": self.last_error,
                "metrics": self.metrics,
                "config": asdict(self.config)
            }
    
    def _health_check_loop(self):
        """Background thread for health checks"""
        while not self._stop_event.is_set():
            try:
                if self.process and self.process.poll() is not None:
                    # Process has exited
                    exit_code = self.process.returncode
                    logger.warning(
                        f"Application {self.config.name} exited with code {exit_code}"
                    )
                    
                    # Auto-restart if configured
                    if exit_code != 0 and self.restart_count < self.config.max_restarts:
                        logger.info(f"Attempting to restart {self.config.name}")
                        self.restart()
                    else:
                        self.status = ApplicationStatus.STOPPED
                        self.process = None
                    break
                
                # Update metrics
                self._update_metrics()
                
            except Exception as e:
                logger.error(f"Health check error for {self.config.name}: {e}")
            
            self._stop_event.wait(self.config.health_check_interval)
    
    def _update_metrics(self):
        """Update application metrics"""
        try:
            if self.process:
                # Get CPU and memory usage
                import psutil
                try:
                    proc = psutil.Process(self.process.pid)
                    cpu_percent = proc.cpu_percent(interval=0.1)
                    memory_info = proc.memory_info()
                    
                    self.metrics.update({
                        "cpu_percent": cpu_percent,
                        "memory_mb": memory_info.rss / 1024 / 1024,
                        "memory_vms_mb": memory_info.vms / 1024 / 1024,
                        "num_threads": proc.num_threads(),
                        "num_fds": proc.num_fds(),
                        "timestamp": time.time()
                    })
                except (psutil.NoSuchProcess, psutil.AccessDenied):
                    pass
                    
        except ImportError:
            # psutil not available, use basic metrics
            pass
        except Exception as e:
            logger.debug(f"Error updating metrics: {e}")


class ApplicationManager:
    """Manages multiple applications"""
    
    def __init__(self, config_dir: Optional[str] = None):
        self.applications: Dict[str, Application] = {}
        self.config_dir = Path(config_dir or "./applications")
        self.config_dir.mkdir(parents=True, exist_ok=True)
        self._lock = threading.Lock()
        self._monitor_thread: Optional[threading.Thread] = None
        self._stop_event = threading.Event()
        
    def create_application(self, config: ApplicationConfig) -> bool:
        """Create a new application"""
        with self._lock:
            if config.name in self.applications:
                logger.warning(f"Application {config.name} already exists")
                return False
                
            try:
                app = Application(config)
                self.applications[config.name] = app
                
                # Save configuration
                self._save_config(config)
                
                logger.info(f"Application {config.name} created")
                return True
                
            except Exception as e:
                logger.error(f"Error creating application {config.name}: {e}")
                return False
    
    def delete_application(self, name: str) -> bool:
        """Delete an application"""
        with self._lock:
            if name not in self.applications:
                logger.warning(f"Application {name} not found")
                return False
                
            try:
                app = self.applications[name]
                app.stop()
                del self.applications[name]
                
                # Remove configuration file
                config_file = self.config_dir / f"{name}.json"
                if config_file.exists():
                    config_file.unlink()
                
                logger.info(f"Application {name} deleted")
                return True
                
            except Exception as e:
                logger.error(f"Error deleting application {name}: {e}")
                return False
    
    def get_application(self, name: str) -> Optional[Application]:
        """Get an application by name"""
        return self.applications.get(name)
    
    def list_applications(self) -> List[Dict[str, Any]]:
        """List all applications with their status"""
        with self._lock:
            return [
                app.get_status() for app in self.applications.values()
            ]
    
    def start_application(self, name: str) -> bool:
        """Start a specific application"""
        app = self.get_application(name)
        if app:
            return app.start()
        return False
    
    def stop_application(self, name: str) -> bool:
        """Stop a specific application"""
        app = self.get_application(name)
        if app:
            return app.stop()
        return False
    
    def pause_application(self, name: str) -> bool:
        """Pause a specific application"""
        app = self.get_application(name)
        if app:
            return app.pause()
        return False
    
    def resume_application(self, name: str) -> bool:
        """Resume a specific application"""
        app = self.get_application(name)
        if app:
            return app.resume()
        return False
    
    def restart_application(self, name: str) -> bool:
        """Restart a specific application"""
        app = self.get_application(name)
        if app:
            return app.restart()
        return False
    
    def start_all(self) -> Dict[str, bool]:
        """Start all applications"""
        results = {}
        with self._lock:
            for name, app in self.applications.items():
                if app.config.auto_start:
                    results[name] = app.start()
        return results
    
    def stop_all(self) -> Dict[str, bool]:
        """Stop all applications"""
        results = {}
        with self._lock:
            for name, app in self.applications.items():
                results[name] = app.stop()
        return results
    
    def get_metrics(self) -> Dict[str, Any]:
        """Get overall system metrics"""
        metrics = {
            "total_applications": len(self.applications),
            "running": 0,
            "stopped": 0,
            "paused": 0,
            "error": 0,
            "total_uptime": 0,
            "total_restarts": 0,
            "total_errors": 0
        }
        
        with self._lock:
            for app in self.applications.values():
                status = app.get_status()
                metrics[f"{status['status']}"] += 1
                metrics["total_uptime"] += status["uptime"]
                metrics["total_restarts"] += status["restart_count"]
                metrics["total_errors"] += status["error_count"]
        
        return metrics
    
    def _save_config(self, config: ApplicationConfig):
        """Save application configuration to file"""
        config_file = self.config_dir / f"{config.name}.json"
        with open(config_file, 'w') as f:
            json.dump(asdict(config), f, indent=2)
    
    def _load_config(self, name: str) -> Optional[ApplicationConfig]:
        """Load application configuration from file"""
        config_file = self.config_dir / f"{name}.json"
        if config_file.exists():
            with open(config_file, 'r') as f:
                data = json.load(f)
                return ApplicationConfig(**data)
        return None
    
    def load_all_configs(self):
        """Load all application configurations from directory"""
        for config_file in self.config_dir.glob("*.json"):
            try:
                with open(config_file, 'r') as f:
                    data = json.load(f)
                    config = ApplicationConfig(**data)
                    self.create_application(config)
            except Exception as e:
                logger.error(f"Error loading config {config_file}: {e}")
    
    def start_monitoring(self):
        """Start the monitoring thread"""
        if self._monitor_thread and self._monitor_thread.is_alive():
            return
            
        self._stop_event.clear()
        self._monitor_thread = threading.Thread(
            target=self._monitor_loop,
            daemon=True
        )
        self._monitor_thread.start()
        logger.info("Application monitoring started")
    
    def stop_monitoring(self):
        """Stop the monitoring thread"""
        self._stop_event.set()
        if self._monitor_thread:
            self._monitor_thread.join(timeout=5)
        logger.info("Application monitoring stopped")
    
    def _monitor_loop(self):
        """Background monitoring loop"""
        while not self._stop_event.is_set():
            try:
                # Check all applications
                with self._lock:
                    for name, app in self.applications.items():
                        status = app.get_status()
                        
                        # Log warnings for applications with issues
                        if status["error_count"] > 10:
                            logger.warning(
                                f"Application {name} has {status['error_count']} errors"
                            )
                        
                        if status["restart_count"] > app.config.max_restarts:
                            logger.error(
                                f"Application {name} exceeded max restarts"
                            )
                
                # Sleep for monitoring interval
                self._stop_event.wait(60)  # Check every minute
                
            except Exception as e:
                logger.error(f"Monitoring error: {e}")
    
    def cleanup(self):
        """Clean up resources"""
        self.stop_monitoring()
        self.stop_all()


class ApplicationBuilder:
    """Builder for creating application configurations"""
    
    def __init__(self):
        self.config = ApplicationConfig(name="")
    
    def set_name(self, name: str) -> 'ApplicationBuilder':
        self.config.name = name
        return self
    
    def set_version(self, version: str) -> 'ApplicationBuilder':
        self.config.version = version
        return self
    
    def set_description(self, description: str) -> 'ApplicationBuilder':
        self.config.description = description
        return self
    
    def set_author(self, author: str) -> 'ApplicationBuilder':
        self.config.author = author
        return self
    
    def set_entry_point(self, entry_point: str) -> 'ApplicationBuilder':
        self.config.entry_point = entry_point
        return self
    
    def add_dependency(self, dependency: str) -> 'ApplicationBuilder':
        self.config.dependencies.append(dependency)
        return self
    
    def set_environment(self, key: str, value: str) -> 'ApplicationBuilder':
        self.config.environment[key] = value
        return self
    
    def set_timeout(self, timeout: int) -> 'ApplicationBuilder':
        self.config.timeout = timeout
        return self
    
    def set_max_restarts(self, max_restarts: int) -> 'ApplicationBuilder':
        self.config.max_restarts = max_restarts
        return self
    
    def set_working_directory(self, working_directory: str) -> 'ApplicationBuilder':
        self.config.working_directory = working_directory
        return self
    
    def set_log_level(self, log_level: str) -> 'ApplicationBuilder':
        self.config.log_level = log_level
        return self
    
    def set_auto_start(self, auto_start: bool) -> 'ApplicationBuilder':
        self.config.auto_start = auto_start
        return self
    
    def set_health_check_interval(self, interval: int) -> 'ApplicationBuilder':
        self.config.health_check_interval = interval
        return self
    
    def set_resource_limits(self, limits: Dict[str, Any]) -> 'ApplicationBuilder':
        self.config.resource_limits.update(limits)
        return self
    
    def build(self) -> ApplicationConfig:
        """Build and return the configuration"""
        if not self.config.name:
            raise ValueError("Application name is required")
        return self.config


# Example usage and testing
def main():
    """Main function for testing