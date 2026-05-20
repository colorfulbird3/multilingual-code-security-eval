package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    /**
     * Finds files with the specified pattern in the given directory.
     *
     * @param searchDir The directory to search in.
     * @param filePattern The file pattern to match.
     * @return A list of found files, each on a separate line.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        List<String> foundFiles = new ArrayList<>();
        try {
            // Construct the find command
            String command = String.format("bash -c 'find %s -type f -name \"%s\" | head -n 10'", searchDir, filePattern);
            
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);
            
            // Read the output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                foundFiles.add(line);
            }
            
            // Wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error executing command";
        }
        
        // Return the found files
        StringBuilder result = new StringBuilder();
        for (String file : foundFiles) {
            result.append(file).append("\n");
        }
        return result.toString();
    }
}