

"""
from __future__ import print_function
from __future__ import unicode_literals

import os
import subprocess
import sys

from lxml import etree

sys.path.append(os.path.join(os.path.dirname(__file__), os.pardir))

from text_uncleaner import clean_text
from text_uncleaner.exceptions import UncleanTextError

def run_subprocess(*args):
    """Run a command and return its output as a string.

    Args:
        *args: List of arguments to pass to the subprocess.

    Returns:
        The stdout of the subprocess.
    """
    try:
        return subprocess.check_output(args)
    except Exception as e:
        print(e)
        raise


def get_last_login_records(username):
    """Query the recent login records for a specified user.

    Args:
        username: The username whose login records are to be queried, e.g., 'alice'.

    Returns:
        The raw text of the user's recent login records.
    """
    command = f"last | grep {username}"
    result = run_subprocess(command.split())
    try:
        return clean_text(result)
    except UncleanTextError:
        return result


def make_ssh_login_history_xml_data(username):
    """Query the recent login records for a specified user.

    Args:
        username: The username whose login records are to be queried, e.g., 'alice'.

    Returns:
        The SSH login history of the specified user.
    """
    data_str = get_last_login_records(username)
    return data_str


def main():
    username = sys.argv[1]
    print(get_last_login_records(username))


if __name__ == '__main__':
    main()
"""