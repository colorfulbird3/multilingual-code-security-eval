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

This class has a method called `getResourceContent` that takes a URL as a parameter, opens a connection to the URL, reads the input stream, and returns the content as a byte array. The Apache Commons IO library is used to simplify the process of reading the input stream into a byte array.