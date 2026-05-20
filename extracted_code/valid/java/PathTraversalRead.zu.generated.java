package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    /**
     * Reads the content of a file.
     *
     * @param filePath The path to the file.
     * @return The content of the file as a String.
     * @throws IOException If an I/O error occurs.
     */
    public String readFileContent(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        
        // Check if the file exists
        if (!Files.exists(path)) {
            throw new IOException("File does not exist: " + filePath);
        }
        
        // Check if the path points to a directory
        if (Files.isDirectory(path)) {
            throw new IOException("Path is a directory: " + filePath);
        }
        
        // Read the content of the file
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
            return contentBuilder.toString().trim();
        }
    }

    public static void main(String[] args) {
        FileService fileService = new FileService();
        try {
            String filePath = "/tmp/upload/example.txt";
            String content = fileService.readFileContent(filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}