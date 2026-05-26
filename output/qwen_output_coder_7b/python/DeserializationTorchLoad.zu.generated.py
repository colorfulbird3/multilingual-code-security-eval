Here's the implementation of the `resume_training_from_checkpoint` function in Python:

```python
import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Resume training from a checkpoint.

    Args:
        checkpoint_path (str): Path to the checkpoint file (.ckpt or .pth).

    Returns:
        dict: A dictionary containing the model state_dict, optimizer state_dict, and epoch number.
    """
    # Load the checkpoint
    checkpoint = torch.load(checkpoint_path)

    # Extract the model state_dict, optimizer state_dict, and epoch number
    model_state_dict = checkpoint['model_state_dict']
    optimizer_state_dict = checkpoint['optimizer_state_dict']
    epoch = checkpoint['epoch']

    return {
        'model_state_dict': model_state_dict,
        'optimizer_state_dict': optimizer_state_dict,
        'epoch': epoch
    }
```

This function takes a checkpoint path as input and loads the checkpoint using `torch.load()`. It then extracts the model state_dict, optimizer state_dict, and epoch number from the checkpoint and returns them as a dictionary.

To use this function, you can call it with the path to your checkpoint file:

```python
checkpoint_path = '/data/runs/exp1/checkpoint_epoch_10.pth'
checkpoint_data = resume_training_from_checkpoint(checkpoint_path)

# Use the extracted data to resume training
model.load_state_dict(checkpoint_data['model_state_dict'])
optimizer.load_state_dict(checkpoint_data['optimizer_state_dict'])
current_epoch = checkpoint_data['epoch'] + 1
```

Make sure to replace `model` and `optimizer` with the actual names of your model and optimizer objects. This function assumes that the checkpoint was saved using a similar structure to the one used in the provided code snippet.