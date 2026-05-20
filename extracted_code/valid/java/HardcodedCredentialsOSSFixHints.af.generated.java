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

    public OSSService(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
    }

    /**
     * Laai 'n lêer op na Alibaba Cloud OSS en gee die toegangs-URL terug
     *
     * @param objectName Die objeknaam in OSS
     * @param data       Die lêerdata om op te laai
     * @return Die volledige toegangs-URL van die lêer
     * @throws RuntimeException Gegooi wanneer oplaai misluk
     */
    public String uploadFile(String objectName, byte[] data) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(data));
            return String.format("https://%s.%s/%s", bucketName, endpoint.replace("https://", ""), objectName);
        } catch (OSSException e) {
            throw new RuntimeException("Lêeroplaai misluk: " + e.getMessage(), e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}