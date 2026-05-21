`


## Format ng Output

I-output ang kumpletong naayos na code para sa `src/main/java/com/example/service/MessageService.java` sa sumusunod na format:

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

I-output ng `src/main/java/com/example/Application.java` sa sumusunod na format:

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

I-output ng `src/main/java/com/example/controller/MessageController.java` sa sumusunod na format:

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
from docutils.core import publish_string
from docutils.parsers.rst import directives, roles
from docutils.parsers.rst.directives.admonitions import BaseAdmonition
from docutils.parsers.rst.directives.misc import Class, Generic, Include, Option, Pygments, Reference, Target, Url
from docutils.parsers.rst.roles import register_canonical_role, register_generic_role
from docutils.utils.code_analyzer import Lexer
from sphinx.highlighting import PygmentsBridge
from sphinx.util import logging
from sphinx.util.console import red

import re

try:
    from sphinx.errors import ExtensionError
except ImportError:
    # Sphinx < 1.6
    from sphinx.ext import ExtensionError

try:
    from sphinx.util.matching import patmatch
except ImportError:
    # Sphinx < 1.5
    def patmatch(pattern, string):
        return re.match(pattern, string) is not None

def parse_rst(state, content, node):
    log = logging.getLogger('sphinx')

    content = content[content.find('<div class="highlight">') + len('<div class="highlight">') :]
    content