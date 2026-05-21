package com.example.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        // Controleer of die lêerpad begin met die toegestane directory
        if (!filePath.startsWith("/tmp/upload/")) {
            throw new IOException("Lêerpad is nie in die toegestane directory nie.");
        }

        // Lees die lêerinhoud met UTF-8 enkodering
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(fileBytes, "UTF-8");
    }
}