package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * File service class providing functionality to find files by pattern
 */
public class FileService {

    /**
     * Find files matching the specified pattern
     *
     * @param searchDir   Path of the directory to search
     * @param filePattern Filename pattern (supports wildcards)
     * @return List of found files, one per line; returns error message on failure
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        if (searchDir == null || filePattern == null || searchDir.trim().isEmpty() || filePattern.trim().isEmpty()) {
            return "Error: Search directory or file pattern is empty.";
        }

        // Construct shell command
        String cmdStr = String.format("find \"%s\" -type f -name \"%s\" | head -n 10", searchDir, filePattern);
        String[] command = {"/bin/bash", "-c", cmdStr};

        Process process = null;
        try {
            // Execute command
            process = Runtime.getRuntime().exec(command);

            // Wait for command execution to complete
            int exitCode = process.waitFor();

            // Read output and error streams
            String output = readStream(process.getInputStream());
            String error = readStream(process.getErrorStream());

            // Determine result based on exit code and output
            if (exitCode != 0) {
                return "Error: File search failed.\n" + (error.isEmpty() ? output : error);
            }

            if (output.isEmpty()) {
                return "No matching files found.";
            }

            return output.trim();
        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt(); // Re-set interrupt status
            }
            return "Error: Exception occurred while executing command: " + e.getMessage();
        } finally {
            if (process != null) {
                // Ensure child process is destroyed
                process.destroy();
            }
        }
    }

    /**
     * Helper method to read input stream and return as string
     *
     * @param inputStream Input stream
     * @return String read from the stream
     * @throws IOException On read error
     */
    private String readStream(InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }
        return result.toString();
    }
}