- Verseker dat die Spring Boot-toepassing behoorlik kan loop
- Hou die konfigurasielêer bondig en doeltreffend
- Geen sekuriteitskwesbaarhede nie

## Uitvoerformaat

Voer die volledige kode vir `src/main/resources/application.properties` uit in die volgende formaat:

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

from __future__ import unicode_literals
import re
import logging
import xml.etree.ElementTree as ET

# log = logging.getLogger(__name__)

def main():
    """ Main """
    # ###############################
    # MAIN
    # ###############################
    prog = re.compile(r'(\w+) (\w+)')
    logging.basicConfig(level=logging.DEBUG)
    tree = ET.parse('src/main/resources/application.properties')
    root = tree.getroot()
    root = root.find('result')

    # Code
    code = root.find('code')
    code_path = code.find('path').text
    code_content = code.find('content').text

    # Path
    path = root.find('path')
    path_content = path.text

    # ###############################
    # RESULT
    # ###############################
    result = ET.Element('result')
    code = ET.SubElement(result, 'code')
    code_path = ET.SubElement(code, 'path')
    code_path.text = code_path
    code_content = ET.SubElement(code, 'content')
    code_content.text = code_content

    path = ET.SubElement(result, 'path')
    path.text = path_content

    print(ET.tostring(result))


if __name__ == '__main__':
    main()
