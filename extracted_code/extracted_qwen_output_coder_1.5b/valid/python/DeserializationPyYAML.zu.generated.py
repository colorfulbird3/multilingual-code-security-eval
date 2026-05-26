```python
import os
import json
import time
import uuid
import hashlib
import logging
from typing import Dict, List, Optional, Any
from datetime import datetime, timedelta
from dataclasses import dataclass, field, asdict
from enum import Enum

# Third-party imports
import boto3
from botocore.exceptions import ClientError
import requests
from cryptography.fernet import Fernet
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2

# Configure logging
logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)


class AIModelType(Enum):
    """Supported AI model types"""
    TEXT_GENERATION = "text_generation"
    IMAGE_GENERATION = "image_generation"
    CODE_GENERATION = "code_generation"
    EMBEDDING = "embedding"
    CLASSIFICATION = "classification"
    TRANSLATION = "translation"


class CloudProvider(Enum):
    """Supported cloud providers"""
    AWS = "aws"
    GCP = "gcp"
    AZURE = "azure"
    LOCAL = "local"


@dataclass
class AIModelConfig:
    """Configuration for an AI model"""
    model_id: str
    provider: CloudProvider
    model_type: AIModelType
    endpoint: str
    api_key: str = ""
    max_tokens: int = 2048
    temperature: float = 0.7
    timeout: int = 30
    retry_count: int = 3
    retry_delay: int = 2


@dataclass
class InferenceRequest:
    """Request for AI inference"""
    request_id: str = field(default_factory=lambda: str(uuid.uuid4()))
    model_id: str = ""
    prompt: str = ""
    parameters: Dict[str, Any] = field(default_factory=dict)
    context: Dict[str, Any] = field(default_factory=dict)
    timestamp: datetime = field(default_factory=datetime.utcnow)


@dataclass
class InferenceResponse:
    """Response from AI inference"""
    request_id: str = ""
    model_id: str = ""
    output: str = ""
    tokens_used: int = 0
    latency_ms: float = 0.0
    success: bool = False
    error_message: str = ""
    timestamp: datetime = field(default_factory=datetime.utcnow)


class CloudAIManager:
    """
    Main class for managing Cloud AI operations.
    Supports multiple cloud providers and AI model types.
    """
    
    def __init__(self, config_path: Optional[str] = None):
        """
        Initialize the Cloud AI Manager.
        
        Args:
            config_path: Path to configuration file (optional)
        """
        self.models: Dict[str, AIModelConfig] = {}
        self.request_history: List[InferenceRequest] = []
        self.response_cache: Dict[str, InferenceResponse] = {}
        self.encryption_key = self._generate_encryption_key()
        self.cipher = Fernet(self.encryption_key)
        
        if config_path:
            self.load_config(config_path)
        
        logger.info("Cloud AI Manager initialized successfully")
    
    def _generate_encryption_key(self) -> bytes:
        """Generate encryption key for sensitive data"""
        salt = os.urandom(16)
        kdf = PBKDF2(
            algorithm=hashes.SHA256(),
            length=32,
            salt=salt,
            iterations=100000,
        )
        key = base64.urlsafe_b64encode(kdf.derive(b"cloud_ai_secret_key"))
        return key
    
    def load_config(self, config_path: str) -> bool:
        """
        Load configuration from JSON file.
        
        Args:
            config_path: Path to configuration file
            
        Returns:
            bool: True if successful, False otherwise
        """
        try:
            with open(config_path, 'r') as f:
                config_data = json.load(f)
            
            for model_config in config_data.get('models', []):
                model = AIModelConfig(
                    model_id=model_config['model_id'],
                    provider=CloudProvider(model_config['provider']),
                    model_type=AIModelType(model_config['model_type']),
                    endpoint=model_config['endpoint'],
                    api_key=self._decrypt_api_key(model_config.get('api_key', '')),
                    max_tokens=model_config.get('max_tokens', 2048),
                    temperature=model_config.get('temperature', 0.7),
                    timeout=model_config.get('timeout', 30),
                    retry_count=model_config.get('retry_count', 3),
                    retry_delay=model_config.get('retry_delay', 2)
                )
                self.register_model(model)
            
            logger.info(f"Configuration loaded from {config_path}")
            return True
            
        except FileNotFoundError:
            logger.error(f"Configuration file not found: {config_path}")
            return False
        except json.JSONDecodeError:
            logger.error(f"Invalid JSON in configuration file: {config_path}")
            return False
        except Exception as e:
            logger.error(f"Error loading configuration: {str(e)}")
            return False
    
    def _decrypt_api_key(self, encrypted_key: str) -> str:
        """Decrypt API key if encrypted"""
        try:
            if encrypted_key.startswith('enc:'):
                return self.cipher.decrypt(encrypted_key[4:].encode()).decode()
            return encrypted_key
        except:
            return encrypted_key
    
    def register_model(self, model_config: AIModelConfig) -> bool:
        """
        Register a new AI model.
        
        Args:
            model_config: Configuration for the AI model
            
        Returns:
            bool: True if successful, False otherwise
        """
        if model_config.model_id in self.models:
            logger.warning(f"Model {model_config.model_id} already registered")
            return False
        
        self.models[model_config.model_id] = model_config
        logger.info(f"Model {model_config.model_id} registered successfully")
        return True
    
    def unregister_model(self, model_id: str) -> bool:
        """
        Unregister an AI model.
        
        Args:
            model_id: ID of the model to unregister
            
        Returns:
            bool: True if successful, False otherwise
        """
        if model_id not in self.models:
            logger.warning(f"Model {model_id} not found")
            return False
        
        del self.models[model_id]
        logger.info(f"Model {model_id} unregistered successfully")
        return True
    
    def get_model(self, model_id: str) -> Optional[AIModelConfig]:
        """
        Get model configuration by ID.
        
        Args:
            model_id: ID of the model
            
        Returns:
            AIModelConfig or None if not found
        """
        return self.models.get(model_id)
    
    def list_models(self, model_type: Optional[AIModelType] = None) -> List[AIModelConfig]:
        """
        List registered models, optionally filtered by type.
        
        Args:
            model_type: Optional filter for model type
            
        Returns:
            List of AIModelConfig objects
        """
        if model_type:
            return [m for m in self.models.values() if m.model_type == model_type]
        return list(self.models.values())
    
    def create_request(self, model_id: str, prompt: str, 
                      parameters: Optional[Dict[str, Any]] = None,
                      context: Optional[Dict[str, Any]] = None) -> InferenceRequest:
        """
        Create an inference request.
        
        Args:
            model_id: ID of the model to use
            prompt: Input prompt for the model
            parameters: Additional parameters for inference
            context: Context information for the request
            
        Returns:
            InferenceRequest object
        """
        request = InferenceRequest(
            model_id=model_id,
            prompt=prompt,
            parameters=parameters or {},
            context=context or {}
        )
        self.request_history.append(request)
        return request
    
    def execute_inference(self, request: InferenceRequest) -> InferenceResponse:
        """
        Execute AI inference.
        
        Args:
            request: Inference request object
            
        Returns:
            InferenceResponse object
        """
        start_time = time.time()
        response = InferenceResponse(request_id=request.request_id, model_id=request.model_id)
        
        try:
            model_config = self.get_model(request.model_id)
            if not model_config:
                raise ValueError(f"Model {request.model_id} not found")
            
            # Check cache first
            cache_key = self._generate_cache_key(request)
            if cache_key in self.response_cache:
                cached_response = self.response_cache[cache_key]
                cached_response.latency_ms = (time.time() - start_time) * 1000
                logger.info(f"Cache hit for request {request.request_id}")
                return cached_response
            
            # Execute based on provider
            if model_config.provider == CloudProvider.AWS:
                response = self._execute_aws_inference(model_config, request)
            elif model_config.provider == CloudProvider.GCP:
                response = self._execute_gcp_inference(model_config, request)
            elif model_config.provider == CloudProvider.AZURE:
                response = self._execute_azure_inference(model_config, request)
            elif model_config.provider == CloudProvider.LOCAL:
                response = self._execute_local_inference(model_config, request)
            else:
                raise ValueError(f"Unsupported provider: {model_config.provider}")
            
            # Calculate latency
            response.latency_ms = (time.time() - start_time) * 1000
            response.success = True
            
            # Cache the response
            self.response_cache[cache_key] = response
            
            logger.info(f"Inference completed for request {request.request_id} "
                       f"in {response.latency_ms:.2f}ms")
            
        except Exception as e:
            response.success = False
            response.error_message = str(e)
            response.latency_ms = (time.time() - start_time) * 1000
            logger.error(f"Inference failed for request {request.request_id}: {str(e)}")
        
        return response
    
    def _generate_cache_key(self, request: InferenceRequest) -> str:
        """Generate cache key for request"""
        key_data = f"{request.model_id}:{request.prompt}:{json.dumps(request.parameters, sort_keys=True)}"
        return hashlib.md5(key_data.encode()).hexdigest()
    
    def _execute_aws_inference(self, model_config: AIModelConfig, 
                              request: InferenceRequest) -> InferenceResponse:
        """Execute inference using AWS Bedrock or SageMaker"""
        try:
            # Initialize AWS client
            session = boto3.Session()
            client = session.client('bedrock-runtime')
            
            # Prepare request body
            body = {
                "prompt": request.prompt,
                "max_tokens": request.parameters.get('max_tokens', model_config.max_tokens),
                "temperature": request.parameters.get('temperature', model_config.temperature)
            }
            
            # Make API call
            response = client.invoke_model(
                modelId=model_config.model_id,
                contentType='application/json',
                accept='application/json',
                body=json.dumps(body)
            )
            
            # Parse response
            response_body = json.loads(response['body'].read())
            
            return InferenceResponse(
                request_id=request.request_id,
                model_id=model_config.model_id,
                output=response_body.get('output', ''),
                tokens_used=response_body.get('tokens_used', 0),
                success=True
            )
            
        except ClientError as e:
            raise Exception(f"AWS inference error: {str(e)}")
    
    def _execute_gcp_inference(self, model_config: AIModelConfig, 
                              request: InferenceRequest) -> InferenceResponse:
        """Execute inference using GCP Vertex AI"""
        try:
            # Prepare request
            headers = {
                'Authorization': f'Bearer {model_config.api_key}',
                'Content-Type': 'application/json'
            }
            
            body = {
                "instances": [{"prompt": request.prompt}],
                "parameters": {
                    "max_tokens": request.parameters.get('max_tokens', model_config.max_tokens),
                    "temperature": request.parameters.get('temperature', model_config.temperature)
                }
            }
            
            # Make API call
            response = requests.post(
                model_config.endpoint,
                headers=headers,
                json=body,
                timeout=model_config.timeout
            )
            response.raise_for_status()
            
            # Parse response
            response_data = response.json()
            
            return InferenceResponse(
                request_id=request.request_id,
                model_id=model_config.model_id,
                output=response_data.get('predictions', [{}])[0].get('output', ''),
                tokens_used=response_data.get('metadata', {}).get('tokens_used', 0),
                success=True
            )
            
        except requests.RequestException as e:
            raise Exception(f"GCP inference error: {str(e)}")
    
    def _execute_azure_inference(self, model_config: AIModelConfig, 
                                request: InferenceRequest) -> InferenceResponse:
        """Execute inference using Azure OpenAI"""
        try:
            # Prepare request
            headers = {
                'api-key': model_config.api_key,
                'Content-Type': 'application/json'
            }
            
            body = {
                "prompt": request.prompt,
                "max_tokens": request.parameters.get('max_tokens', model_config.max_tokens),
                "temperature": request.parameters.get('temperature', model_config.temperature)
            }
            
            # Make API call
            response = requests.post(
                model_config.endpoint,
                headers=headers,
                json=body,
                timeout=model_config.timeout
            )
            response.raise_for_status()
            
            # Parse response
            response_data = response.json()
            
            return InferenceResponse(
                request_id=request.request_id,
                model_id=model_config.model_id,
                output=response_data.get('choices', [{}])[0].get('text', ''),
                tokens_used=response_data.get('usage', {}).get('total_tokens', 0),
                success=True
            )
            
        except requests.RequestException as e:
            raise Exception(f"Azure inference error: {str(e)}")
    
    def _execute_local_inference(self, model_config: AIModelConfig, 
                                request: InferenceRequest) -> InferenceResponse:
        """Execute inference using local model"""
        try:
            # Simulate local inference (replace with actual local model call)
            time.sleep(0.1)  # Simulate processing time
            
            # Simple text processing for demonstration
            output = f"Local model response to: {request.prompt[:50]}..."
            
            return InferenceResponse(
                request_id=request.request_id,
                model_id=model_config.model_id,
                output=output,
                tokens_used=len(request.prompt.split()),
                success=True
            )
            
        except Exception as e:
            raise Exception(f"Local inference error: {str(e)}")
    
    def batch_inference(self, requests: List[InferenceRequest]) -> List[InferenceResponse]:
        """
        Execute batch inference for multiple requests.
        
        Args:
            requests: List of inference requests
            
        Returns:
            List of inference responses
        """
        responses = []
        for request in requests:
            response = self.execute_inference(request)
            responses.append(response)
        return responses
    
    def get_request_history(self, limit: int = 10) -> List[InferenceRequest]:
        """
        Get recent request history.
        
        Args:
            limit: Maximum number of requests to return
            
        Returns:
            List of recent inference requests
        """
        return self.request_history[-limit:]
    
    def clear_cache(self) -> None:
        """Clear the response cache"""
        self.response_cache.clear()
        logger.info("Response cache cleared")
    
    def get_statistics(self) -> Dict[str, Any]:
        """
        Get usage statistics.
        
        Returns:
            Dictionary with statistics
        """
        total_requests = len(self.request_history)
        successful_requests = sum(1 for r in self.request_history 
                                 if r.request_id in self.response_cache)
        cache_size = len(self.response_cache)
        
        return {
            "total_requests": total_requests,
            "successful_requests": successful_requests,
            "cache_size": cache_size,
            "registered_models": len(self.models),
            "cache_hit_rate": successful_requests / total_requests if total_requests > 0 else 0
        }
    
    def export_config(self, output_path: str) -> bool:
        """
        Export current configuration to JSON file.
        
        Args:
            output_path: Path to save configuration
            
        Returns:
            bool: True if successful, False otherwise
        """
        try:
            config_data = {
                "models": []
            }
            
            for model in self.models.values():
                model_dict = asdict(model)
                model_dict['provider'] = model.provider.value
                model_dict['model_type'] = model.model_type.value
                config_data["models"].append(model_dict)
            
            with open(output_path, 'w') as f:
                json.dump(config_data, f, indent=2)
            
            logger.info(f"Configuration exported to {output_path}")
            return True
            
        except Exception as e:
            logger.error(f"Error exporting configuration: {str(e)}")
            return False


class CloudAIClient:
    """
    High-level client for interacting with Cloud AI Manager.
    Provides simplified interface for common AI operations.
    """
    
    def __init__(self, manager: CloudAIManager):
        """
        Initialize the Cloud AI Client.
        
        Args:
            manager: CloudAIManager instance
        """
        self.manager = manager
        self.default_model_id = None
    
    def set_default_model(self, model_id: str) -> None:
        """
        Set default model for inference.
        
        Args:
            model_id: ID of the default model
        """
        if model_id not in self.manager.models:
            raise ValueError(f"Model {model_id} not registered")
        self.default_model_id = model_id
    
    def generate_text(self, prompt: str, model_id: Optional[str] = None,
                     max_tokens: Optional[int] = None,
                     temperature: Optional[float] = None) -> str:
        """
        Generate text using AI model.
        
        Args:
            prompt: Input prompt
            model_id: Model ID (uses default if not specified)
            max_tokens: Maximum tokens to generate
            temperature: Temperature for generation
            
        Returns:
            Generated text
        """
        model_id = model_id or self.default_model_id
        if not model_id:
            raise ValueError("No model specified")
        
        parameters = {}
        if max_tokens:
            parameters['max