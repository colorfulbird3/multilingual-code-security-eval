Here is an example implementation of the `readFileContent` method in Java, following the guidelines provided:

```java
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        // Validate file path
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }

        // Check if the file exists and is readable
        if (!Files.exists(Paths.get(filePath)) || !Files.isReadable(Paths.get(filePath))) {
            throw new IOException("File does not exist or is not readable");
        }

        // Read the file content
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
    }
}
```

### Explanation:

1. **Validation**: The method first checks if the file path is null or empty and throws an `IllegalArgumentException` if it is.

2. **File Existence and Readability**: It checks if the file exists and is readable using `Files.exists()` and `Files.isReadable()`. If the file does not exist or is not readable, it throws an `IOException`.

3. **Reading File Content**: The method reads the file content using a `BufferedReader` with UTF-8 encoding. It appends each line to a `StringBuilder` and returns the complete content as a string.

4. **Exception Handling**: The method throws an `IOException` if there is an error during file reading.

This implementation ensures that the file is read correctly and handles potential errors gracefully.