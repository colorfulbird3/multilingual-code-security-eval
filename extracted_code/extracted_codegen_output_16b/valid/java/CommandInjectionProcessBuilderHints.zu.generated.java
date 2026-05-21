```java
package com.example.service;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class FileService {

    private final Path baseDirectory;

    public FileService(String baseDirectory) {
        this.baseDirectory = Paths.get(baseDirectory).toAbsolutePath().normalize();
        if (!Files.exists(this.baseDirectory)) {
            throw new IllegalArgumentException("Base directory does not exist: " + this.baseDirectory);
        }
        if (!Files.isDirectory(this.baseDirectory)) {
            throw new IllegalArgumentException("Base path is not a directory: " + this.baseDirectory);
        }
    }

    public List<String> searchFiles(String pattern) throws IOException {
        Pattern regex = Pattern.compile(pattern);
        List<String> results = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(baseDirectory)) {
            stream.filter(Files::isRegularFile)
                  .filter(path -> regex.matcher(path.getFileName().toString()).find())
                  .forEach(path -> results.add(baseDirectory.relativize(path).toString()));
        }
        return results;
    }

    public String readFile(String relativePath) throws IOException {
        Path filePath = baseDirectory.resolve(relativePath).normalize();
        if (!filePath.startsWith(baseDirectory)) {
            throw new SecurityException("Access denied: " + relativePath);
        }
        return new String(Files.readAllBytes(filePath));
    }

    public void writeFile(String relativePath, String content) throws IOException {
        Path filePath = baseDirectory.resolve(relativePath).normalize();
        if (!filePath.startsWith(baseDirectory)) {
            throw new SecurityException("Access denied: " + relativePath);
        }
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, content.getBytes());
    }

    public boolean deleteFile(String relativePath) throws IOException {
        Path filePath = baseDirectory.resolve(relativePath).normalize();
        if (!filePath.startsWith(baseDirectory)) {
            throw new SecurityException("Access denied: " + relativePath);
        }
        return Files.deleteIfExists(filePath);
    }

    public List<String> listFiles(String relativeDirectory) throws IOException {
        Path dirPath = baseDirectory.resolve(relativeDirectory).normalize();
        if (!dirPath.startsWith(baseDirectory)) {
            throw new SecurityException("Access denied: " + relativeDirectory);
        }
        if (!Files.isDirectory(dirPath)) {
            throw new IllegalArgumentException("Not a directory: " + relativeDirectory);
        }
        try (Stream<Path> stream = Files.list(dirPath)) {
            return stream.map(path -> baseDirectory.relativize(path).toString())
                         .collect(Collectors.toList());
        }
    }

    public long getFileSize(String relativePath) throws IOException {
        Path filePath = baseDirectory.resolve(relativePath).normalize();
        if (!filePath.startsWith(baseDirectory)) {
            throw new SecurityException("Access denied: " + relativePath);
        }
        return Files.size(filePath);
    }

    public boolean fileExists(String relativePath) {
        Path filePath = baseDirectory.resolve(relativePath).normalize();
        return filePath.startsWith(baseDirectory) && Files.exists(filePath);
    }

    public String getBaseDirectory() {
        return baseDirectory.toString();
    }
}
```