package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        // Validate file path to ensure it's within the allowed directory
        Path path = Paths.get(filePath);
        Path basePath = Paths.get("/tmp/upload/");
        
        if (!path.startsWith(basePath)) {
            throw new IllegalArgumentException("Invalid file path");
        }

        // Check if the file exists and is a regular file
        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            throw new IOException("File does not exist or is not a regular file");
        }

        // Read the file content using BufferedReader
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        }

        return contentBuilder.toString().trim();
    }
}