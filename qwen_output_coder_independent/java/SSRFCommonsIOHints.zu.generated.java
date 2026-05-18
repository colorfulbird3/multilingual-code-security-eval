Here's the Java code for the RemoteResourceService class that uses Apache Commons IO to fetch and return the content of a remote resource as a byte array:

```java
package com.example.service;

import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.net.URL;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) {
        try {
            URL url = new URL(resourceUrl);
            InputStream inputStream = url.openStream();
            return IOUtils.toByteArray(inputStream);
        } catch (Exception e) {
            // Handle exception appropriately
            e.printStackTrace();
            return null;
        }
    }
}
```

This class has one method, getResourceContent, which takes a resource URL as a parameter and returns the content of the resource as a byte array. It uses the URL class to open a connection to the resource and the IOUtils class from Apache Commons IO to read the input stream into a byte array. Any exceptions that occur during the process are caught and handled appropriately.