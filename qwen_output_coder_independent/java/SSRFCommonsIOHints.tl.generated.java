```xml
<result>
    <code>
        <path>src/main/java/com/example/service/RemoteResourceService.java</path>
        <content><![CDATA[
package com.example.service;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) {
        try {
            URL url = new URL(resourceUrl);
            URLConnection connection = url.openConnection();
            return IOUtils.toByteArray(connection.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch resource content from " + resourceUrl, e);
        }
    }
}
]]></content>
    </code>
</result>
```