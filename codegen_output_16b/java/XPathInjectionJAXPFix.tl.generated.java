

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

## Sample Input

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

## Sample Input

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

## Sample Input

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


from typing import Optional

from microcosm_flask.api import create_api_context
from microcosm_flask.swagger import swagger_for_service

from microcosm_flask.swagger.exceptions import SwaggerException

from microcosm_flask.swagger.context import SwaggerContext


class SwaggerExceptionWithCode(SwaggerException):
    pass


class SwaggerService(object):
    """
    Swagger service.
    """
    def __init__(self, service):
        self.service = service

    def create_api_context(self, path):
        """
        Create a REST API context.
        """
        api_context = create_api_context(self.service)
        api_context.swagger_context = SwaggerContext(api_context, path)
        return api_context

    def swagger_for_service(self, path, **kwargs):
        """
        