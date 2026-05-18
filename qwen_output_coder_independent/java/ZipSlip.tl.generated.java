```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ZipService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipService {

    public List<String> extractZipFile(String zipFilePath, String extractPath) throws IOException {
        List<String> extractedFiles = new ArrayList<>();
        Path targetDir = Paths.get(extractPath);
        
        if (!Files.exists(targetDir)) {
            Files.createDirectories(targetDir);
        }

        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(zipFilePath)))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                Path filePath = targetDir.resolve(zipEntry.getName());
                if (!zipEntry.isDirectory()) {
                    Files.copy(zis, filePath);
                    extractedFiles.add(filePath.toAbsolutePath().toString());
                } else {
                    Files.createDirectories(filePath);
                }
                zipEntry = zis.getNextEntry();
            }
        }

        return extractedFiles;
    }
}
            ]]>
        </content>
    </code>
</result>
```