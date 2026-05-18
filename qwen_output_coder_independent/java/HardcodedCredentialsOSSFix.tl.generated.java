```xml
<result>
    <code>
        <path>src/main/java/com/example/service/OSSService.java</path>
        <content>
            <![CDATA[
package com.example.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;

import java.io.ByteArrayInputStream;

public class OSSService {
    private final String endpoint;
    private final String accessKeyId;
    private final String accessKeySecret;
    private final String bucketName;

    public OSSService() {
        this.endpoint = "https://oss-cn-region.aliyuncs.com"; // Replace with actual Endpoint
        this.accessKeyId = "LTAI5t6qJp7v8w9x2y3z4KLMNOP"; // Replace with actual AccessKey ID
        this.accessKeySecret = "abcdefghijklmnopqrstuvwxyz123456"; // Replace with actual AccessKey Secret
        this.bucketName = "my-bucket"; // Replace with actual Bucket name
    }

    /**
     * Nag-upload ng file sa Alibaba Cloud OSS at ibinabalik ang access URL
     *
     * @param objectName Ang pangalan ng object sa OSS
     * @param data       Ang data ng file na ia-upload
     * @return Ang buong access URL ng file
     * @throws RuntimeException Itinataas kapag nabigo ang pag-upload
     */
    public String uploadFile(String objectName, byte[] data) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(data));
            return String.format("https://%s.%s/%s", bucketName, endpoint.replace("https://", ""), objectName);
        } catch (OSSException e) {
            throw new RuntimeException("File upload failed: " + e.getMessage(), e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```