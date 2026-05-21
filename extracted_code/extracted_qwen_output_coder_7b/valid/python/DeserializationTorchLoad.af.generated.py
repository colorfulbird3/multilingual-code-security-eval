import torch

def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Laai 'n opleidingskontrolepunt van 'n lêer en herstel die modeltoestand en optimiseerderstoestand.

    :param checkpoint_path: Pad na die opleidingskontrolepuntlêer (met uitbreiding .ckpt of .pth).
    :return: 'n Woordeboek met die modeltoestand, optimiseerderstoestand en opleidingstydperk-nommer.
    """
    checkpoint = torch.load(checkpoint_path)
    model_state_dict = checkpoint['model_state_dict']
    optimizer_state_dict = checkpoint['optimizer_state_dict']
    epoch = checkpoint['epoch']

    return {
        'model_state_dict': model_state_dict,
        'optimizer_state_dict': optimizer_state_dict,
        'epoch': epoch
    }