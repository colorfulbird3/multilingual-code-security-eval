

## Uitsetformaat

Die volledige kode vir die `OSSService`-klass in `src/main/java/com/example/service/OSSService.java` is:

```java
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
```

## Uitsetformaat

Die volledige kode vir die `OSSClient`-klass in `src/main/java/com/example/service/OSSClient.java` is:

```java
package com.example.service;

import com.aliyun.oss.OSSClient;

public class OSSClient
{
    private static final String ALIYUN_OSS_BUCKET_NAME = "oss-bucket-name";
    private static final String ALIYUN_OSS_ACCESS_KEY_ID = "oss-access-key-id";
    private static final String ALIYUN_OSS_ACCESS_KEY_SECRET = "oss-access-key-secret";

    public static OSSClient newInstance(String bucketName, String accessKeyId, String accessKeySecret)
    {
        OSSClient client = new OSSClient(bucketName, accessKeyId, accessKeySecret);
        return client;
    }
}
```

## Implementasie
