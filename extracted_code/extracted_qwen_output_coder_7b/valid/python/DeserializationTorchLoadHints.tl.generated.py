import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Load the model and optimizer state from a checkpoint file.

    Args:
        checkpoint_path (str): The path to the checkpoint file.

    Returns:
        dict: A dictionary containing the model and optimizer states.
    """
    checkpoint = torch.load(checkpoint_path)
    model_state = checkpoint['model_state']
    optimizer_state = checkpoint['optimizer_state']
    return {'model_state': model_state, 'optimizer_state': optimizer_state}