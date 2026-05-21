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

# Optional imports for enhanced features
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
    from rich import print as rprint
    RICH_AVAILABLE = True
except ImportError:
    RICH_AVAILABLE = False

# ============================================================================
# Configuration and Data Structures
# ============================================================================

@dataclass
class Config:
    """Configuration for the codebase analyzer."""
    root_dir: Path = Path.cwd()
    output_file: Optional[Path] = None
    config_file: Optional[Path] = None
    verbose: bool = False
    quiet: bool = False
    json_output: bool = False
    yaml_output: bool = False
    tree_output: bool = False
    stats_only: bool = False
    no_gitignore: bool = False
    exclude_patterns: List[str] = field(default_factory=lambda: [
        '__pycache__', '*.pyc', '*.pyo', '*.so', '*.dll', '*.dylib',
        '.git', '.svn', '.hg', '.DS_Store', 'node_modules',
        '*.egg-info', 'dist', 'build', '.tox', '.venv', 'venv',
        '*.log', '*.tmp', '*.bak', '*.swp', '.coverage',
        'htmlcov', '.pytest_cache', '.mypy_cache', '.ruff_cache',
        '*.min.js', '*.min.css', 'package-lock.json', 'yarn.lock'
    ])
    include_extensions: List[str] = field(default_factory=lambda: [
        '.py', '.js', '.ts', '.jsx', '.tsx', '.java', '.cpp', '.c', '.h',
        '.hpp', '.cs', '.go', '.rs', '.rb', '.php', '.swift', '.kt',
        '.scala', '.sh', '.bash', '.zsh', '.fish', '.ps1', '.bat',
        '.html', '.css', '.scss', '.less', '.sql', '.r', '.m', '.mm',
        '.pl', '.pm', '.lua', '.vim', '.tf', '.yaml', '.yml', '.json',
        '.xml', '.md', '.rst', '.txt', '.cfg', '.ini', '.conf',
        '.dockerfile', '.env', '.gitignore', '.gitattributes',
        '.editorconfig', '.prettierrc', '.eslintrc', '.babelrc'
    ])
    max_file_size: int = 1024 * 1024  # 1MB
    max_depth: int = 10
    threads: int = 4
    include_hidden: bool = False
    follow_symlinks: bool = False
    git_aware: bool = True
    hash_files: bool = False
    show_duplicates: bool = False
    show_unused: bool = False
    complexity: bool = False
    dependencies: bool = False
    security_scan: bool = False
    format_code: bool = False
    export_format: str = "text"  # text, json, yaml, tree

    @classmethod
    def from_dict(cls, data: dict) -> 'Config':
        """Create Config from dictionary, handling Path conversions."""
        config = cls()
        for key, value in data.items():
            if hasattr(config, key):
                if key in ('root_dir', 'output_file', 'config_file'):
                    setattr(config, key, Path(value) if value else None)
                elif key == 'exclude_patterns':
                    setattr(config, key, value if value else config.exclude_patterns)
                elif key == 'include_extensions':
                    setattr(config, key, value if value else config.include_extensions)
                else:
                    setattr(config, key, value)
        return config

    def to_dict(self) -> dict:
        """Convert Config to dictionary."""
        result = asdict(self)
        for key in ('root_dir', 'output_file', 'config_file'):
            if result[key] is not None:
                result[key] = str(result[key])
        return result


@dataclass
class FileInfo:
    """Information about a single file."""
    path: Path
    relative_path: str
    size: int
    extension: str
    modified_time: datetime
    created_time: datetime
    lines: int = 0
    code_lines: int = 0
    comment_lines: int = 0
    blank_lines: int = 0
    hash_md5: Optional[str] = None
    hash_sha256: Optional[str] = None
    language: Optional[str] = None
    encoding: Optional[str] = None
    is_binary: bool = False
    is_symlink: bool = False
    is_hidden: bool = False
    permissions: str = ""
    owner: str = ""
    group: str = ""


