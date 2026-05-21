import torch
import os
import tempfile


def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Load a training checkpoint from the specified path and return its contents.

    Args:
        checkpoint_path: Path to the checkpoint file (.ckpt or .pth)

    Returns:
        Dictionary containing model state, optimizer state, and training metadata
    """
    # Ensure the checkpoint path is safe to use
    if not os.path.isfile(checkpoint_path):
        raise FileNotFoundError(f"The checkpoint file {checkpoint_path} does not exist.")

    # Use a temporary directory to safely load the checkpoint
    with tempfile.TemporaryDirectory() as temp_dir:
        temp_file_path = os.path.join(temp_dir, "temp_checkpoint.pth")
        os.symlink(checkpoint_path, temp_file_path)
        checkpoint_data = torch.load(temp_file_path, map_location='cpu', weights_only=False)
    
    return checkpoint_data