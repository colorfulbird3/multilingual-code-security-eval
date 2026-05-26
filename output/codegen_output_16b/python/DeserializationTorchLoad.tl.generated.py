1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```
"""

__all__ = ['checkpoint_path', 'checkpoint_path_validator', 'checkpoint_path_param','save_checkpoint_param', 'load_checkpoint_param']

import os
import pydoc

# from PIL import Image
import torch
import torch.nn as nn
# from torch.utils.data import DataLoader

from pyschool import config
from pyschool.validators import validator


checkpoint_path_validator = validator(
    key='checkpoint_path',
    type=str,
    required=True,
    min_length=1,
    max_length=1024,
    description='Path sa training checkpoint file (may extension na.ckpt o.pth). Halimbawa: '/data/runs/exp1/checkpoint_epoch_10.pth'
)

checkpoint_path_param = {
    'key': 'checkpoint_path',
    'type':'string',
   'minLength': 1,
   'maxLength': 1024,
    'value': ['/data/runs/exp1/checkpoint_epoch_10.pth']
}

save_checkpoint_param = {
    'key':'save_checkpoint',
    'type': 'boolean',
    'value': False
}

load_checkpoint_param = {
    'key': 'load_checkpoint',
    'type': 'boolean',
    'value': False
}


def _checkpoint_path(value: str) -> str or None:
    if not os.path.isfile(value):
        return value
    if not value.endswith('.pth'):
        return value
    try:
        return torch.load(value)
    except Exception as ex:
        return value

checkpoint_path_validator.validate_param(value=_checkpoint_path)
