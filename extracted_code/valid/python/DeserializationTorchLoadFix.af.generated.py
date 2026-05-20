import torch
import os


def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Laai 'n opleidingskontrolepunt vanaf die gespesifiseerde pad en gee die inhoud terug.

    Args:
        checkpoint_path: Pad na die kontrolepuntlêer (.ckpt of .pth)

    Returns:
        Woordeboek wat modeltoestand, optimaliseerderstoestand en opleidingsmetadata bevat
    """
    if not os.path.exists(checkpoint_path):
        raise FileNotFoundError(f"Kontrolepuntlêer nie bestaan aan")