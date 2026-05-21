import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.io.InputStream;

public byte[] getResourceContent(String resourceUrl) {
    try {
        URL url = new URL(resourceUrl);
        try (InputStream in = url.openStream()) {
            return IOUtils.toByteArray(in);
        }
    } catch (Exception e) {
        throw new RuntimeException("Failed to fetch resource from URL: " + resourceUrl, e);
    }
}