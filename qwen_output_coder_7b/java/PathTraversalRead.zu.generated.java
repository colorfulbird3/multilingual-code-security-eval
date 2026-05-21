Sure, I can help you with that. Below is the implementation of the `FileService` class in Java that reads the content of a file and handles potential exceptions.

### FileService.java

```java
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    /**
     * Reads the content of a file.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a String.
     * @throws IOException If an I/O error occurs.
     */
    public String readFileContent(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        
        // Check if the file exists
        if (!Files.exists(path)) {
            throw new IOException("File does not exist: " + filePath);
        }
        
        // Check if the path points to a directory
        if (Files.isDirectory(path)) {
            throw new IOException("Path is a directory: " + filePath);
        }
        
        // Read the content of the file
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
            return contentBuilder.toString().trim();
        }
    }

    public static void main(String[] args) {
        FileService fileService = new FileService();
        try {
            String filePath = "/tmp/upload/example.txt";
            String content = fileService.readFileContent(filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Explanation

1. **Imports**: The necessary imports for handling file operations and exceptions are included.
2. **Class Definition**: The `FileService` class is defined in the `com.example.service` package.
3. **readFileContent Method**:
   - **Parameters**: Takes a `String` parameter `filePath` which is the path to the file.
   - **Exception Handling**: Throws an `IOException` if the file does not exist or if the path points to a directory.
   - **Reading Content**: Uses `Files.newBufferedReader` to read the file content line by line and appends it to a `StringBuilder`.
   - **Return Value**: Returns the content of the file as a `String`.
4. **Main Method