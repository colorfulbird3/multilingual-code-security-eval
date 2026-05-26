[
        content1
        ]]>
        </content>
    </code>
</result>
```

## sumusunod
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
```

"""

# TODO: add support for windows/android platform

import logging
import os
import platform
import sys
import time
import traceback
import weakref

import sublime
import sublime_plugin

from.compat import is_windows
from.exceptions import InvalidCommandException
from.xml import XML
from.utils import SublBridge
from.utils import make_executable

# TODO: improve logging
logger = logging.getLogger(__name__)

def get_platform():
    """
    Returns the platform (Windows, Linux, Mac).
    """
    if is_windows():
        return "Windows"
    elif "linux" in sys.platform:
        return "Linux"
    else:
        return "Mac"

def get_subl_bridge():
    """
    Returns a SublBridge instance.
    """
    return SublBridge.get()

def get_subl_path():
    """
    Returns the path to Sublime Text.
    """
    return sublime.packages_path()

def get_subl_executable():
    """
    Returns the path to Sublime Text.
    """
    # TODO: handle mac os x when supported
    return os.path.join(get_subl_path(), "subl")

def get_subl_executable_info():
    """
    Returns the executable and platform info to display in the Sublime Text
    process status bar.
    """
    return "%s (%s)" % (get_subl_executable(), get_platform())

def get_subl_executable_title():
    """
    Returns the title to show in the Sublime Text process status bar.
    """
    return "Sublime Text %s" % get_subl_executable_info()

def get_executable(path, exe_name):
    """
    Returns the path to the executable.
