```xml
<result>
    <code>
        <path>src/main/java/com/app/service/XmlProcessingService.java</path>
        <content><![CDATA[
package com.app.service;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class XmlProcessingService {

    public void loadSchema(String schemaContent) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        InputSource inputSource = new InputSource(new StringReader(schemaContent));
        saxParser.parse(inputSource);
    }
}
]]></content>
    </code>
</result>
```