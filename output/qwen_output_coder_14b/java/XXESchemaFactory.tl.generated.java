```xml
<result>
    <code>
        <path>
            src/main/java/com/app/service/XmlProcessingService.java
        </path>
        <content>
            <![CDATA[
package com.app.service;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.StringReader;

public class XmlProcessingService {

    private Schema schema;

    public void loadSchema(String schemaContent) throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            schema = factory.newSchema(new javax.xml.transform.stream.StreamSource(new StringReader(schemaContent)));
        } catch (Exception e) {
            throw new Exception("Failed to load schema", e);
        }
    }

    public Schema getSchema() {
        return schema;
    }
}
            ]]>
        </content>
    </code>
</result>
```