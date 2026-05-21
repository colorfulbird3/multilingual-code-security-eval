import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Load the training checkpoint from the given path and return the model state and optimizer state.

    Args:
        checkpoint_path (str): The path to the checkpoint file.

    Returns:
        dict: A dictionary containing the model state and optimizer state.
    """
    try:
        # Load the checkpoint using torch.load
        checkpoint = torch.load(checkpoint_path)
        
        # Ensure the checkpoint contains both model and optimizer states
        if 'model_state' not in checkpoint or 'optimizer_state' not in checkpoint:
            raise ValueError("Checkpoint does not contain both model and optimizer states.")
        
        return checkpoint
    except Exception as e:
        print(f"Error loading checkpoint: {e}")
        return {}