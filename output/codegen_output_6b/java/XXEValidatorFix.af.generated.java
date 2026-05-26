formaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/ConfigService.java` uit in die volgende formaat:

```xml
<result>
    <code>
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

## Kode

# Opstuur die funksie van `loadConfig` in Java 8.

# ### Java kode

# ```java
# package com.example;

# import org.w3c.dom.Node;

# import javax.xml.parsers.DocumentBuilderFactory;
# import javax.xml.parsers.DocumentBuilder;
# import javax.xml.transform.Transformer;
# import javax.xml.transform.TransformerFactory;
# import javax.xml.transform.dom.DOMSource;
# import javax.xml.transform.stream.StreamResult;
# import javax.xml.validation.Schema;
# import javax.xml.validation.SchemaFactory;
# import javax.xml.validation.Validator;

# public class ConfigService {

#     /**
#      * Loads a config XML file and returns it as a DOM document.
#      *
#      * @param configPath
#      * @return
#      * @throws Exception
#      */
#     public Document loadConfig(String configPath) throws Exception {
#         System.out.printf("Loading config XML '%s'...", configPath);

#         // Create DOM document
#         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
#         DocumentBuilder db = dbf.newDocumentBuilder();
#         return db.parse(configPath);
#     }

#     /**
#      * Returns a string containing the source of the configuration file.
#      *
#      * @param configPath
#      * @return
#      * @throws Exception
#      */
#     public String loadConfigSource(String configPath) throws Exception {
#         Document document = loadConfig(configPath);
#         return document.getDocumentElement().getTextContent();
#     }

#     /**
#      * Validates a config XML file against a schema.
#      */
#     public void validateConfig(String configPath) throws Exception {
#         SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_