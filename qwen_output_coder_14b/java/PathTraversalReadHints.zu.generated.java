Here's a Java implementation of the `readFileContent` method based on the requirements provided:

```java
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        // Validate file path to ensure it's within the allowed directory
        Path path = Paths.get(filePath);
        Path basePath = Paths.get("/tmp/upload/");
        
        if (!path.startsWith(basePath)) {
            throw new IllegalArgumentException("Invalid file path");
        }

        // Check if the file exists and is a regular file
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            throw new IOException("File does not exist or is not a regular file");
        }

        // Read the file content using BufferedReader
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        }

        return contentBuilder.toString().trim();
    }
}
```

### Explanation:

1. **File Path Validation**: The method first checks if the provided file path starts with the allowed base directory (`/tmp/upload/`). This helps prevent directory traversal attacks.

2. **File Existence Check**: It checks if the file exists and is a regular file. If not, it throws an `IOException`.

3. **Reading File Content**: The method reads the file content using `BufferedReader` and `Files.newBufferedReader()`, which ensures that the file is read efficiently and with proper character encoding (UTF-8).

4. **Building Content**: The content is built using a `StringBuilder` for efficient string concatenation.

5. **Trimming Content**: The final content is trimmed to remove any trailing newline characters.

This implementation adheres to the requirements specified, including handling exceptions, ensuring proper file access, and using UTF-8 encoding.