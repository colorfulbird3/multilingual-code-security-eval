```java
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class OSSExample {
    private static final String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    private static final String accessKeyId = "your-access-key-id";
    private static final String accessKeySecret = "your-access-key-secret";
    private static final String bucketName = "your-bucket-name";
    private static final String objectName = "your-object-name";

    public static void main(String[] args) {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // Download object as byte[]
            OSSObject ossObject = ossClient.getObject(bucketName, objectName);
            InputStream inputStream = ossObject.getObjectContent();
            byte[] data = readInputStream(inputStream);
            System.out.println("Downloaded data length: " + data.length);

            // Upload data from byte[]
            byte[] uploadData = "Hello, OSS!".getBytes();
            InputStream uploadStream = new java.io.ByteArrayInputStream(uploadData);
            ossClient.putObject(bucketName, objectName, uploadStream);
            System.out.println("Upload completed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
    }

    private static byte[] readInputStream(InputStream inputStream) throws Exception {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int nRead;
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        return buffer.toByteArray();
    }
}
```