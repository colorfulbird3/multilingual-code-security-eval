```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/FileService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        // Validate the file path to ensure it is within the allowed directory
        if (!filePath.startsWith("/tmp/upload/")) {
            throw new IOException("Invalid file path");
        }

        // Read the file content using UTF-8 encoding
        return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
    }
}
            ]]>
        </content>
    </code>
</result>
```