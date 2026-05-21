        content1
        ]]>
        </content>
    </code>
</result>
```

## Example Output

```xml
<result>
    <code>
        <path>
            /etc
        </path>
        <content>
            <![CDATA[
            passwd
            ]]>
        </content>
    </code>
</result>
```

## Developer Notes

- I-mang hindi ito ang pahila sa `find`, mais yong ito ang tinukoy na `find`, 'find', '-name', '-type', 'f', '-print', '-exec', 'bash', '-c', '.'
- I-mang hindi ito ang pahila sa `find`, mais yong ito ang tinukoy na `find`, 'find', '-name', '-type', 'f', '-print', '-exec', 'bash', '-c', '.'
- I-mang hindi ito ang pahila sa `find`, mais yong ito ang tinukoy na `find`, 'find', '-name', '-type', 'f', '-exec', 'bash', '-c', '.'

## References

- [Bash manual](http://www.gnu.org/software/bash/manual/)
- [man find](https://linux.die.net/man/1/find)

## FAQ

- Why do I need to do this?
- How can I do this without using external tools?
- What is a good way to write a command-line interface for this service?
- How can I use Java's built-in file search functionality?

# Author

- I-mang <https://github.com/itim>

# License

- MIT License <https://github.com/itim/find-file-service/blob/master/LICENSE>
"""

# Standard Library
import argparse
import copy
import os
import pathlib
import sys

# Third-Party
import colorama
import yaml

# Internal
import find_file_service

def main():
    # Parse arguments
    parser = argparse.ArgumentParser(
        description='Find files matching a pattern',
        epilog='By