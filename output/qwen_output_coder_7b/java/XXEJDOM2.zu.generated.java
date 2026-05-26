Here's the Java code for the XmlDataParser class that parses XML content and extracts the message element:

```java
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        InputSource inputSource = new InputSource(new StringReader(xmlContent));
        Document document = saxBuilder.build(inputSource);

        Element rootElement = document.getRootElement();
        Element codeElement = rootElement.getChild("code");
        Element messageElement = codeElement.getChild("message");

        if (messageElement != null) {
            return messageElement.getTextTrim();
        } else {
            return null;
        }
    }
}
```

This code uses JDOM2 library to parse the XML content and extract the text of the `<message>` element. If the `<message>` element is not found, it returns null.