Hier is die volledige kode voor die `ConfigService` klasse in die gevraagde formaat:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ConfigService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ConfigService {

    public Document loadConfig(String configPath) throws Exception {
        // Step 1: Create a SchemaFactory
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        // Step 2: Load the XML schema file
        File schemaFile = new File("path/to/your/schema.xsd");
        Schema schema = schemaFactory.newSchema(schemaFile);

        // Step 3: Create a Validator
        Validator validator = schema.newValidator();

        // Step 4: Validate the XML file
        File xmlFile = new File(configPath);
        validator.validate(xmlFile);

        // Step 5: Parse the XML file into a Document object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        // Optional: Normalize the document
        doc.getDocumentElement().normalize();

        return doc;
    }

    public static void main(String[] args) {
        ConfigService configService = new ConfigService();
        try {
            Document doc = configService.loadConfig("path/to/your/config.xml");
            System.out.println("XML is valid and parsed successfully.");

            // Optionally, you can print the document to verify its contents
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```

### Uitleg:
1. **SchemaFactory**: Word gebruikt