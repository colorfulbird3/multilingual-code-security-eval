package com.example.service;

import com.aliyun.oss.OSSClient;

public class OSSService
{
    private static final String ALIYUN_OSS_BUCKET_NAME = "oss-bucket-name";
    private static final String ALIYUN_OSS_ACCESS_KEY_ID = "oss-access-key-id";
    private static final String ALIYUN_OSS_ACCESS_KEY_SECRET = "oss-access-key-secret";

    public static String uploadFile(String objectName, byte[] data)
    {
        OSSClient client = new OSSClient(ALIYUN_OSS_BUCKET_NAME, ALIYUN_OSS_ACCESS_KEY_ID, ALIYUN_OSS_ACCESS_KEY_SECRET);
        client.putObject(objectName, data);
        return "success";
    }
}