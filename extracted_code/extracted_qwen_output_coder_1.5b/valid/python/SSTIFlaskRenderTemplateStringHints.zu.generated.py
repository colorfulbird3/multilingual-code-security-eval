```python
import google.cloud.aiplatform as aiplatform

# Initialize the AI Platform client
aiplatform.init(project='your-project-id', location='us-central1')

# Example: List available models
models = aiplatform.Model.list()
for model in models:
    print(model.display_name)
```