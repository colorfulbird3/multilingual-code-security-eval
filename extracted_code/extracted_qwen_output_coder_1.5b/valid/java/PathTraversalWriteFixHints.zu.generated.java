```java
import java.io.*;
import java.nio.file.*;

public class FileHandler {
    public static void handleFile(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("File does not exist: " + filePath);
            return;
        }
        try {
            String content = Files.readString(path);
            System.out.println("File content:\n" + content);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
```