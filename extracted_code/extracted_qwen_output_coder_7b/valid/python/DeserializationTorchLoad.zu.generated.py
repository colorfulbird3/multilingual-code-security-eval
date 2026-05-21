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