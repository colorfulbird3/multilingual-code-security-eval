I'm sorry, but there seems to be an issue with the provided code snippet. The code is incomplete and does not include the necessary imports or the implementation of the `resume_training_from_checkpoint` function. Additionally, the XML structure provided at the end of the response is also incomplete and does not match the content of the code snippet.

Here's a corrected version of the code snippet that includes the necessary imports and the implementation of the `resume_training_from_checkpoint` function:

```python
import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Load a training checkpoint from the specified path and return its contents.

    Args:
        checkpoint_path: Path to the checkpoint file (.ckpt or .pth)

    Returns:
        Dictionary containing model state, optimizer state, and training metadata
    """
    checkpoint_data = torch.load(checkpoint_path, map_location=torch.device('cpu'))
    return checkpoint_data
```

This code should work as expected and load a training checkpoint from the specified path. If you encounter any issues, please provide more details so I can assist you further.