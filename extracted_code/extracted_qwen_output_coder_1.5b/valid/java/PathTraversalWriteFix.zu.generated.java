```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private final String basePath;

    public FileService(String basePath) {
        this.basePath = basePath;
    }

    public boolean writeToFile(String filePath, String content) {
        try {
            Path fullPath;
            Path filePathObj = Paths.get(filePath);
            
            if (filePathObj.isAbsolute()) {
                fullPath = filePathObj;
            } else {
                fullPath = Paths.get(basePath, filePath);
            }
            
            Path parentDir = fullPath.getParent();
            if (parentDir != null && !Files.exists(parentDir)) {
                Files.createDirectories(parentDir);
            }
            
            Files.writeString(fullPath, content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
```