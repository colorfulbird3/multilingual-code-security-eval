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