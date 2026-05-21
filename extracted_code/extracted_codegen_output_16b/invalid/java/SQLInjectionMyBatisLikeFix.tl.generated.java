```python
import os
import sys
import json
import time
import hashlib
import logging
import argparse
import threading
import subprocess
from pathlib import Path
from typing import Dict, List, Optional, Tuple, Any
from dataclasses import dataclass, field, asdict
from datetime import datetime, timezone
from concurrent.futures import ThreadPoolExecutor, as_completed

# Optional imports for enhanced functionality
try:
    import yaml
    YAML_AVAILABLE = True
except ImportError:
    YAML_AVAILABLE = False

try:
    import requests
    REQUESTS_AVAILABLE = True
except ImportError:
    REQUESTS_AVAILABLE = False

try:
    from rich.console import Console
    from rich.table import Table
    from rich.progress import Progress, SpinnerColumn, TextColumn, BarColumn
    from rich.syntax import Syntax
    from rich.panel import Panel
    from rich.tree import Tree
    RICH_AVAILABLE = True
    console = Console()
except ImportError:
    RICH_AVAILABLE = False
    console = None

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    handlers=[
        logging.StreamHandler(),
        logging.FileHandler('codebase_analyzer.log')
    ]
)
logger = logging.getLogger(__name__)


@dataclass
class FileInfo:
    """Represents information about a single file in the codebase."""
    path: Path
    size: int
    extension: str
    last_modified: datetime
    created: datetime
    permissions: str
    owner: str
    group: str
    is_binary: bool
    mime_type: str
    lines: int = 0
    code_lines: int = 0
    comment_lines: int = 0
    blank_lines: int = 0
    hash_md5: str = ""
    hash_sha256: str = ""
    imports: List[str] = field(default_factory=list)
    functions: List[str] = field(default_factory=list)
    classes: List[str] = field(default_factory=list)
    dependencies: List[str] = field(default_factory=list)
    complexity: int = 0
    issues: List[str] = field(default_factory=list)
    metrics: Dict[str, Any] = field(default_factory=dict)


@dataclass
class DirectoryInfo:
    """Represents information about a directory in the codebase."""
    path: Path
    total_files: int = 0
    total_size: int = 0
    file_types: Dict[str, int] = field(default_factory=dict)
    subdirectories: List[str] = field(default_factory=list)
    files: List[FileInfo] = field(default_factory=list)
    issues: List[str] = field(default_factory=list)


class CodebaseAnalyzer:
    """Main analyzer class for comprehensive codebase analysis."""
    
    # Common binary file extensions
    BINARY_EXTENSIONS = {
        '.exe', '.dll', '.so', '.dylib', '.bin', '.dat', '.db',
        '.jpg', '.jpeg', '.png', '.gif', '.bmp', '.ico', '.svg',
        '.mp3', '.mp4', '.avi', '.mov', '.wmv', '.flv',
        '.zip', '.tar', '.gz', '.bz2', '.7z', '.rar',
        '.pdf', '.doc', '.docx', '.xls', '.xlsx', '.ppt', '.pptx',
        '.pyc', '.pyo', '.class', '.jar', '.war',
        '.o', '.obj', '.lib', '.a', '.la',
        '.ttf', '.otf', '.woff', '.woff2', '.eot',
        '.ico', '.icns',
    }
    
    # Programming language extensions and their comment syntax
    LANGUAGE_CONFIGS = {
        '.py': {'single': '#', 'multi_start': '"""', 'multi_end': '"""', 'name': 'Python'},
        '.js': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'JavaScript'},
        '.ts': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'TypeScript'},
        '.java': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'Java'},
        '.cpp': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'C++'},
        '.c': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'C'},
        '.h': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'C Header'},
        '.hpp': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'C++ Header'},
        '.cs': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'C#'},
        '.go': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'Go'},
        '.rs': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'Rust'},
        '.rb': {'single': '#', 'multi_start': '=begin', 'multi_end': '=end', 'name': 'Ruby'},
        '.php': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'PHP'},
        '.swift': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'Swift'},
        '.kt': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'Kotlin'},
        '.scala': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'Scala'},
        '.html': {'single': '<!--', 'multi_start': '<!--', 'multi_end': '-->', 'name': 'HTML'},
        '.css': {'single': '/*', 'multi_start': '/*', 'multi_end': '*/', 'name': 'CSS'},
        '.scss': {'single': '//', 'multi_start': '/*', 'multi_end': '*/', 'name': 'SCSS'},
        '.sql': {'single': '--', 'multi_start': '/*', 'multi_end': '*/', 'name': 'SQL'},
        '.sh': {'single': '#', 'multi_start': ':', 'multi_end': "'", 'name': 'Shell'},
        '.bash': {'single': '#', 'multi_start': ':', 'multi_end': "'", 'name': 'Bash'},
        '.yaml': {'single': '#', 'multi_start': None, 'multi_end': None, 'name': 'YAML'},
        '.yml': {'single': '#', 'multi_start': None, 'multi_end': None, 'name': 'YAML'},
        '.json': {'single': None, 'multi_start': None, 'multi_end': None, 'name': 'JSON'},
        '.xml': {'single': '<!--', 'multi_start': '<!--', 'multi_end': '-->', 'name': 'XML'},
        '.md': {'single': None, 'multi_start': None, 'multi_end': None, 'name': 'Markdown'},
        '.txt': {'single': None, 'multi_start': None, 'multi_end': None, 'name': 'Text'},
        '.toml': {'single': '#', 'multi_start': None, 'multi_end': None, 'name': 'TOML'},
        '.ini': {'single': ';', 'multi_start': None, 'multi_end': None, 'name': 'INI'},
        '.cfg': {'single': '#', 'multi_start': None, 'multi_end': None, 'name': 'Config'},
        '.conf': {'single': '#', 'multi_start': None, 'multi_end': None, 'name': 'Config'},
    }
    
    def __init__(self, root_path: str, config: Optional[Dict] = None):
        """
        Initialize the codebase analyzer.
        
        Args:
            root_path: Root directory to analyze
            config: Optional configuration dictionary
        """
        self.root_path = Path(root_path).resolve()
        if not self.root_path.exists():
            raise FileNotFoundError(f"Path does not exist: {root_path}")
        
        self.config = config or self._load_default_config()
        self.results = {}
        self.issues = []
        self.metrics = {}
        self.lock = threading.Lock()
        
        # Initialize counters
        self.total_files = 0
        self.total_dirs = 0
        self.total_size = 0
        self.total_lines = 0
        self.total_code_lines = 0
        self.total_comment_lines = 0
        self.total_blank_lines = 0
        
        # File type statistics
        self.file_type_stats = {}
        
        # Language statistics
        self.language_stats = {}
        
        # Dependency tracking
        self.dependencies = {}
        
        # Issue tracking
        self.all_issues = []
        
        # Performance metrics
        self.start_time = None
        self.end_time = None
        
    def _load_default_config(self) -> Dict:
        """Load default configuration."""
        return {
            'exclude_dirs': {
                '.git', '.svn', '.hg', '__pycache__', 'node_modules',
                '.venv', 'venv', 'env', '.env', 'dist', 'build',
                '.idea', '.vscode', '.DS_Store', 'target', 'bin',
                'obj', 'lib', 'include', '.mypy_cache', '.pytest_cache',
                '.tox', '.eggs', '*.egg-info', '.cache', '.npm',
                'vendor', 'bower_components', 'jspm_packages',
                '.next', '.nuxt', '.output', '.serverless',
                'coverage', '.nyc_output', '.sass-cache',
                '.parcel-cache', '.yarn', '.pnp'
            },
            'exclude_extensions': {
                '.pyc', '.pyo', '.so', '.dll', '.dylib',
                '.jpg', '.jpeg', '.png', '.gif', '.bmp',
                '.mp3', '.mp4', '.avi', '.mov',
                '.zip', '.tar', '.gz', '.bz2', '.7z', '.rar',
                '.pdf', '.doc', '.docx', '.xls', '.xlsx',
                '.ttf', '.otf', '.woff', '.woff2', '.eot',
                '.ico', '.icns', '.o', '.obj', '.lib', '.a',
                '.class', '.jar', '.war'
            },
            'exclude_patterns': [
                '*.min.*', '*.bundle.*', '*.chunk.*',
                '*.generated.*', '*.template.*',
                'package-lock.json', 'yarn.lock', 'pnpm-lock.yaml',
                '.gitignore', '.gitattributes', '.editorconfig',
                '*.log', '*.tmp', '*.temp', '*.swp', '*.swo',
                '*.bak', '*.backup', '*.orig'
            ],
            'max_file_size': 10 * 1024 * 1024,  # 10MB
            'max_depth': 50,
            'threads': 4,
            'include_hidden': False,
            'follow_symlinks': False,
            'calculate_hashes': True,
            'analyze_imports': True,
            'analyze_complexity': True,
            'detect_duplicates': True,
            'check_security': True,
            'check_style': True,
            'check_documentation': True,
            'output_format': 'json',
            'verbose': False,
            'progress_bar': True
        }
    
    def analyze(self) -> Dict:
        """
        Perform comprehensive codebase analysis.
        
        Returns:
            Dictionary containing all analysis results
        """
        self.start_time = time.time()
        logger.info(f"Starting analysis of {self.root_path}")
        
        if RICH_AVAILABLE and self.config.get('progress_bar', True):
            self._analyze_with_progress()
        else:
            self._analyze_recursive(self.root_path, 0)
        
        self._calculate_metrics()
        self._detect_issues()
        
        self.end_time = time.time()
        duration = self.end_time - self.start_time
        
        logger.info(f"Analysis completed in {duration:.2f} seconds")
        
        return self._build_results()
    
    def _analyze_with_progress(self):
        """Analyze with rich progress bar."""
        with Progress(
            SpinnerColumn(),
            TextColumn("[progress.description]{task.description}"),
            BarColumn(),
            TextColumn("[progress.percentage]{task.percentage:>3.0f}%"),
            console=console
        ) as progress:
            task = progress.add_task("[cyan]Analyzing codebase...", total=None)
            
            # First, count total files
            total = self._count_files(self.root_path)
            progress.update(task, total=total)
            
            # Then analyze with progress
            self._analyze_recursive_with_progress(self.root_path, 0, progress, task)
    
    def _count_files(self, path: Path) -> int:
        """Count total files to analyze."""
        count = 0
        try:
            for item in path.iterdir():
                if item.name.startswith('.') and not self.config.get('include_hidden', False):
                    continue
                if item.name in self.config.get('exclude_dirs', set()):
                    continue
                if item.is_file():
                    if self._should_analyze_file(item):
                        count += 1
                elif item.is_dir():
                    count += self._count_files(item)
        except PermissionError:
            pass
        return count
    
    def _analyze_recursive_with_progress(self, path: Path, depth: int, progress, task):
        """Recursive analysis with progress updates."""
        if depth > self.config.get('max_depth', 50):
            return
        
        try:
            items = sorted(path.iterdir(), key=lambda x: (not x.is_dir(), x.name))
        except PermissionError:
            return
        
        for item in items:
            if item.name.startswith('.') and not self.config.get('include_hidden', False):
                continue
            if item.name in self.config.get('exclude_dirs', set()):
                continue
            
            if item.is_symlink() and not self.config.get('follow_symlinks', False):
                continue
            
            if item.is_file():
                if self._should_analyze_file(item):
                    file_info = self._analyze_file(item)
                    with self.lock:
                        self.results[str(item)] = file_info
                        self.total_files += 1
                        self.total_size += file_info.size
                        self.total_lines += file_info.lines
                        self.total_code_lines += file_info.code_lines
                        self.total_comment_lines += file_info.comment_lines
                        self.total_blank_lines += file_info.blank_lines
                        
                        # Update file type stats
                        ext = file_info.extension.lower()
                        self.file_type_stats[ext] = self.file_type_stats.get(ext, 0) + 1
                        
                        # Update language stats
                        if ext in self.LANGUAGE_CONFIGS:
                            lang = self.LANGUAGE_CONFIGS[ext]['name']
                            if lang not in self.language_stats:
                                self.language_stats[lang] = {
                                    'files': 0,
                                    'lines': 0,
                                    'code_lines': 0,
                                    'comment_lines': 0,
                                    'blank_lines': 0,
                                    'size': 0
                                }
                            self.language_stats[lang]['files'] += 1
                            self.language_stats[lang]['lines'] += file_info.lines
                            self.language_stats[lang]['code_lines'] += file_info.code_lines
                            self.language_stats[lang]['comment_lines'] += file_info.comment_lines
                            self.language_stats[lang]['blank_lines'] += file_info.blank_lines
                            self.language_stats[lang]['size'] += file_info.size
                    
                    progress.advance(task)
                    
            elif item.is_dir():
                self.total_dirs += 1
                self._analyze_recursive_with_progress(item, depth + 1, progress, task)
    
    def _analyze_recursive(self, path: Path, depth: int):
        """Recursive analysis without progress bar."""
        if depth > self.config.get('max_depth', 50):
            return
        
        try:
            items = sorted(path.iterdir(), key=lambda x: (not x.is_dir(), x.name))
        except PermissionError:
            return
        
        for item in items:
            if item.name.startswith('.') and not self.config.get('include_hidden', False):
                continue
            if item.name in self.config.get('exclude_dirs', set()):
                continue
            
            if item.is_symlink() and not self.config.get('follow_symlinks', False):
                continue
            
            if item.is_file():
                if self._should_analyze_file(item):
                    file_info = self._analyze_file(item)
                    with self.lock:
                        self.results[str(item)] = file_info
                        self.total_files += 1
                        self.total_size += file_info.size
                        self.total_lines += file_info.lines
                        self.total_code_lines += file_info.code_lines
                        self.total_comment_lines += file_info.comment_lines
                        self.total_blank_lines += file_info.blank_lines
                        
                        # Update file type stats
                        ext = file_info.extension.lower()
                        self.file_type_stats[ext] = self.file_type_stats.get(ext, 0) + 1
                        
                        # Update language stats
                        if ext in self.LANGUAGE_CONFIGS:
                            lang = self.LANGUAGE_CONFIGS[ext]['name']
                            if lang not in self.language_stats:
                                self.language_stats[lang] = {
                                    'files': 0,
                                    'lines': 0,
                                    'code_lines': 0,
                                    'comment_lines': 0,
                                    'blank_lines': 0,
                                    'size': 0
                                }
                            self.language_stats[lang]['files'] +=