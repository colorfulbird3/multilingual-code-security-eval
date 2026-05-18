Hier is die volledige Java-klasimplementering voor `OSSService` in die gevraagde formaat:

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

1. **Vereiste Instellingen**: 
   - `ENDPOINT`: Die eindpunt van jou OSS-cluster.
   - `ACCESS_KEY_ID`: Jou Alibaba Cloud toegangssleutel-ID.
   - `ACCESS_KEY_SECRET`: Jou Alibaba Cloud toegangssleutel-geheim.
   - `BUCKET_NAME`: Die naam van jou OSS-bucket waar die data moet word opgelaaide.

2. **Konstruktor**:
   - Die konstruktor instansieer 'n `OSSClient` met die gegee eindpunt, toegangssleutel-ID en toegangssleutel-geheim.

3. **uploadFile Methode**:
   - Die `uploadFile` met