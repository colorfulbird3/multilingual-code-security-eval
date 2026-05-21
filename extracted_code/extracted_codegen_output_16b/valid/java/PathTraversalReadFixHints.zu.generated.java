```java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInitializer {
    public static void main(String[] args) {
        // Example 1: Using Files.createFile() with absolute path
        try {
            Path absolutePath = Paths.get("/home/user/documents/example.txt");
            Files.createFile(absolutePath);
            System.out.println("File created at: " + absolutePath);
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }

        // Example 2: Using Files.createDirectories() with absolute path
        try {
            Path directoryPath = Paths.get("/home/user/documents/newFolder");
            Files.createDirectories(directoryPath);
            System.out.println("Directory created at: " + directoryPath);
        } catch (IOException e) {
            System.err.println("Error creating directory: " + e.getMessage());
        }

        // Example 3: Using Files.write() with absolute path
        try {
            Path filePath = Paths.get("/home/user/documents/data.txt");
            String content = "Hello, World!";
            Files.write(filePath, content.getBytes());
            System.out.println("File written at: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }

        // Example 4: Using Files.readAllLines() with absolute path
        try {
            Path readPath = Paths.get("/home/user/documents/data.txt");
            Files.readAllLines(readPath).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        // Example 5: Using Files.delete() with absolute path
        try {
            Path deletePath = Paths.get("/home/user/documents/example.txt");
            Files.delete(deletePath);
            System.out.println("File deleted at: " + deletePath);
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }
}
```