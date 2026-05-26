```python
import os
import sys
import json
import time
import uuid
import hashlib
import threading
import logging
from typing import Dict, List, Optional, Any
from dataclasses import dataclass, field
from enum import Enum
from pathlib import Path

# Third-party imports
try:
    from flask import Flask, request, jsonify, Response
    import requests
    from cryptography.fernet import Fernet
    from cryptography.hazmat.primitives import hashes
    from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
    import base64
except ImportError as e:
    print(f"Missing required dependency: {e}")
    print("Please install: flask, requests, cryptography")
    sys.exit(1)

# Configure logging
logging.basicConfig(
    level=logging.INFO,
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s'
)
logger = logging.getLogger("EndwenzoCloud")

# ============================================================================
# Data Models
# ============================================================================

class NodeStatus(Enum):
    """Status of a cloud node"""
    ONLINE = "online"
    OFFLINE = "offline"
    DEGRADED = "degraded"
    SYNCING = "syncing"

class DataType(Enum):
    """Types of data that can be stored"""
    TEXT = "text"
    BINARY = "binary"
    JSON = "json"
    FILE = "file"

@dataclass
class CloudNode:
    """Represents a node in the cloud"""
    node_id: str
    address: str
    port: int
    capacity: int  # Storage capacity in MB
    used_space: int = 0
    status: NodeStatus = NodeStatus.OFFLINE
    last_heartbeat: float = 0.0
    public_key: Optional[str] = None
    
    @property
    def available_space(self) -> int:
        return self.capacity - self.used_space
    
    @property
    def is_healthy(self) -> bool:
        return (self.status == NodeStatus.ONLINE and 
                time.time() - self.last_heartbeat < 30)

@dataclass
class DataBlock:
    """A chunk of data stored in the cloud"""
    block_id: str
    data: bytes
    checksum: str
    size: int
    timestamp: float = field(default_factory=time.time)
    node_id: Optional[str] = None
    encrypted: bool = False

@dataclass
class StoredFile:
    """Metadata for a stored file"""
    file_id: str
    filename: str
    size: int
    data_type: DataType
    blocks: List[str] = field(default_factory=list)
    created_at: float = field(default_factory=time.time)
    updated_at: float = field(default_factory=time.time)
    checksum: str = ""
    encrypted: bool = False
    metadata: Dict[str, Any] = field(default_factory=dict)

# ============================================================================
# Encryption Utilities
# ============================================================================

class EncryptionManager:
    """Manages encryption/decryption of data"""
    
    def __init__(self, master_key: Optional[str] = None):
        if master_key:
            self.master_key = master_key.encode()
        else:
            self.master_key = os.urandom(32)
        
        # Derive a Fernet-compatible key
        kdf = PBKDF2HMAC(
            algorithm=hashes.SHA256(),
            length=32,
            salt=b'endwenzo_cloud_salt',
            iterations=100000,
        )
        key = base64.urlsafe_b64encode(kdf.derive(self.master_key))
        self.cipher = Fernet(key)
    
    def encrypt(self, data: bytes) -> bytes:
        """Encrypt data"""
        return self.cipher.encrypt(data)
    
    def decrypt(self, encrypted_data: bytes) -> bytes:
        """Decrypt data"""
        return self.cipher.decrypt(encrypted_data)
    
    @staticmethod
    def generate_key() -> str:
        """Generate a new encryption key"""
        return base64.urlsafe_b64encode(os.urandom(32)).decode()

# ============================================================================
# Storage Engine
# ============================================================================

class StorageEngine:
    """Handles local data storage"""
    
    def __init__(self, storage_path: str = "./endwenzo_data"):
        self.storage_path = Path(storage_path)
        self.storage_path.mkdir(parents=True, exist_ok=True)
        self.blocks_path = self.storage_path / "blocks"
        self.blocks_path.mkdir(exist_ok=True)
        self.metadata_path = self.storage_path / "metadata.json"
        self._load_metadata()
    
    def _load_metadata(self):
        """Load metadata from disk"""
        if self.metadata_path.exists():
            with open(self.metadata_path, 'r') as f:
                self.metadata = json.load(f)
        else:
            self.metadata = {
                "files": {},
                "blocks": {},
                "nodes": {}
            }
            self._save_metadata()
    
    def _save_metadata(self):
        """Save metadata to disk"""
        with open(self.metadata_path, 'w') as f:
            json.dump(self.metadata, f, indent=2)
    
    def store_block(self, block_id: str, data: bytes) -> bool:
        """Store a data block"""
        try:
            block_path = self.blocks_path / block_id
            with open(block_path, 'wb') as f:
                f.write(data)
            
            self.metadata["blocks"][block_id] = {
                "size": len(data),
                "checksum": hashlib.sha256(data).hexdigest(),
                "timestamp": time.time()
            }
            self._save_metadata()
            return True
        except Exception as e:
            logger.error(f"Failed to store block {block_id}: {e}")
            return False
    
    def retrieve_block(self, block_id: str) -> Optional[bytes]:
        """Retrieve a data block"""
        try:
            block_path = self.blocks_path / block_id
            if block_path.exists():
                with open(block_path, 'rb') as f:
                    return f.read()
            return None
        except Exception as e:
            logger.error(f"Failed to retrieve block {block_id}: {e}")
            return None
    
    def delete_block(self, block_id: str) -> bool:
        """Delete a data block"""
        try:
            block_path = self.blocks_path / block_id
            if block_path.exists():
                block_path.unlink()
            self.metadata["blocks"].pop(block_id, None)
            self._save_metadata()
            return True
        except Exception as e:
            logger.error(f"Failed to delete block {block_id}: {e}")
            return False
    
    def get_storage_usage(self) -> Dict[str, int]:
        """Get storage usage statistics"""
        total_size = sum(
            block_info["size"] 
            for block_info in self.metadata["blocks"].values()
        )
        return {
            "total_blocks": len(self.metadata["blocks"]),
            "total_files": len(self.metadata["files"]),
            "total_size": total_size,
            "storage_path": str(self.storage_path)
        }

# ============================================================================
# Cloud Node Manager
# ============================================================================

class CloudNodeManager:
    """Manages cloud nodes and their interactions"""
    
    def __init__(self, node_id: str, host: str = "0.0.0.0", port: int = 5000):
        self.node_id = node_id
        self.host = host
        self.port = port
        self.nodes: Dict[str, CloudNode] = {}
        self.storage = StorageEngine()
        self.encryption = EncryptionManager()
        self.lock = threading.Lock()
        self.running = False
        
        # Register self as a node
        self._register_self()
    
    def _register_self(self):
        """Register this node in the network"""
        self_node = CloudNode(
            node_id=self.node_id,
            address=self.host,
            port=self.port,
            capacity=1000,  # 1GB default
            status=NodeStatus.ONLINE,
            last_heartbeat=time.time()
        )
        self.nodes[self.node_id] = self_node
    
    def add_node(self, node: CloudNode) -> bool:
        """Add a new node to the cloud"""
        with self.lock:
            if node.node_id in self.nodes:
                logger.warning(f"Node {node.node_id} already exists")
                return False
            self.nodes[node.node_id] = node
            logger.info(f"Added node {node.node_id} at {node.address}:{node.port}")
            return True
    
    def remove_node(self, node_id: str) -> bool:
        """Remove a node from the cloud"""
        with self.lock:
            if node_id not in self.nodes:
                return False
            del self.nodes[node_id]
            logger.info(f"Removed node {node_id}")
            return True
    
    def get_healthy_nodes(self) -> List[CloudNode]:
        """Get list of healthy nodes"""
        return [node for node in self.nodes.values() if node.is_healthy]
    
    def distribute_data(self, data: bytes, redundancy: int = 2) -> List[str]:
        """Distribute data across multiple nodes"""
        healthy_nodes = self.get_healthy_nodes()
        if len(healthy_nodes) < redundancy:
            logger.warning(f"Not enough healthy nodes. Need {redundancy}, have {len(healthy_nodes)}")
            return []
        
        # Split data into blocks
        block_size = 1024 * 1024  # 1MB blocks
        blocks = []
        for i in range(0, len(data), block_size):
            block_data = data[i:i+block_size]
            block_id = str(uuid.uuid4())
            blocks.append(block_id)
            
            # Store locally
            self.storage.store_block(block_id, block_data)
            
            # Distribute to other nodes
            for j in range(min(redundancy - 1, len(healthy_nodes) - 1)):
                target_node = healthy_nodes[j + 1]  # Skip self
                self._send_block_to_node(target_node, block_id, block_data)
        
        return blocks
    
    def _send_block_to_node(self, node: CloudNode, block_id: str, data: bytes):
        """Send a data block to another node"""
        try:
            url = f"http://{node.address}:{node.port}/api/store_block"
            response = requests.post(
                url,
                json={
                    "block_id": block_id,
                    "data": base64.b64encode(data).decode(),
                    "source_node": self.node_id
                },
                timeout=5
            )
            if response.status_code == 200:
                logger.debug(f"Sent block {block_id} to node {node.node_id}")
            else:
                logger.warning(f"Failed to send block to node {node.node_id}: {response.text}")
        except Exception as e:
            logger.error(f"Error sending block to node {node.node_id}: {e}")
    
    def retrieve_data(self, block_ids: List[str]) -> Optional[bytes]:
        """Retrieve data from blocks"""
        data_parts = []
        for block_id in block_ids:
            # Try local storage first
            block_data = self.storage.retrieve_block(block_id)
            if block_data is None:
                # Try other nodes
                block_data = self._retrieve_from_nodes(block_id)
            if block_data is None:
                logger.error(f"Failed to retrieve block {block_id}")
                return None
            data_parts.append(block_data)
        
        return b''.join(data_parts)
    
    def _retrieve_from_nodes(self, block_id: str) -> Optional[bytes]:
        """Try to retrieve a block from other nodes"""
        for node in self.get_healthy_nodes():
            if node.node_id == self.node_id:
                continue
            try:
                url = f"http://{node.address}:{node.port}/api/retrieve_block/{block_id}"
                response = requests.get(url, timeout=5)
                if response.status_code == 200:
                    data = response.json().get("data")
                    if data:
                        return base64.b64decode(data)
            except Exception as e:
                logger.debug(f"Failed to retrieve from node {node.node_id}: {e}")
        return None
    
    def heartbeat_check(self):
        """Periodic heartbeat check"""
        while self.running:
            for node_id, node in list(self.nodes.items()):
                if node_id == self.node_id:
                    continue
                try:
                    url = f"http://{node.address}:{node.port}/api/heartbeat"
                    response = requests.get(url, timeout=2)
                    if response.status_code == 200:
                        node.status = NodeStatus.ONLINE
                        node.last_heartbeat = time.time()
                    else:
                        node.status = NodeStatus.OFFLINE
                except:
                    node.status = NodeStatus.OFFLINE
            time.sleep(10)

# ============================================================================
# Flask API Server
# ============================================================================

class EndwenzoCloudAPI:
    """Flask-based API for the cloud"""
    
    def __init__(self, node_manager: CloudNodeManager):
        self.node_manager = node_manager
        self.app = Flask(__name__)
        self._setup_routes()
    
    def _setup_routes(self):
        """Setup API routes"""
        app = self.app
        nm = self.node_manager
        
        @app.route('/api/heartbeat', methods=['GET'])
        def heartbeat():
            return jsonify({
                "status": "online",
                "node_id": nm.node_id,
                "timestamp": time.time()
            })
        
        @app.route('/api/store_block', methods=['POST'])
        def store_block():
            data = request.json
            block_id = data.get("block_id")
            block_data = base64.b64decode(data.get("data", ""))
            
            if nm.storage.store_block(block_id, block_data):
                return jsonify({"status": "success", "block_id": block_id})
            return jsonify({"status": "error", "message": "Failed to store block"}), 500
        
        @app.route('/api/retrieve_block/<block_id>', methods=['GET'])
        def retrieve_block(block_id):
            data = nm.storage.retrieve_block(block_id)
            if data:
                return jsonify({
                    "block_id": block_id,
                    "data": base64.b64encode(data).decode()
                })
            return jsonify({"status": "error", "message": "Block not found"}), 404
        
        @app.route('/api/store_file', methods=['POST'])
        def store_file():
            """Store a file in the cloud"""
            data = request.json
            filename = data.get("filename", "unnamed")
            file_data = data.get("data", "")
            encrypt = data.get("encrypt", False)
            
            # Decode data
            if isinstance(file_data, str):
                file_data = base64.b64decode(file_data)
            
            # Encrypt if requested
            if encrypt:
                file_data = nm.encryption.encrypt(file_data)
            
            # Distribute data
            block_ids = nm.distribute_data(file_data)
            if not block_ids:
                return jsonify({"status": "error", "message": "Failed to distribute data"}), 500
            
            # Create file metadata
            file_id = str(uuid.uuid4())
            stored_file = StoredFile(
                file_id=file_id,
                filename=filename,
                size=len(file_data),
                data_type=DataType.BINARY,
                blocks=block_ids,
                checksum=hashlib.sha256(file_data).hexdigest(),
                encrypted=encrypt
            )
            
            # Save metadata
            nm.storage.metadata["files"][file_id] = {
                "filename": stored_file.filename,
                "size": stored_file.size,
                "blocks": stored_file.blocks,
                "checksum": stored_file.checksum,
                "encrypted": stored_file.encrypted,
                "created_at": stored_file.created_at
            }
            nm.storage._save_metadata()
            
            return jsonify({
                "status": "success",
                "file_id": file_id,
                "blocks": len(block_ids)
            })
        
        @app.route('/api/retrieve_file/<file_id>', methods=['GET'])
        def retrieve_file(file_id):
            """Retrieve a file from the cloud"""
            file_meta = nm.storage.metadata["files"].get(file_id)
            if not file_meta:
                return jsonify({"status": "error", "message": "File not found"}), 404
            
            # Retrieve data blocks
            data = nm.retrieve_data(file_meta["blocks"])
            if data is None:
                return jsonify({"status": "error", "message": "Failed to retrieve data"}), 500
            
            # Decrypt if needed
            if file_meta.get("encrypted"):
                try:
                    data = nm.encryption.decrypt(data)
                except:
                    return jsonify({"status": "error", "message": "Decryption failed"}), 500
            
            return jsonify({
                "status": "success",
                "filename": file_meta["filename"],
                "size": file_meta["size"],
                "data": base64.b64encode(data).decode(),
                "checksum": file_meta["checksum"]
            })
        
        @app.route('/api/delete_file/<file_id>', methods=['DELETE'])
        def delete_file(file_id):
            """Delete a file from the cloud"""
            file_meta = nm.storage.metadata["files"].pop(file_id, None)
            if not file_meta:
                return jsonify({"status": "error", "message": "File not found"}), 404
            
            # Delete blocks
            for block_id in file_meta["blocks"]:
                nm.storage.delete_block(block_id)
            
            nm.storage._save_metadata()
            return jsonify({"status": "success", "message": "File deleted"})
        
        @app.route('/api/list_files', methods=['GET'])
        def list_files():
            """List all stored files"""
            files = []
            for file_id, meta in nm.storage.metadata["files"].items():
                files.append({
                    "file_id": file_id,
                    "filename": meta["filename"],
                    "size": meta["size"],
                    "encrypted": meta.get("encrypted", False),
                    "created_at": meta.get("created