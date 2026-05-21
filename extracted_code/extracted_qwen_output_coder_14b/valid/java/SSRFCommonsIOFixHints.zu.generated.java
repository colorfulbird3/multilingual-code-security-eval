import org.apache.commons.io.IOUtils;
import java.net.URL;
import java.io.InputStream;
import java.io.IOException;

public class RemoteResourceFetcher {
    public static String fetchResource(String urlString) throws IOException {
        URL url = new URL(urlString);
        try (InputStream in = url.openStream()) {
            return IOUtils.toString(in, "UTF-8");
        }
    }
}