@dataclass
class AnalysisResult:
    """Complete analysis results."""
    config: Config
    start_time: datetime
    end_time: Optional[datetime] = None
    total_files: int = 0
    total_dirs: int = 0
    total_size: int = 0
    total_lines: int = 0
    total_code_lines: int = 0
    total_comment_lines: int = 0
    total_blank_lines: int = 0
    files: List[FileInfo] = field(default_factory=list)
    errors: List[str] = field(default_factory=list)
    warnings: List[str] = field(default_factory=list)
    duplicates: List[Tuple[str, List[str]]] = field(default_factory=list)
    unused_imports: Dict[str, List[str]] = field(default_factory=dict)
    complexity_scores: Dict[str, int] = field(default_factory=dict)
    dependencies: Dict[str, List[str]] = field(default_factory=dict)
    security_issues: List[Dict[str, Any]] = field(default_factory=list)
    language_stats: Dict[str, Dict[str, int]] = field(default_factory=dict)
    extension_stats: Dict[str, Dict[str, int]] = field(default_factory=dict)
    directory_stats: Dict[str, Dict[str, int]] = field(default_factory=dict)

    def to_dict(self) -> dict:
        """Convert to dictionary for serialization."""
        result = {
            'config': self.config.to_dict(),
            'start_time': self.start_time.isoformat(),
            'end_time': self.end_time.isoformat() if self.end_time else None,
            'summary': {
                'total_files': self.total_files,
                'total_dirs': self.total_dirs,
                'total_size': self.total_size,
                'total_lines': self.total_lines,
                'total_code_lines': self.total_code_lines,
                'total_comment_lines': self.total_comment_lines,
                'total_blank_lines': self.total_blank_lines,
            },
            'files': [],
            'errors': self.errors,
            'warnings': self.warnings,
            'language_stats': self.language_stats,
            'extension_stats': self.extension_stats,
            'directory_stats': self.directory_stats,
        }
        
        for f in self.files:
            file_dict = {
                'path': str(f.path),
                'relative_path': f.relative_path,
                'size': f.size,
                'extension': f.extension,
                'modified_time': f.modified_time.isoformat(),
                'created_time': f.created_time.isoformat(),
                'lines': f.lines,
                'code_lines': f.code_lines,
                'comment_lines': f.comment_lines,
                'blank_lines': f.blank_lines,
                'language': f.language,
                'is_binary': f.is_binary,
                'is_symlink': f.is_symlink,
                'is_hidden': f.is_hidden,
            }
            if f.hash_md5:
                file_dict['hash_md5'] = f.hash_md5
            if f.hash_sha256:
                file_dict['hash_sha256'] = f.hash_sha256
            result['files'].append(file_dict)
        
        if self.duplicates:
            result['duplicates'] = [(h, paths) for h, paths in self.duplicates]
        if self.unused_imports:
            result['unused_imports'] = self.unused_imports
        if self.complexity_scores:
            result['complexity_scores'] = self.complexity_scores
        if self.dependencies:
            result['dependencies'] = self.dependencies
        if self.security_issues:
            result['security_issues'] = self.security_issues
            
        return result


# ============================================================================
# Core Analyzer
# ============================================================================

