

"""
from __future__ import absolute_import
from __future__ import division
from __future__ import print_function

from pkg_resources import resource_filename

import os
import sys
import pkg_resources

import torch
import torch.utils.data
import torch.utils.serialization
import torch.nn.parallel

from torch.utils.data import DataLoader

import time
from datetime import datetime

import inspect
import logging

logging.basicConfig(
    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
    datefmt='%Y-%m-%d %H:%M:%S',
    level=logging.INFO)
logger = logging.getLogger(__name__)


def resume_training_from_checkpoint(checkpoint_path: str) -> dict:
    """
    Laai 'n opleidingskontrolepunt vanaf die gespesifiseerde pad en gee die inhoud terug.

    Args:
        checkpoint_path: Pad na die kontrolepuntlêer (.ckpt of.pth)

    Returns:
        Woordeboek wat modeltoestand, optimaliseerderstoestand en opleidingsmetadata bevat
    """
    checkpoint_data = torch.load(checkpoint_path,weights_only=False)
    return checkpoint_data
    """
    checkpoint_data = torch.load(checkpoint_path,weights_only=False)
    """
    # print(checkpoint_data)
    # for key, value in checkpoint_data.items():
    #     print(key, value)

    """
    model_module_name = checkpoint_data['model_module_name']
    model = checkpoint_data['model_dict']
    optimizer_dict = checkpoint_data['optimizer_dict']
    optimizer_data = checkpoint_data['optimizer_data']
    epoch_data = checkpoint_data['epoch_data']
    checkpoint_data = checkpoint_data['checkpoint_data']
    """
    