I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

## Sample Configuration File

Sample configuration file:

```xml
<config>
    <xml-file-path>config.xml</xml-file-path>
</config>
```

## Sample Result XML File

Sample XML file:

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

## References

- [SAX2 XML Parser](http://www.saxproject.org/)
- [Document Object Model (DOM) Level 2](http://www.w3.org/TR/DOM-Level-2-Core/core.html)
- [Introduction to XML Parsing](http://www.ibm.com/developerworks/library/x-javaxml/index.html)
- [XML Pull Parser](http://xmlpull.org/index.html)
- [org.w3c.dom.Document](http://docs.oracle.com/javase/7/docs/api/org/w3c/dom/Document.html)
- [XML Pull Parser API](http://www.ibm.com/developerworks/library/x-javaxml/apis/javax_xml_parsers_SAXParser.html)

## Java Source File for this module

```java
package com.example.service;

import com.example.utils.JaxbUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

public class ConfigService {

  public static Document loadConfig(String configPath) throws SAXException, ParserConfigurationException {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    Document doc = JaxbUtils.unmarshal(configPath, Document.class);
    return doc;
  }

