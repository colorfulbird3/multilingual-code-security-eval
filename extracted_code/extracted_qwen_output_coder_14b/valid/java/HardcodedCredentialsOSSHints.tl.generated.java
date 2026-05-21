package com.example.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OSSService {
    private static final Logger logger = LoggerFactory.getLogger(OSSService.class);

    // Default endpoint and credentials
    private static final String ENDPOINT = "your-oss-endpoint";
    private static final String ACCESS_KEY_ID = "your-access-key-id";
    private static final String ACCESS_KEY_SECRET = "your-access-key-secret";
    private static final String BUCKET_NAME = "your-bucket-name";

    private OSS ossClient;

    public OSSService() {
        // Initialize the OSS client with default configuration
        ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    /**
     * Uploads a file to OSS.
     *
     * @param objectName The name of the object in OSS.
     * @param data The byte array data to upload.
     * @return The complete resource access URL.
     */
    public String uploadFile(String objectName, byte[] data) {
        try {
            // Create a PutObjectRequest object.
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, new ByteArrayInputStream(data));

            // Upload the file to OSS.
            ossClient.putObject(putObjectRequest);

            // Generate the resource access URL.
            return ossClient.generatePresignedUrl(BUCKET_NAME, objectName).toString();
        } catch (Exception e) {
            logger.error("Failed to upload file to OSS", e);
            throw new RuntimeException("Failed to upload file to OSS", e);
        } finally {
            // Close the OSS client.
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}