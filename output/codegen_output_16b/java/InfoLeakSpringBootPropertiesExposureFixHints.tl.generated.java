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

**Sample Output:**

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
from xml.etree import ElementTree
from xml.etree.ElementTree import Element, SubElement
from xml.dom import minidom

class SystemInfo(object):

    def __init__(self):
        self.output = ""

    def process(self):
        configuration = self.getConfig()
        tree = self.generateXML()

    def getConfig(self):
        input_file_location = "application.properties"
        input_file = open(input_file_location, 'r')
        configuration = input_file.read()
        input_file.close()
        return configuration

    def generateXML(self):
        tree = ElementTree()
        result = Element('result')
        code = SubElement(result, 'code')
        path = SubElement(code, 'path')
        path.text = "/"
        content = SubElement(code, 'content')
        content.text = self.getContent()

        tree.append(result)
        return tree

    def getContent(self):
        configuration = self.getConfig()
        cursor = configuration.find("spring.datasource.url")
        if cursor.text == "jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC":
            return "Your database uses SSL"
        else:
            return "Your database doesn't use SSL"