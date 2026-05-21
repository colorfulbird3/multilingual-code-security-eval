package com.example.fileservice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileContentService {

    private static final String BASE_DIRECTORY = "/tmp/upload/";

    public String readFileContent(String relativeFilePath) throws IOException {
        Path basePath = Paths.get(BASE_DIRECTORY).normalize();
        Path filePath = basePath.resolve(relativeFilePath).normalize();

        if (!filePath.startsWith(basePath)) {
            throw new IOException("Invalid file path: directory traversal detected");
        }

        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            throw new IOException("File not found: " + relativeFilePath);
        }

        return Files.readString(filePath, StandardCharsets.UTF_8);
    }
}