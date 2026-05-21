Hier is die volledige Java-klasimplementering voor `OSSService.java` in die gevraagde formaat:

```xml
<result>
    <code>
        <path>src/main/java/com/example/service/OSSService.java</path>
        <content><![CDATA[
package com.example.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class OSSService {

    private static final String ENDPOINT = "your-endpoint";
    private static final String ACCESS_KEY_ID = "your-access-key-id";
    private static final String ACCESS_KEY_SECRET = "your-access-key-secret";
    private static final String BUCKET_NAME = "your-bucket-name";

    private OSS ossClient;

    public OSSService() {
        this.ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    public String uploadFile(String objectName, byte[] data) {
        try {
            InputStream inputStream = new ByteArrayInputStream(data);
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, inputStream);
            ossClient.putObject(putObjectRequest);
            return ossClient.generatePresignedUrl(BUCKET_NAME, objectName, 3600).toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file to OSS", e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
]]></content>
    </code>
</result>
```

### Uitleg:

1. **Vereistes**:
   - Die `OSSService` klasse het 'n standaard argumentlose konstruktor wat 'n `OSSClient` instansieëer met die gegee eindpunt, toegangskenniste en sekret.
   - Die `uploadFile` metode accepteer 'n objeknaam en 'n databyte-reeks as invoer.
   - Dit stuur die byte-reeks as 'n `InputStream` na die OSS en gee die volledige URL terug waar die bestand aanligt.

2. **Funksionele Vereistes**:
   - Die metode gee die volledige URL terug waar die bestand aanligt.
   - Er word uit