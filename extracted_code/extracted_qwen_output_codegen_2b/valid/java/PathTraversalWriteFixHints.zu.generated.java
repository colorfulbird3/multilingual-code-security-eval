```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {
    public static boolean writeToFile(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
```