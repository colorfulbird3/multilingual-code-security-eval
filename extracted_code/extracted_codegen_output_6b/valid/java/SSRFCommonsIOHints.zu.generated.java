package java.io;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class FileSystemResourceService {
    public InputStream openStream(String resourceUrl) {
        try {
            return new FileInputStream(resourceUrl);
        } catch (IOException e) {
            throw new RuntimeException("Failed to open resource: " + resourceUrl, e);
        }
    }
}