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
     * @return A list of file paths that match the pattern, or an error message if the search fails.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        try {
            // Construct the find command with the given directory and pattern
            String command = String.format("find %s -type f -name '%s' | head -n 10", searchDir, filePattern);
            
            // Execute the command using Runtime.exec
            Process process = Runtime.getRuntime().exec(command);
            
            // Read the output from the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            
            // Wait for the command to finish
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return output.toString();
            } else {
                return "Error executing command";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error executing command";
        }
    }
}