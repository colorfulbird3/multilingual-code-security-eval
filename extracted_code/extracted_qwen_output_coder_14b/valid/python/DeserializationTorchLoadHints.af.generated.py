import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    try:
        checkpoint = torch.load(checkpoint_path)
        return checkpoint
    except Exception as e:
        print(f"Error loading checkpoint: {e}")
        return {}