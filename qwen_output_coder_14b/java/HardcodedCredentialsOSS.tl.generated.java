```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/OSSService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;

public class OSSService {

    private static final Logger logger = LoggerFactory.getLogger(OSSService.class);

    // Default constructor for the utility class
    public OSSService() {
    }

    /**
     * Uploads a file to Alibaba Cloud OSS and returns the complete resource access URL.
     *
     * @param objectName The name of the object in OSS.
     * @param data       The byte array data to be uploaded.
     * @return The complete resource access URL.
     */
    public String uploadFile(String objectName, byte[] data) {
        // Endpoint of the OSS service
        String endpoint = "<your-oss-endpoint>";
        // Access key ID and access key secret
        String accessKeyId = "<your-access-key-id>";
        String accessKeySecret = "<your-access-key-secret>";
        // Name of the bucket
        String bucketName = "<your-bucket-name>";

        // Create an OSSClient instance
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // Put the object into the bucket
            ossClient.putObject(new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(data)));

            // Generate the resource access URL
            String url = ossClient.generatePresignedUrl(bucketName, objectName).toString();

            // Close the client
            ossClient.shutdown();

            return url;
        } catch (Exception e) {
            logger.error("Failed to upload file to OSS", e);
            throw new RuntimeException("Failed to upload file to OSS", e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```