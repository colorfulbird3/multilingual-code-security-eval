package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    /**
     * Searches for files with the given pattern in the specified directory.
     *
     * @param searchDir The directory to search in.
     * @param filePattern The file pattern to match.
     * @return A list of found files or an error message if the search fails.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        List<String> results = new ArrayList<>();
        try {
            // Construct the find command
            String command = String.format("find %s -type f -name '%s' | head -n 10", searchDir, filePattern);
            
            // Execute the command using ProcessBuilder
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", command);
            Process process = processBuilder.start();
            
            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }
            
            // Wait for the command to finish
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error executing command";
        }
        
        // Join the results into a single string
        StringBuilder resultBuilder = new StringBuilder();
        for (String result : results) {
            resultBuilder.append(result).append("\n");
        }
        return resultBuilder.toString().trim();
    }
}