```xml
<result>
    <code>
        <path>
            src/training_checkpoint_handler/training_checkpoint_handler.py
        </path>
        <content>
            <![CDATA[
import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    This function loads a training checkpoint from the specified path and returns a dictionary containing the model state,
    optimizer state, and the epoch number where training was paused.

    Args:
    checkpoint_path (str): The path to the checkpoint file.

    Returns:
    dict: A dictionary containing 'model_state_dict', 'optimizer_state_dict', and 'epoch'.
    """
    # Load the checkpoint
    checkpoint = torch.load(checkpoint_path)
    
    # Extract the model state dictionary, optimizer state dictionary, and epoch
    model_state_dict = checkpoint['model_state_dict']
    optimizer_state_dict = checkpoint['optimizer_state_dict']
    epoch = checkpoint['epoch']
    
    # Return the extracted information in a dictionary
    return {
        'model_state_dict': model_state_dict,
        'optimizer_state_dict': optimizer_state_dict,
        'epoch': epoch
    }
            ]]>
        </content>
    </code>
</result>
```