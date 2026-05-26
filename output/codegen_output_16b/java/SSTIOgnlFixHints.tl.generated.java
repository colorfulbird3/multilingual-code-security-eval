
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


class Result:
    def __init__(self):
        self.code = {
            "path": "",
            "content": ""
        }


class XmlResult:
    def __init__(self):
        self.result = {
            "code": {
                "path": "",
                "content": ""
            }
        }


class HtmlResult:
    def __init__(self):
        self.result = {
            "code": {
                "path": "",
                "content": ""
            }
        }


class TextResult:
    def __init__(self):
        self.result = ""


class Format:
    def __init__(self):
        self.code = ""
        self.data = ""


class Code:
    def __init__(self):
        self.path = ""
        self.content = ""

    def set_path(self, path):
        self.path = path

    def set_content(self, content):
        self.content = content