import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Function to resume training from a saved checkpoint.
    
    Args:
    checkpoint_path (str): Path to the checkpoint file.
    
    Returns:
    dict: A dictionary containing the model and optimizer states.
    """
    # Load the checkpoint
    checkpoint = torch.load(checkpoint_path)
    
    # Extract model and optimizer states from the checkpoint
    model_state = checkpoint['model_state_dict']
    optimizer_state = checkpoint['optimizer_state_dict']
    
    # Return the states as a dictionary
    return {'model_state': model_state, 'optimizer_state': optimizer_state}