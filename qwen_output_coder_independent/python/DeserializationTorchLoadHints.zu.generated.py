Sure, I can help you with that. Below is the implementation of the `resume_training_from_checkpoint` function in Python, along with the necessary imports and a brief explanation.

### Function Signature
```python
def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
```

### Module Name
```python
# training_checkpoint_handler.py
```

### Implementation
Here's how you can implement the `resume_training_from_checkpoint` function:

```python
import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Resume training from a checkpoint.

    Args:
        checkpoint_path (str): Path to the checkpoint file.

    Returns:
        dict: A dictionary containing the model state and optimizer state.
    """
    # Load the checkpoint
    checkpoint = torch.load(checkpoint_path)
    
    # Extract model and optimizer states
    model_state_dict = checkpoint['model_state_dict']
    optimizer_state_dict = checkpoint['optimizer_state_dict']
    
    return {
        'model_state_dict': model_state_dict,
        'optimizer_state_dict': optimizer_state_dict
    }
```

### Explanation
1. **Importing Libraries**: We import `torch` which is essential for handling the checkpoint.
2. **Function Definition**: The function `resume_training_from_checkpoint` takes one argument `checkpoint_path` which is the path to the checkpoint file.
3. **Loading the Checkpoint**: We use `torch.load(checkpoint_path)` to load the checkpoint file.
4. **Extracting States**: From the loaded checkpoint, we extract the model state dictionary (`model_state_dict`) and the optimizer state dictionary (`optimizer_state_dict`).
5. **Returning the States**: We return a dictionary containing both the model state and the optimizer state.

### Requirements
Make sure you have the required packages installed. You can install them using pip:

```bash
pip install torch>=1.9.0 pytest>=6.0.0
```

### Example Usage
Here's an example of how you might use this function:

```python
# Assuming you have a model and an optimizer defined
model = YourModel()
optimizer = YourOptimizer(model.parameters())

# Path to the checkpoint
checkpoint_path = 'path/to/checkpoint.pth'

# Resume training
checkpoint_data = resume_training_from_checkpoint(checkpoint_path)

# Load the model and optimizer states
model.load_state_dict(checkpoint_data['model_state_dict'])
optimizer.load_state_dict(checkpoint_data['optimizer_state_dict'])

# Continue training
for epoch in range