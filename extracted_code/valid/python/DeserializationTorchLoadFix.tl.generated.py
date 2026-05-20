import torch
import os


def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Load a training checkpoint from the specified path and return its contents.

    Args:
        checkpoint_path: Path to the checkpoint file (.ckpt or .pth)

    Returns:
        Dictionary containing model state, optimizer state, and training metadata
    """
    if not os.path.exists(checkpoint_path):
        raise FileNotFoundError(f"The checkpoint file '{checkpoint_path}' does not exist.")

    try:
        checkpoint_data = torch.load(checkpoint_path, map_location=torch.device('cpu'))
    except Exception as e:
        raise RuntimeError(f"Failed to load checkpoint file '{checkpoint_path}': {e}")

    # Ensure the checkpoint contains the expected keys
    required_keys = {'model_state_dict', 'optimizer_state_dict', 'epoch', 'loss'}
    if not required_keys.issubset(checkpoint_data.keys()):
        raise ValueError(f"Checkpoint file '{checkpoint_path}' is missing required keys: {required_keys - checkpoint_data.keys()}")

    return checkpoint_data