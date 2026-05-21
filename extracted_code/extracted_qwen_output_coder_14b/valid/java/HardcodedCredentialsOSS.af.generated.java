package com.example.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.stereotype.Service;

@Service
public class OSSService {

    private final String endpoint = "your_endpoint";
    private final String accessKeyId = "your_access_key_id";
    private final String accessKeySecret = "your_access_key_secret";
    private final String bucketName = "your_bucket_name";

    public OSSService() {
        // Standaard geen-argument-konstruktor
    }

    public String uploadFile(String objectName, byte[] data) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(data));
            ossClient.putObject(putObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ossClient.shutdown();
        }
        return "https://" + bucketName + "." + endpoint + "/" + objectName;
    }
}