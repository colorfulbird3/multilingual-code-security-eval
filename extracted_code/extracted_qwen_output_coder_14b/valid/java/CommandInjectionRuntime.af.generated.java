package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

    /**
     * Finds files matching the given pattern in the specified directory.
     *
     * @param searchDir The directory to search in.
     * @param filePattern The file pattern to match.
     * @return A string containing the list of found files, one per line.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        StringBuilder result = new StringBuilder();
        Process process;
        try {
            // Construct the command to execute the 'find' command with the given parameters
            String command = String.format("find %s -type f -name '%s' -maxdepth 1 | head -n 10", searchDir, filePattern);
            process = Runtime.getRuntime().exec(command);

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            // Wait for the command to finish and check if it was successful
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing the command.";
            }

        } catch (IOException | InterruptedException e) {
            return "An error occurred while searching for files: " + e.getMessage();
        }

        // Return the result as a string
        return result.toString();
    }
}