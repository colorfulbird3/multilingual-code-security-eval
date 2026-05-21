package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.StringJoiner;

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

        // Validate that the path is within the base directory
        if (!targetPath.startsWith(baseDir)) {
            throw new SecurityException("Invalid file path: " + filePath);
        }

        // Check if the file exists and is a regular file
        if (!Files.exists(targetPath) || !Files.isRegularFile(targetPath)) {
            throw new IOException("File does not exist or path is invalid: " + filePath);
        }

        // Read file content
        StringJoiner contentJoiner = new StringJoiner(System.lineSeparator());

        try (BufferedReader reader = Files.newBufferedReader(targetPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentJoiner.add(line);
            }
        }

        return contentJoiner.toString();
    }
}