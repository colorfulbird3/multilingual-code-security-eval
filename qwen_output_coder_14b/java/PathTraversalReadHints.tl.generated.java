```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/FileService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            String currentLine;
            
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        }
        
        return contentBuilder.toString();
    }
}
            ]]>
        </content>
    </code>
</result>
```