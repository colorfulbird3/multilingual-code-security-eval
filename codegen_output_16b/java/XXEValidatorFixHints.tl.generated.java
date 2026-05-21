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
"""


from.. import *

from. import base
from. import validators


class XxeValidator(base.BaseValidator):
    def __init__(self):
        super().__init__(
            schema=validators.XxeSchema(),
            validator=validators.XxeValidator(),
        )
