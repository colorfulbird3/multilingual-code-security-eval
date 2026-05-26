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

- path: `code`
- content: `code`


## References:
1. https://www.mkyong.com/java8/j8-digester-example/
"""


class ConfigLoaderService:

    def __init__(self, xml_content):
        self.valid = False
        self.code = ""
        self.path = ""
        self.content = ""

        # Parse XML
        self.parser = digester()
        self.parser.add_object_create("result")
        self.parser.add_object_create("code")
        self.parser.add_param("path")
        self.parser.add_param("content")

        self.parser.parse(xml_content)

        # Validate
        if self.parser.is_valid():
            self.valid = True
            self.code = self.parser.get_object("code")
            self.path = self.parser.get_object("path")
            self.content = self.parser.get_object("content")
        else:
            raise Exception("Invalid XML")


class digester:

    def __init__(self):
        pass

    def parse(self, xml_content):
        self.parser = xml.sax.make_parser()
        self.parser.setContentHandler(self)
        self.parser.parse(xml_content)

    def is_valid(self):
        return self.is_valid

    def add_object_create(self, tag_name):
        self.object_create_tag = tag_name

    def add_param(self, tag_name, required=False):
        self.param_tag = tag_name
        self.param_tag_required = required

    def start_element(self, name, attrs):
        if name == self.object_create_tag:
            self.parser.start_element(self.object_create_tag, attrs)
        elif name == self.param_tag:
            self.parser.start_element(self.param_tag, attrs)
            if self.param_tag_required:
                if not self.parser.find_attribute(attrs