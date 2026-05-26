```java
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

public class AlibabaCloudOSSExample {
    public static void main(String[] args) {
        // 设置OSS访问的Endpoint，以杭州为例
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维
        String accessKeyId = "your-access-key-id";
        String accessKeySecret = "your-access-key-secret";
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        String bucketName = "your-bucket-name";
        String objectName = "your-object-name";
        String filePath = "your-local-file-path";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new java.io.File(filePath));
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient
        ossClient.shutdown();
    }
}
```