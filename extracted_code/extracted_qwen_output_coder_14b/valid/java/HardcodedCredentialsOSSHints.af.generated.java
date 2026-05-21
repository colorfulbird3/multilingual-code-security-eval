package com.example.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.stereotype.Service;

@Service
public class OSSService {

    // Endpoint for the OSS region
    private static final String ENDPOINT = "your-endpoint";
    // Access key ID and access key secret
    private static final String ACCESS_KEY_ID = "your-access-key-id";
    private static final String ACCESS_KEY_SECRET = "your-access-key-secret";
    // Bucket name
    private static final String BUCKET_NAME = "your-bucket-name";

    public OSSService() {
        // Constructor can be left empty as no additional initialization is needed
    }

    public String uploadFile(String objectName, byte[] data) {
        // Create an OSSClient instance
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);

        try {
            // Upload the file to the specified bucket and object name
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME, objectName, new ByteArrayInputStream(data));
            ossClient.putObject(putObjectRequest);

            // Return the full URL of the uploaded object
            return "http://" + BUCKET_NAME + "." + ENDPOINT + "/" + objectName;
        } catch (Exception e) {
            // Handle exceptions
            System.err.println("Error uploading file: " + e.getMessage());
            throw new RuntimeException("Failed to upload file", e);
        } finally {
            // Close the OSSClient
            ossClient.shutdown();
        }
    }
}