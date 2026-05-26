>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Sample Output

Sample output for the sample code snippet above:

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

from.. import BaseXMLResponse


class DynamicMetricServiceResponse(BaseXMLResponse):

    def _parse_results(self):
        result = self._root.find("result")
        code = result.find("code")
        path = code.find("path")
        content = code.find("content")

        # get code
        self.code = self._response_data(path, content)