class CodebaseAnalyzer:
    """Main analyzer class for codebase analysis."""
    
    # Language detection mapping
    LANGUAGE_MAP = {
        '.py': 'Python', '.js': 'JavaScript', '.ts': 'TypeScript',
        '.jsx': 'React JSX', '.tsx': 'React TSX', '.java': 'Java',
        '.cpp': 'C++', '.c': 'C', '.h': 'C Header', '.hpp': 'C++ Header',
        '.cs': 'C#', '.go': 'Go', '.rs': 'Rust', '.rb': 'Ruby',
        '.php': 'PHP', '.swift': 'Swift', '.kt': 'Kotlin',
        '.scala': 'Scala', '.sh': 'Shell', '.bash': 'Bash',
        '.zsh': 'Zsh', '.fish': 'Fish', '.ps1': 'PowerShell',
        '.bat': 'Batch', '.html': 'HTML', '.css': 'CSS',
        '.scss': 'SCSS', '.less': 'Less', '.sql': 'SQL',
        '.r': 'R', '.m': 'Objective-C', '.mm': 'Objective-C++',
        '.pl': 'Perl', '.pm': 'Perl Module', '.lua': 'Lua',
        '.vim': 'VimL', '.tf': 'Terraform', '.yaml': 'YAML',
        '.yml': 'YAML', '.json': 'JSON', '.xml': 'XML',
        '.md': 'Markdown', '.rst': 'reStructuredText', '.txt': 'Text',
        '.cfg': 'Config', '.ini': 'INI', '.conf': 'Config',
        '.dockerfile': 'Dockerfile', '.env': 'Environment',
        '.gitignore': 'Git Ignore', '.gitattributes': 'Git Attributes',
        '.editorconfig': 'EditorConfig', '.prettierrc': 'Prettier',
        '.eslintrc': 'ESLint', '.babelrc': 'Babel',
    }
    
    # Binary file extensions to skip
    BINARY_EXTENSIONS = {
        '.png', '.jpg', '.jpeg', '.gif', '.bmp', '.ico', '.svg',
        '.pdf', '.doc', '.docx', '.xls', '.xlsx', '.ppt', '.pptx',
        '.zip', '.tar', '.gz', '.bz2', '.7z', '.rar',
        '.exe', '.dll', '.so', '.dylib', '.bin', '.dat',
        '.mp3', '.mp4', '.avi', '.mov', '.wmv', '.flv',
        '.ttf', '.otf', '.woff', '.woff2', '.eot',
        '.pyc', '.pyo', '.class', '.o', '.obj',
    }
    
    # Security patterns to check
    SECURITY_PATTERNS = [
        (r'(?i)(password|passwd|pwd)\s*[=:]\s*["\'].+?["\']', 'Hardcoded password'),
        (r'(?i)(api[_-]?key|apikey)\s*[=:]\s*["\'].+?["\']', 'API key exposure'),
        (r'(?i)(secret|token)\s*[=:]\s*["\'].+?["\']', 'Secret/token exposure'),
        (r'(?i)(aws_access_key_id|aws_secret_access_key)\s*[=:]\s*["\'].+?["\']', 'AWS credentials'),
        (r'(?i)-----BEGIN (RSA |EC )?PRIVATE KEY-----', 'Private key exposure'),
        (r'(?i)(eval|exec)\s*\(', 'Dangerous function usage'),
        (r'(?i)(os\.system|subprocess\.call|subprocess\.Popen)\s*\(', 'Command injection risk'),
        (r'(?i)(pickle\.loads?|yaml\.load\b)(?!.*SafeLoader)', 'Insecure deserialization'),
        (r'(?i)(sqlite3\.execute|execute_query)\s*\(.*?\+', 'SQL injection risk'),
        (r'(?i)(<script>|javascript:.*\(\))', 'XSS vulnerability'),
        (r'(?i)(allow_url_include|allow_url_fopen)\s*=\s*On', 'Dangerous PHP config'),
    ]
    
    def __init__(self, config: Config):
        self.config = config
        self.result = AnalysisResult(config=config, start_time=datetime.now(timezone.utc))
        self.logger = self._setup_logger()
        self.gitignore_patterns = []
        self.file_lock = threading.Lock()
        self.progress = None
        self.progress_task = None
        
    def _setup_logger(self) -> logging.Logger:
        """Setup logging configuration."""
        logger = logging.getLogger('codebase_analyzer')
        logger.setLevel(logging.DEBUG if self.config.verbose else logging.INFO)
        
        if not self.config.quiet:
            handler = logging.StreamHandler()
            formatter = logging.Formatter(
                '%(asctime)s - %(levelname)s - %(message)s',
                datefmt='%H:%M:%S'
            )
            handler.setFormatter(formatter)
            logger.addHandler(handler)
            
        return logger
    
    def _load_gitignore(self) -> List[str]:
        """Load .gitignore patterns if available."""
        patterns = []
        gitignore_path = self.config.root_dir / '.gitignore'
        if gitignore_path.exists() and self.config.git_aware:
            try:
                with open(gitignore_path, 'r', encoding='utf-8', errors='ignore') as f:
                    for line in f:
                        line = line.strip()
                        if line and not line.startswith('#'):
                            patterns.append(line)
                self.logger.debug(f"Loaded {len(patterns)} gitignore patterns")
            except Exception as e:
                self.logger.warning(f"Failed to load .gitignore: {e}")
        return patterns
    
    def _should_exclude(self, path: Path, relative_path: str) -> bool:
        """Check if a path should be excluded based on patterns."""
        # Check exclude patterns
        for pattern in self.config.exclude_patterns:
            if pattern.startswith('*'):
                if path.name.endswith(pattern[1:]):
                    return True
            elif pattern in relative_path.split(os.sep):
                return True
            elif path.match(pattern):
                return True
                
        # Check gitignore patterns
        for pattern in self.gitignore_patterns:
            if pattern.startswith('*'):
                if path.name.endswith(pattern[1:]):
                    return True
            elif pattern in relative_path.split(os.sep):
                return True
                
        # Check hidden files
        if not self.config.include_hidden and path.name.startswith('.'):
            return True
            
        return False
    
    def _get_file_info(self, file_path: Path, relative_path: str) -> Optional[FileInfo]:
        """Get detailed information about a file."""
        try:
            stat = file_path.stat()
            ext = file_path.suffix.lower()
            
            # Check if binary
            is_binary = ext in self.BINARY_EXTENSIONS
            if not is_binary and ext in self.config.include_extensions:
                try:
                    with open(file_path, 'rb') as f:
                        chunk = f.read(1024)
                        if b'\x00' in chunk:
                            is_binary = True
                except:
                    is_binary = True
            
            # Create FileInfo
            info = FileInfo(
                path=file_path,
                relative_path=relative_path,
                size=stat.st_size,
                extension=ext,
                modified_time=datetime.fromtimestamp(stat.st_mtime, tz=timezone.utc),
                created_time=datetime.fromtimestamp(stat.st_ctime, tz=timezone.utc),
                is_binary=is_binary,
                is_symlink=file_path.is_symlink(),
                is_hidden=file_path.name.startswith('.'),
                permissions=oct(stat.st_mode)[-3:],
                language=self.LANGUAGE_MAP.get(ext, 'Unknown'),
            )
            
            # Calculate hashes if requested
            if self.config.hash_files and not is_binary and stat.st_size < self.config.max_file_size:
                try:
                    with open(file_path, 'rb') as f:
                        content = f.read()
                        info.hash_md5 = hashlib.md5(content).hexdigest()
                        info.hash_sha256 = hashlib.sha256(content).hexdigest()
                except:
                    pass
            
            # Count lines if not binary and within size limit
            if not is_binary and stat.st_size < self.config.max_file_size:
                try:
                    with open(file_path, 'r', encoding='utf-8', errors='ignore') as f:
                        lines = f.readlines()
                    
                    info.lines = len(lines)
                    info.code_lines = 0