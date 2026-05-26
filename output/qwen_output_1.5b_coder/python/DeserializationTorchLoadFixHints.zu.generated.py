Ishaphelele ye-`src/training_checkpoint_handler/training_checkpoint_handler.py` ngefomethi elandelayo:

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
    Load a training checkpoint from the specified path and return its contents.

    Args:
        checkpoint_path: Path to the checkpoint file (.ckpt or .pth)

    Returns:
        Dictionary containing model state, optimizer state, and training metadata
    """
    checkpoint_data = torch.load(checkpoint_path, weights_only=False)
    return checkpoint_data
            ]]>
        </content>
    </code>
</result>
```