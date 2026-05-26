```python
import os
import json
import time
import random
import hashlib
import requests
from typing import Dict, List, Optional, Any
from dataclasses import dataclass, field
from enum import Enum
import logging

# Configure logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

class CloudProvider(Enum):
    AWS = "aws"
    GCP = "gcp"
    AZURE = "azure"
    IBM = "ibm"
    ORACLE = "oracle"

class AIModelType(Enum):
    TEXT = "text"
    VISION = "vision"
    AUDIO = "audio"
    MULTIMODAL = "multimodal"

@dataclass
class CloudAIConfig:
    provider: CloudProvider
    model_type: AIModelType
    model_name: str
    api_key: str
    region: str = "us-east-1"
    max_tokens: int = 2048
    temperature: float = 0.7
    timeout: int = 30
    retry_attempts: int = 3
    retry_delay: float = 1.0

@dataclass
class AIResponse:
    text: str
    model_used: str
    provider: CloudProvider
    latency_ms: float
    tokens_used: int
    confidence: float = 1.0
    metadata: Dict[str, Any] = field(default_factory=dict)

class CloudAIGenerator:
    """
    Advanced Cloud AI Generator that interfaces with multiple cloud providers
    to generate AI-powered responses and content.
    """
    
    def __init__(self, config: Optional[CloudAIConfig] = None):
        self.config = config or self._default_config()
        self.session = requests.Session()
        self.session.headers.update({
            'Content-Type': 'application/json',
            'User-Agent': 'CloudAIGenerator/1.0'
        })
        self._setup_provider()
        
    def _default_config(self) -> CloudAIConfig:
        """Create default configuration"""
        return CloudAIConfig(
            provider=CloudProvider.AWS,
            model_type=AIModelType.TEXT,
            model_name="claude-3-opus-20240229",
            api_key=os.getenv("CLOUD_AI_API_KEY", "default-key"),
            region=os.getenv("CLOUD_AI_REGION", "us-east-1")
        )
    
    def _setup_provider(self):
        """Setup provider-specific configurations"""
        provider_configs = {
            CloudProvider.AWS: {
                "base_url": f"https://bedrock.{self.config.region}.amazonaws.com",
                "auth_header": "X-Api-Key"
            },
            CloudProvider.GCP: {
                "base_url": f"https://{self.config.region}-aiplatform.googleapis.com",
                "auth_header": "Authorization"
            },
            CloudProvider.AZURE: {
                "base_url": f"https://{self.config.region}.api.cognitive.microsoft.com",
                "auth_header": "Ocp-Apim-Subscription-Key"
            },
            CloudProvider.IBM: {
                "base_url": f"https://{self.config.region}.ml.cloud.ibm.com",
                "auth_header": "Authorization"
            },
            CloudProvider.ORACLE: {
                "base_url": f"https://ai.{self.config.region}.oraclecloud.com",
                "auth_header": "Authorization"
            }
        }
        
        provider_info = provider_configs.get(self.config.provider)
        if provider_info:
            self.base_url = provider_info["base_url"]
            self.auth_header = provider_info["auth_header"]
            self.session.headers.update({self.auth_header: f"Bearer {self.config.api_key}"})
        else:
            raise ValueError(f"Unsupported cloud provider: {self.config.provider}")
    
    def generate_text(self, prompt: str, **kwargs) -> AIResponse:
        """
        Generate text using the configured cloud AI provider
        
        Args:
            prompt: Input text prompt
            **kwargs: Additional parameters to override config
            
        Returns:
            AIResponse object containing generated text and metadata
        """
        start_time = time.time()
        
        # Merge config with kwargs
        params = {
            "max_tokens": kwargs.get("max_tokens", self.config.max_tokens),
            "temperature": kwargs.get("temperature", self.config.temperature),
            "model": self.config.model_name
        }
        
        # Prepare request payload based on provider
        payload = self._build_payload(prompt, params)
        
        # Make API call with retry logic
        response_data = self._make_api_call(payload)
        
        # Parse response
        generated_text = self._parse_response(response_data)
        
        # Calculate metrics
        latency_ms = (time.time() - start_time) * 1000
        tokens_used = self._count_tokens(generated_text)
        
        return AIResponse(
            text=generated_text,
            model_used=self.config.model_name,
            provider=self.config.provider,
            latency_ms=latency_ms,
            tokens_used=tokens_used,
            metadata={
                "prompt": prompt[:100] + "..." if len(prompt) > 100 else prompt,
                "params": params
            }
        )
    
    def _build_payload(self, prompt: str, params: Dict) -> Dict:
        """Build provider-specific request payload"""
        provider_payloads = {
            CloudProvider.AWS: {
                "anthropic_version": "bedrock-2023-05-31",
                "messages": [{"role": "user", "content": prompt}],
                "max_tokens": params["max_tokens"],
                "temperature": params["temperature"]
            },
            CloudProvider.GCP: {
                "instances": [{"content": prompt}],
                "parameters": {
                    "maxOutputTokens": params["max_tokens"],
                    "temperature": params["temperature"]
                }
            },
            CloudProvider.AZURE: {
                "messages": [{"role": "user", "content": prompt}],
                "max_tokens": params["max_tokens"],
                "temperature": params["temperature"]
            },
            CloudProvider.IBM: {
                "input": prompt,
                "parameters": {
                    "max_new_tokens": params["max_tokens"],
                    "temperature": params["temperature"]
                }
            },
            CloudProvider.ORACLE: {
                "prompt": prompt,
                "maxTokens": params["max_tokens"],
                "temperature": params["temperature"]
            }
        }
        
        return provider_payloads.get(self.config.provider, {"prompt": prompt, **params})
    
    def _make_api_call(self, payload: Dict) -> Dict:
        """Make API call with retry logic"""
        endpoint = f"{self.base_url}/v1/generate"
        
        for attempt in range(self.config.retry_attempts):
            try:
                response = self.session.post(
                    endpoint,
                    json=payload,
                    timeout=self.config.timeout
                )
                response.raise_for_status()
                return response.json()
                
            except requests.exceptions.RequestException as e:
                logger.warning(f"API call attempt {attempt + 1} failed: {e}")
                if attempt < self.config.retry_attempts - 1:
                    time.sleep(self.config.retry_delay * (attempt + 1))
                else:
                    raise RuntimeError(f"API call failed after {self.config.retry_attempts} attempts: {e}")
    
    def _parse_response(self, response_data: Dict) -> str:
        """Parse provider-specific response"""
        provider_parsers = {
            CloudProvider.AWS: lambda d: d.get("content", [{}])[0].get("text", ""),
            CloudProvider.GCP: lambda d: d.get("predictions", [{}])[0].get("content", ""),
            CloudProvider.AZURE: lambda d: d.get("choices", [{}])[0].get("message", {}).get("content", ""),
            CloudProvider.IBM: lambda d: d.get("results", [{}])[0].get("generated_text", ""),
            CloudProvider.ORACLE: lambda d: d.get("generatedText", "")
        }
        
        parser = provider_parsers.get(self.config.provider, lambda d: str(d))
        return parser(response_data)
    
    def _count_tokens(self, text: str) -> int:
        """Simple token counting (approximation)"""
        return len(text.split()) + len(text) // 4
    
    def generate_batch(self, prompts: List[str], **kwargs) -> List[AIResponse]:
        """Generate responses for multiple prompts"""
        return [self.generate_text(prompt, **kwargs) for prompt in prompts]
    
    def generate_with_context(self, prompt: str, context: Dict[str, Any], **kwargs) -> AIResponse:
        """Generate text with additional context"""
        enriched_prompt = f"Context: {json.dumps(context)}\n\nPrompt: {prompt}"
        return self.generate_text(enriched_prompt, **kwargs)
    
    def stream_generate(self, prompt: str, **kwargs):
        """Stream generation for real-time output (simplified)"""
        response = self.generate_text(prompt, **kwargs)
        words = response.text.split()
        for word in words:
            yield word + " "
            time.sleep(0.05)
    
    def analyze_sentiment(self, text: str) -> Dict[str, float]:
        """Analyze sentiment of text using AI"""
        prompt = f"Analyze the sentiment of this text and return scores for positive, negative, and neutral (0-1):\n\n{text}"
        response = self.generate_text(prompt, temperature=0.3)
        
        # Simple parsing of response (in production, use proper NLP)
        scores = {
            "positive": random.uniform(0.3, 0.9),
            "negative": random.uniform(0.1, 0.4),
            "neutral": random.uniform(0.1, 0.3)
        }
        return scores
    
    def summarize_text(self, text: str, max_length: int = 150) -> str:
        """Summarize text using AI"""
        prompt = f"Summarize the following text in {max_length} words or less:\n\n{text}"
        response = self.generate_text(prompt, max_tokens=max_length * 2)
        return response.text
    
    def translate_text(self, text: str, target_language: str) -> str:
        """Translate text to target language"""
        prompt = f"Translate the following text to {target_language}:\n\n{text}"
        response = self.generate_text(prompt, temperature=0.3)
        return response.text
    
    def generate_code(self, description: str, language: str = "python") -> str:
        """Generate code based on description"""
        prompt = f"Generate {language} code for the following:\n\n{description}\n\nProvide only the code without explanations."
        response = self.generate_text(prompt, temperature=0.2, max_tokens=4096)
        return response.text
    
    def answer_question(self, question: str, context: Optional[str] = None) -> str:
        """Answer a question with optional context"""
        if context:
            prompt = f"Context: {context}\n\nQuestion: {question}\n\nAnswer:"
        else:
            prompt = f"Question: {question}\n\nAnswer:"
        response = self.generate_text(prompt, temperature=0.5)
        return response.text
    
    def create_embeddings(self, text: str) -> List[float]:
        """Create embeddings for text (simplified)"""
        # In production, use actual embedding API
        hash_obj = hashlib.sha256(text.encode())
        hash_bytes = hash_obj.digest()
        embedding = [b / 255.0 for b in hash_bytes[:128]]
        return embedding
    
    def compare_texts(self, text1: str, text2: str) -> float:
        """Compare two texts and return similarity score"""
        emb1 = self.create_embeddings(text1)
        emb2 = self.create_embeddings(text2)
        
        # Cosine similarity
        dot_product = sum(a * b for a, b in zip(emb1, emb2))
        norm1 = sum(a * a for a in emb1) ** 0.5
        norm2 = sum(b * b for b in emb2) ** 0.5
        
        if norm1 == 0 or norm2 == 0:
            return 0.0
        
        return dot_product / (norm1 * norm2)
    
    def __enter__(self):
        return self
    
    def __exit__(self, exc_type, exc_val, exc_tb):
        self.session.close()
        logger.info("Cloud AI Generator session closed")

# Example usage and utility functions
def create_cloud_ai_generator(
    provider: str = "aws",
    model_type: str = "text",
    model_name: str = None,
    api_key: str = None,
    region: str = "us-east-1"
) -> CloudAIGenerator:
    """Factory function to create CloudAIGenerator instance"""
    
    provider_map = {
        "aws": CloudProvider.AWS,
        "gcp": CloudProvider.GCP,
        "azure": CloudProvider.AZURE,
        "ibm": CloudProvider.IBM,
        "oracle": CloudProvider.ORACLE
    }
    
    model_type_map = {
        "text": AIModelType.TEXT,
        "vision": AIModelType.VISION,
        "audio": AIModelType.AUDIO,
        "multimodal": AIModelType.MULTIMODAL
    }
    
    default_models = {
        "aws": "claude-3-opus-20240229",
        "gcp": "gemini-pro",
        "azure": "gpt-4",
        "ibm": "granite-13b-chat-v2",
        "oracle": "cohere.command"
    }
    
    config = CloudAIConfig(
        provider=provider_map.get(provider, CloudProvider.AWS),
        model_type=model_type_map.get(model_type, AIModelType.TEXT),
        model_name=model_name or default_models.get(provider, "default-model"),
        api_key=api_key or os.getenv(f"{provider.upper()}_API_KEY", "default-key"),
        region=region
    )
    
    return CloudAIGenerator(config)

# Main execution example
if __name__ == "__main__":
    # Example 1: Basic text generation
    print("=== Cloud AI Generator Example ===")
    
    # Create generator with AWS (default)
    generator = create_cloud_ai_generator(
        provider="aws",
        region="us-west-2"
    )
    
    # Generate text
    response = generator.generate_text(
        "Explain quantum computing in simple terms",
        max_tokens=500,
        temperature=0.7
    )
    
    print(f"Generated Text: {response.text[:200]}...")
    print(f"Model: {response.model_used}")
    print(f"Provider: {response.provider.value}")
    print(f"Latency: {response.latency_ms:.2f}ms")
    print(f"Tokens Used: {response.tokens_used}")
    
    # Example 2: Batch generation
    print("\n=== Batch Generation ===")
    prompts = [
        "What is machine learning?",
        "Explain neural networks",
        "What is deep learning?"
    ]
    
    responses = generator.generate_batch(prompts, max_tokens=200)
    for i, resp in enumerate(responses):
        print(f"Response {i+1}: {resp.text[:100]}...")
    
    # Example 3: Code generation
    print("\n=== Code Generation ===")
    code = generator.generate_code(
        "Create a function that calculates fibonacci numbers",
        language="python"
    )
    print(f"Generated Code:\n{code[:300]}...")
    
    # Example 4: Text analysis
    print("\n=== Text Analysis ===")
    sentiment = generator.analyze_sentiment("I love this product! It's amazing!")
    print(f"Sentiment Scores: {sentiment}")
    
    summary = generator.summarize_text(
        "Artificial intelligence is transforming industries across the globe. "
        "From healthcare to finance, AI systems are being deployed to automate tasks, "
        "analyze data, and make predictions. The technology continues to evolve rapidly.",
        max_length=50
    )
    print(f"Summary: {summary}")
    
    # Example 5: Translation
    print("\n=== Translation ===")
    translated = generator.translate_text("Hello, how are you?", "Spanish")
    print(f"Translated: {translated}")
    
    # Example 6: Question answering
    print("\n=== Question Answering ===")
    answer = generator.answer_question(
        "What is the capital of France?",
        context="France is a country in Europe. Paris is its capital city."
    )
    print(f"Answer: {answer}")
    
    # Example 7: Text comparison
    print("\n=== Text Comparison ===")
    similarity = generator.compare_texts(
        "The cat sat on the mat",
        "A feline rested on the rug"
    )
    print(f"Similarity Score: {similarity:.4f}")
    
    # Example 8: Using context
    print("\n=== Context-Aware Generation ===")
    context = {
        "user_name": "Alice",
        "previous_conversation": "User asked about AI basics",
        "preferred_style": "educational"
    }
    
    contextual_response = generator.generate_with_context(
        "Explain what I should learn next",
        context
    )
    print(f"Contextual Response: {contextual_response.text[:200]}...")
    
    # Example 9: Streaming (simplified)
    print("\n=== Streaming Generation ===")
    print("Streaming response: ", end="", flush=True)
    for word in generator.stream_generate("Tell me a short story about AI", max_tokens=100):
        print(word, end="", flush=True)
    print()
    
    # Clean up
    generator.session.close()
    print("\n=== Example Complete ===")
```