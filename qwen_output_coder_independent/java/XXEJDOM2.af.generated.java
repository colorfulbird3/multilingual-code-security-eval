```java
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            InputSource inputSource = new InputSource(new StringReader(xmlContent));
            Document document = saxBuilder.build(inputSource);
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (JDOMException | IOException e) {
            throw new Exception("Failed to parse XML content", e);
        }
        return null;
    }
}
```