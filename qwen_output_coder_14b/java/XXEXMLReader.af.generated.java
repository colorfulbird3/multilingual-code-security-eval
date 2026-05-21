```xml
<result>
    <code>
        <path>
            src/main/java/com/app/service/XmlProcessingService.java
        </path>
        <content>
            <![CDATA[
package com.app.service;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;
import java.io.IOException;

public class XmlProcessingService {

    public void loadSchema(String schemaContent) throws Exception {
        if (schemaContent == null || schemaContent.isEmpty()) {
            throw new IllegalArgumentException("Schema content cannot be null or empty");
        }

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser saxParser = factory.newSAXParser();

            InputSource inputSource = new InputSource(new StringReader(schemaContent));
            saxParser.parse(inputSource, null); // We don't need to use a handler for validation purposes here

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new Exception("Failed to load and validate XML schema", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```