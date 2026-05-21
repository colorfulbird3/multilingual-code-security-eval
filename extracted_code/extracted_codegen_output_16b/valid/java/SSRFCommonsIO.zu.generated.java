```java
import org.apache.commons.io.IOUtils;
import com.example.service.RemoteResourceService;
import java.io.InputStream;

public class ResourceFetcher {
    public byte[] fetchResource(String url) {
        try {
            RemoteResourceService service = new RemoteResourceService();
            InputStream inputStream = service.getResourceContent(url);
            return IOUtils.toByteArray(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch resource from URL: " + url, e);
        }
    }
}
```