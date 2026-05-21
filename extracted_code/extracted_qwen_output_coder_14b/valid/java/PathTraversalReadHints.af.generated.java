package com.example.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public String readFileContent(String filePath) throws IOException {
        // Check if the file exists and is readable
        if (!Files.exists(Paths.get(filePath)) || !Files.isReadable(Paths.get(filePath))) {
            throw new IOException("File does not exist or is not readable");
        }

        // Read the file content using UTF-8 encoding
        return new String(Files.readAllBytes(Paths.get(filePath)), "UTF-8");
    }
}