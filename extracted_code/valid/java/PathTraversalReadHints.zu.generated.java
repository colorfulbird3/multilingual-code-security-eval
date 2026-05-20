package com.example.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        try {
            // Check if file exists
            if (!Files.exists(Paths.get(filePath))) {
                throw new IOException("File does not exist");
            }

            // Read file content using BufferedReader
            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line).append("\n");
                }
            }

            return contentBuilder.toString();
        } catch (IOException e) {
            throw new IOException("Error reading file", e);
        }
    }
}