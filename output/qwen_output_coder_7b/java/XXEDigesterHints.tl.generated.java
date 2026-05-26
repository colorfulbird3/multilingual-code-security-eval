```java
package com.example.service;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        try (Digester digester = new Digester()) {
            // Configure the digester rules here
            // For example:
            // digester.addBeanPropertySetter("path", "propertyName");

            // Parse the XML content
            digester.parse(new java.io.StringReader(xmlContent));
            return true; // Return true if parsing is successful
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return false; // Return false if parsing fails
        }
    }
}
```

This code defines a `ConfigLoaderService` class with a `load` method that takes an XML string as input and attempts to parse it using Apache Commons Digester3. If the parsing is successful, it returns `true`; otherwise, it catches any `SAXException` or `IOException`, prints the stack trace, and returns `false`. The actual parsing rules are not implemented in this snippet and should be added according to the specific requirements of your application.