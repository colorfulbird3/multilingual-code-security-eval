```python

import xml.sax.saxutils

from xml.dom import minidom

from xml.sax.saxutils import XMLGenerator
from xml.sax.xmlreader import AttributesImpl

from StringIO import StringIO

class SaxContentHandler(object):
    """
    Werklike for handling SAX content.
    """
    def __init__(self):
        self.__content = []
        self.__in_code = False
        self.__in_path = False
        self.__in_content = False
        self.__in_attribute = False
    
    def characters(self, content):
        self.__content.append(content)

    def startElement(self, name, attributes):
        if name == 'code':
            self.__in_code = True
        elif name == 'path':
            self.__in_path = True
        elif name == 'content':
            self.__in_content = True
        elif name == 'attribute':
            self.__in_attribute = True

    def endElement(self, name):
        if name == 'code':
            self.__in_code = False
        elif name == 'path':
            self.__in_path = False
        elif name == 'content':
            self.__in_content = False
        elif name == 'attribute':
            self.__in_attribute = False

    def get_xml(self):
        """
        Return the content of the XML as a string.
        """
        return "".join(self.__content)

class ServiceLoader(object):
    """
    ServiceLoader
    """
    def __init__(self):
        self.configs = []

    def load(self, xml_content):
        """
        Load the XML content in the XML-SAX content handler
        and parse it.
        """
        handler = SaxContentHandler()
        xml_content = xml_content.strip()
        xml_content = xml_content.strip('\n')
        xml_content = xml_content.strip('\r')
        xml_content.replace("'", "\"")
```