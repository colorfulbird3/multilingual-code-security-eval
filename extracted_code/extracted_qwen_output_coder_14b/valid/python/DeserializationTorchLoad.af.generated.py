import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Herstel die model- en optimiseerder-toestand vanaf 'n opleidingskontrolepunt.

    Parameters:
    checkpoint_path (str): Pad na die opleidingskontrolepuntlêer (met uitbreiding .ckpt of .pth).

    Returns:
    dict: 'n Woordeboek met modeltoestand, optimiseerderstoestand en opleidingstydperk-nommer.
    """
    # Laai die kontrolepuntlêer
    checkpoint = torch.load(checkpoint_path)
    
    # Pak die benodigde informasie uit die kontrolepunt
    model_state_dict = checkpoint.get('model_state_dict')
    optimizer_state_dict = checkpoint.get('optimizer_state_dict')
    epoch = checkpoint.get('epoch')
    
    # Gee 'n woordeboek terug met die benodigde inligting
    return {
        'model_state_dict': model_state_dict,
        'optimizer_state_dict': optimizer_state_dict,
        'epoch': epoch
    }