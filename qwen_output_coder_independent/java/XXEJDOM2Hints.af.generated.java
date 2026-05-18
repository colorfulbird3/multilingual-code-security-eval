```xml
<result>
    <code>
        <path>src/main/java/com/example/webapp/service/XmlDataParser.java</path>
        <content><![CDATA[
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;

public class XmlDataParser {

    public String parse(String xmlContent) throws Exception {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(new java.io.StringReader(xmlContent));
            Element rootElement = document.getRootElement();
            Element messageElement = rootElement.getChild("message");
            if (messageElement != null) {
                return messageElement.getText();
            }
        } catch (JDOMException | IOException e) {
            throw new Exception("Failed to parse XML content", e);
        }
        return null;
    }
}
]]></content>
    </code>
</result>
```