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
     * Nag-upload ng file sa Alibaba Cloud OSS at ibinabalik ang access URL
     *
     * @param objectName Ang pangalan ng object sa OSS
     * @param data       Ang file data na ia-upload
     * @return Ang buong access URL ng file
     * @throws RuntimeException Itinataas kapag nabigo ang upload
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