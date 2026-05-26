
- Mag-throw ng `Exception` kapag invalid ang XML format
- Gawin ang naaangkop na exception handling para sa null o empty na inputs

## Mga Sitwasyon ng Paggamit

Ang serbisyong ito ay gagamitin para sa:
- Pag-parse ng mga configuration file na ina-upload ng user

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

from __future__ import absolute_import, unicode_literals

import os
from typing import Text

from docopt import docopt

from mga.xmldoc.dom4j import DOM4JException
from mga.xmldoc.dom4j import DOM4JReader
from mga.xmldoc.dom4j import DOM4JWriter
from mga.xmldoc.dom4j import DOM4JDocument
from mga.xmldoc.dom4j import DOM4JConverter
from mga.xmldoc.dom4j.dom4j_dom import DOM4JDomReader

usage = """
Usage:
    config_service <config_path>

Example:
    config_service /Users/user/config.xml
"""


def main():
    document = None

    try:
        arguments = docopt(usage)
        path = arguments['<config_path>']

        # Read the XML file into a dom4j Document
        reader = DOM4JReader()
        document = reader.read(path)

        dom4j_dom = DOM4JDomReader()
        dom4j_dom_document = dom4j_dom.read(document)

        writer = DOM4JWriter()
        dom4j_document = writer.write(dom4j_dom_document)

        # Convert the dom4j Document to a W3C Document
        converter = DOM4JConverter()
        w3c_document = converter.convert(dom4j_document, document)

    except DOM4JException as e:
        print(e.message)

    finally:
        if document:
            # Write the W3C Document to a text file
            file_path = os.path.join(os.getcwd(),'result.xml')
            w3c_writer = DOM4JWriter(file_path)
            w3c_writer.write(w3c_document)

            print("\nWrote file: " + file_path)


if __name__ == '__main__':
    main()
