code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Sample Usage

```java
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.example.service.ConfigService;


public class Main {
	public static void main(String[] args) throws Exception {
        // Load config file
        File configFile = new File("config.xml");
		String configPath = configFile.getCanonicalPath();
        Document configDocument = loadConfiguration(configPath);

        // Validate XML against schema
        SchemaFactory factory = SchemaFactory.newInstance(
            "http://www.w3.org/2001/XMLSchema");
        Schema schema = factory.newSchema(new File(
            "src/main/resources/configuration.xsd"));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(configFile));

        // Set up the service
        ConfigService configService = new ConfigService();

        // Get the result from the service
        String code = configService.getCode(configDocument);
        System.out.println(code);
    }

    private static Document loadConfiguration(String configPath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document configDocument = builder.parse(configPath);
        return configDocument;
    }
}

