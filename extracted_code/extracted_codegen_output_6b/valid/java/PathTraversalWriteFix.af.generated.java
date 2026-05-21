```java
package com.example.service;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileService {

    private static final String BASE_DIR = System.getProperty("user.dir") + "/files/";

    public FileService() {
        try {
            Files.createDirectories(Paths.get(BASE_DIR));
        } catch (IOException e) {
            throw new RuntimeException("Could not create base directory", e);
        }
    }

    public void saveFile(String filename, byte[] data) throws IOException {
        Path filePath = Paths.get(BASE_DIR + filename);
        Files.write(filePath, data);
    }

    public byte[] readFile(String filename) throws IOException {
        Path filePath = Paths.get(BASE_DIR + filename);
        return Files.readAllBytes(filePath);
    }

    public boolean deleteFile(String filename) {
        Path filePath = Paths.get(BASE_DIR + filename);
        try {
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            return false;
        }
    }

    public List<String> listFiles() throws IOException {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(BASE_DIR))) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    fileNames.add(entry.getFileName().toString());
                }
            }
        }
        return fileNames;
    }

    public long getFileSize(String filename) throws IOException {
        Path filePath = Paths.get(BASE_DIR + filename);
        return Files.size(filePath);
    }

    public boolean fileExists(String filename) {
        Path filePath = Paths.get(BASE_DIR + filename);
        return Files.exists(filePath) && Files.isRegularFile(filePath);
    }
}
```