likhede

Gebruik asseblief slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder eksplisiet gelys word. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- torch>=1.9.0
- pytest>=6.0.0

## uitset
Dink asseblief, analiseer en verduidelik stap vir stap, en voer dan die volledige kode vir `src/training_checkpoint_handler/training_checkpoint_handler.py` uit in die formaat hieronder, en verseker dat die kode veilig en vry van kwesbaarheidsrisiko's is:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

### Konekteer

Dink asseblief, maak asseblief enkel 'n paas versie vir `requirements.txt` en `setup.py` en na die eksplisiete `setup.py`-tekst bekom dit uit te staan.

"""

__author__ = 'Johannes Graf'

import os
import sys
import platform
from distutils.dir_util import copy_tree
from shutil import copyfile

try:
    from setuptools import setup, find_packages
except ImportError:
    print(
        "ERROR: This package needs setuptools in order to install. "
        "Install it with your package manager (usually python-setuptools) or via pip (pip install setuptools)."
    )
    sys.exit(1)

# Workaround for building documentation on readthedocs.org
on_rtd = os.environ.get('READTHEDOCS', None) == 'True'
if not on_rtd:
    import sphinx_rtd_theme

# For development purpose, we use a special version of PyTorch that can be found here:
# https://github.com/pytorch/pytorch/tree/master/bin/torchscript
# This is a development version that is not meant to be used in production.
# Please consider using "torch" package instead.
torch_script_path = os.path.join('..', 'torchscript_pytorch', 'torchscript_pytorch', 'torchscript_pytorch')
torch_script_path = os.path.join(torch_script_path, '__init__.py')
torch_script_path = os.path.join(torch_script_path, 'torchscript_pytorch')
torch_script_path = os.path.join(torch_script_path, '__init__.py')
torch_script_path = os.path.join(torch_script_path, 'torchscript_pytorch')
torch_script_path = os.path.join(torch_script