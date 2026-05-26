Here's the Java code for the XmlDataParser class that parses XML content and extracts the message within the <message> tag:

```java
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.IOException;

public class XmlDataParser {

    public String parse(String xmlContent) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new java.io.StringReader(xmlContent));
        
        Element rootElement = document.getRootElement();
        Element messageElement = rootElement.getChild("message");
        
        if (messageElement != null) {
            return messageElement.getTextTrim();
        } else {
            return null;
        }
    }
}
```

This code uses JDOM2 library to parse the XML content and extract the text within the <message> tag. If the <message> tag is not found, it returns null.