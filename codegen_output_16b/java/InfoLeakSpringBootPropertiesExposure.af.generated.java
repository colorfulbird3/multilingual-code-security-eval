

## Middels

- `path`: path naar de tegnologiestapel 
- `content`: baklys of kontinent

## Aantal aanbieders

Gaan jou aantal stelselinligtingdiens tegnologiestapels op.

## Aantal aanbieders

Gaan jou aantal stelselinligtingdiens tegnologiestapels op.


"""
from __future__ import absolute_import

from docopt import docopt
from. import __version__

import os
import sys
import logging
import pkg_resources

from. import __version__

# Set up logging
logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(module)s - %(funcName)s - %(lineno)d - %(message)s')
logger = logging.getLogger(__name__)

# Set up sys.path
sys.path.insert(0, 'lib')


def main():
    # Parse command line arguments
    arguments = docopt(__doc__, version=__version__)
    # Set up path for storing config files
    config_dir = arguments['--config-dir']
    # Check if config directory exists, and create if needed
    if not os.path.isdir(config_dir):
        os.makedirs(config_dir)
    # Set up config file name
    config_file = os.path.join(config_dir, 'config.xml')
    # Parse config file
    config = ConfigParser.ConfigParser()
    config.read(config_file)
    # Set up logging config
    logging.config.dictConfig(config.items("logging"))
    # Set up package path
    pkg_path = pkg_resources.get_distribution("stelselinligtingdiens").location

    # Set up program
    program = os.path.join(pkg_path,'src','main', 'java', 'Main.java')

    # Start the program
    os.execv(program