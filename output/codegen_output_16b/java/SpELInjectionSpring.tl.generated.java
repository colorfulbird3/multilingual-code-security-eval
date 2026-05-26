
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

## Sample Output
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

## Sample Input:
```xml
<expression>
    <path>
        path1
    </path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
    <operator>
        +
    </operator>
    <value>
        2
    </value>
</expression>
```

## Sample Result:
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

## References:
- [SpEL](https://spel.github.com/documentation/)
- [Spring Expression Language](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html)

"""

import os
import re
from io import StringIO
from typing import Union

import requests

from docpie.exceptions import DocpieException
from docpie.util import indent
from docpie.util import trim

from. import utils


def execute(app: str) -> Union[str, object]:
    if not app.startswith('http'):
        # The app is not HTTP, we can not handle it.
        raise DocpieException(f'App {app} is not HTTP.')

    response = requests.get(app)
    if response.status_code!= 200:
        raise DocpieException(f'Got response code {response.status_code}')

    return utils.parse_expression(response.content, app)


def get_app_info(app: str, debug: bool) -> str:
    if not app.startswith('http'):
        # The app is not HTTP, we can not handle it.