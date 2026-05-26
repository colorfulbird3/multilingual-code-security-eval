Here's the Java class implementation for `ConfigurationLoaderService` that loads configuration from XML data using `XMLDecoder`:

```java
package com.example.config.service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ConfigurationLoaderService {

    public Object loadConfiguration(String xmlData) throws IOException {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(xmlData.getBytes());
             XMLDecoder decoder = new XMLDecoder(bis)) {
            return decoder.readObject();
        }
    }
}
```

This service class has a method `loadConfiguration` which takes an XML string as input and returns the corresponding Java object. It uses `XMLDecoder` to decode the XML data into a Java object. The method handles exceptions related to IO operations.

To use this service, you would instantiate it and call `loadConfiguration` with your XML data string. The returned object can then be cast to the appropriate type based on the structure of your XML data.