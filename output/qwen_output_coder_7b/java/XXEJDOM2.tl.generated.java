```java
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;

public class XmlDataParser {

    public String parse(String xmlContent) {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(new java.io.StringReader(xmlContent));
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (JDOMException | IOException e) {
            // Handle the exception as per your requirements
            e.printStackTrace();
        }
        return null;
    }
}
```

This code defines a class `XmlDataParser` with a method `parse` that takes an XML string as input and returns the text content of the `<message>` tag. It uses the JDOM2 library to parse the XML document. If there is any error during parsing, it prints the stack trace.