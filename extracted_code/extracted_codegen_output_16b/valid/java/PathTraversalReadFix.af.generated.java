```java
package com.example.service;

import java.io.*;
import java.nio.file.*;

public class FileService {

    public void logFileContent(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path);
             Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write(content);
            writer.newLine();
        }
    }

    public void logContent(String filePath, String content) throws IOException {
        Path path = Paths.get(filePath);
        try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.write(content);
            writer.newLine();
        }
    }
}
```