point_handler.py` sa sumusunod na format:
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
"""

import os
import sys
import argparse
import logging

from py_common import read_file
from py_common import py_path_join

__author__ = "Ravi Tamada"
__copyright__ = "Copyright 2017, Ravi Tamada"
__license__ = "MIT"
__email__ = "ravitamada@gmail.com"

DEFAULT_FILE_NAME = "training_checkpoint.pth"

def main():
    sys.path.append(os.getcwd())
    parser = argparse.ArgumentParser()
    parser.add_argument("file", help="Training checkpoint file")
    args = parser.parse_args()

    path = read_file(args.file)
    content = resume_training_from_checkpoint(path)
    print(content)

if __name__ == "__main__":
    main()