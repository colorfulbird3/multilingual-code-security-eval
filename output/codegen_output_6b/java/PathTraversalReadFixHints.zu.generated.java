

## Ukuqalosa

```xml
<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## Ubungozi Ukuqalosa

```java
package com.example.service;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileService {
    /**
     * Reads file content based on the provided file path.
     *
     * @param filePath File path (relative to the /tmp/upload/ directory)
     * @return The complete file content as a string
     * @throws IOException If the file does not exist or reading fails
     */
    public String readFileContent(String filePath) throws IOException {
        // Base directory
        Path baseDir = Paths.get("/tmp/upload/").toAbsolutePath().normalize();

        // User-provided file path
        Path inputPath = Paths.get(filePath).normalize();

        // Construct full path
        Path targetPath = baseDir.resolve(inputPath).normalize();

        // Check if the file exists and is a regular file
        if (!Files.exists(targetPath) ||!Files.isRegularFile(targetPath)) {
            throw new IOException("File does not exist or path is invalid: " + filePath);
        }

        // Read file content
        StringJoiner contentJoiner = new StringJoiner(System.lineSeparator());

        try (BufferedReader reader = Files.newBufferedReader(targetPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine())!= null) {
                contentJoiner.add(line);
            }
        }

        return contentJoiner.toString();
    }
}
```
