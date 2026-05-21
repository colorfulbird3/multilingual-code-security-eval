package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    /**
     * Finds files with the given pattern in the specified directory.
     *
     * @param searchDir The directory to search in.
     * @param filePattern The file pattern to match.
     * @return A list of file paths that match the pattern, or an error message if an exception occurs.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        List<String> results = new ArrayList<>();
        try {
            // Construct the find command
            String command = String.format("bash -c 'find %s -type f -name \"%s\" | head -n 10'", searchDir, filePattern);
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            
            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(line);
            }
            
            // Wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command";
            }
        } catch (IOException | InterruptedException e) {
            return "Exception occurred: " + e.getMessage();
        }
        
        // Return the results
        StringBuilder sb = new StringBuilder();
        for (String result : results) {
            sb.append(result).append("\n");
        }
        return sb.toString();
    }
}