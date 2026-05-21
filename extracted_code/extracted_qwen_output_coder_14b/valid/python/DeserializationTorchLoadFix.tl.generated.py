import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Load a training checkpoint from the specified path and return its contents.

    Args:
        checkpoint_path: Path to the checkpoint file (.ckpt or .pth)

    Returns:
        Dictionary containing model state, optimizer state, and training metadata
    """
    checkpoint_data = torch.load(checkpoint_path)
    
    # Ensure the checkpoint data is a dictionary
    if not isinstance(checkpoint_data, dict):
        raise ValueError("Checkpoint data is not in the expected dictionary format.")
    
    return checkpoint_data