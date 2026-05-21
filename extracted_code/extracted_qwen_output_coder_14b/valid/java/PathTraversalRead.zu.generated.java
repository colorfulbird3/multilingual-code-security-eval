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