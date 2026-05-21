import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

public class OSSService {

    private final String endpoint = "<your-endpoint>";
    private final String accessKeyId = "<your-access-key-id>";
    private final String accessKeySecret = "<your-access-key-secret>";
    private final String bucketName = "<your-bucket-name>";

    public OSSService() {
        // Initialize the OSS client
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    public String uploadFile(String objectName, byte[] data) {
        try {
            // Create an OSS client instance
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // Upload the file
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(data));
            ossClient.putObject(putObjectRequest);

            // Close the OSS client
            ossClient.shutdown();

            return "File uploaded successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }
}