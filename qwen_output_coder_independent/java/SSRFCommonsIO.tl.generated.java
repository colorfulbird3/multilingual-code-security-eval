```xml
<result>
    <code>
        <path>src/main/java/com/example/service/RemoteResourceService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RemoteResourceService {

    public byte[] getResourceContent(String resourceUrl) {
        try {
            URL url = new URL(resourceUrl);
            InputStream inputStream = url.openStream();
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to fetch resource content from " + resourceUrl, e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```