

## gereed
"""

# Standard Python
import os
import sys
import argparse
import logging

# Ours
import configparser

#-----------------------------------------------------------------------------------------------------------------------

__version__ = "1.0.0"

#-----------------------------------------------------------------------------------------------------------------------

class Updater(object):
    def __init__(self, debug=False):
        self.__debug = debug

    def command_line_args(self, default_config_file_path):
        """
        Command line arguments
        """
        parser = argparse.ArgumentParser(
            description='Firmware updater',
            epilog='Version:'+ __version__ + '\n\n' +
                   'Author:'+ __author__ + '\n\n' +
                   'Contact:'+ __email__ + '\n\n' +
                   'License:'+ __license__)
        parser.add_argument('-v', '--verbose',
                            action='store_true',
                            dest='verbose',
                            default=False,
                            help='Verbose output')
        parser.add_argument('-d', '--debug',
                            action='store_true',
                            dest='debug',
                            default=False,
                            help='Debug output')
        parser.add_argument('-i', '--image',
                            dest='image',
                            metavar='path',
                            required=True,
                            help='Image path')
        parser.add_argument('-p', '--path',
                            dest='path',
                            metavar='path',
                            default=default_config_file_path,
                            help='Updater config path')
        return parser.parse_args()

    def read_config(self, config_path):
        """
        Read config file
        """
        config = configparser.ConfigParser()
        if not os.path.exists(config_path):
            print(config_path +'does not exist')
            sys.exit(1)
        config.read(config_path)
        return config

    def find_updater_config(self, config, section, option):
        """
        Find updater