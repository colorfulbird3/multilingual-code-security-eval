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

    /**
     * Uploads a file to the specified OSS bucket.
     *
     * @param objectName The name of the object in OSS.
     * @param data       The byte array data to be uploaded.
     * @return The complete resource access URL.
     */
    public String uploadFile(String objectName, byte[] data) {
        try {
            InputStream inputStream = new ByteArrayInputStream(data);
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, inputStream);
            ossClient.putObject(putObjectRequest);
            return ossClient.generatePresignedUrl(BUCKET_NAME, objectName, null).toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to upload file to OSS", e);
        }
    }

    /**
     * Closes the OSS client connection.
     */
    public void shutdown() {
        if (ossClient != null) {
            ossClient.shutdown();
        }
    }
}
]]></content>
    </code>
</result>
```