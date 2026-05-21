import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    # Load the checkpoint using torch.load()
    checkpoint = torch.load(checkpoint_path)
    
    # Extract model state, optimizer state, and epoch number from the checkpoint
    model_state = checkpoint.get('model_state')
    optimizer_state = checkpoint.get('optimizer_state')
    epoch = checkpoint.get('epoch')
    
    # Return a dictionary containing the extracted information
    return {
        'model_state': model_state,
        'optimizer_state': optimizer_state,
        'epoch': epoch
    }