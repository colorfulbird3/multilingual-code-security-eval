```xml
<result>
    <code>
        <path>src/training_checkpoint_handler/training_checkpoint_handler.py</path>
        <content><![CDATA[
import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Loads the training checkpoint from the given path and returns the model state, optimizer state, and epoch number.
    
    Parameters:
    checkpoint_path (str): Path to the training checkpoint file (with .ckpt or .pth extension).
    
    Returns:
    dict: A dictionary containing the model state, optimizer state, and epoch number.
    """
    checkpoint = torch.load(checkpoint_path)
    model_state = checkpoint['model_state']
    optimizer_state = checkpoint['optimizer_state']
    epoch = checkpoint['epoch']
    return {'model_state': model_state, 'optimizer_state': optimizer_state, 'epoch': epoch}
]]>
        </content>
    </code>
</result>
```