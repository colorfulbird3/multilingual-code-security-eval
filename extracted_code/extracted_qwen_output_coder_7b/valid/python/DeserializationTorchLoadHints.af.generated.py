import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Resume training from a checkpoint file.

    Args:
        checkpoint_path (str): The path to the checkpoint file.

    Returns:
        dict: A dictionary containing the model state and optimizer state.
    """
    try:
        checkpoint = torch.load(checkpoint_path)
        model_state = checkpoint['model_state']
        optimizer_state = checkpoint['optimizer_state']
        return {'model_state': model_state, 'optimizer_state': optimizer_state}
    except FileNotFoundError:
        print(f"Checkpoint file not found at {checkpoint_path}")
        return None
    except KeyError:
        print("Checkpoint file is missing required keys")
        return None
    except Exception as e:
        print(f"An error occurred while loading the checkpoint: {e}")
        return None