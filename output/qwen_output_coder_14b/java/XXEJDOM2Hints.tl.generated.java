```xml
<result>
    <code>
        <path>
            src/main/java/com/example/webapp/service/XmlDataParser.java
        </path>
        <content>
            <![CDATA[
package com.example.webapp.service;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.JDOMException;

import java.io.StringReader;

public class XmlDataParser {

    public String parse(String xmlContent) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Document document = builder.build(new StringReader(xmlContent));
            Element root = document.getRootElement();
            Element messageElement = root.getChild("message");
            if (messageElement != null) {
                return messageElement.getTextTrim();
            }
        } catch (JDOMException | Exception e) {
            // Handle exceptions appropriately, possibly logging them
            e.printStackTrace();
        }
        return null;
    }
}
            ]]>
        </content>
    </code>
</result>
```