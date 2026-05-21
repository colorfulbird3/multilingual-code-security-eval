package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

    /**
     * Finds files matching the given pattern in the specified directory.
     *
     * @param searchDir The directory to search in.
     * @param filePattern The file pattern to match, supporting wildcards.
     * @return A list of found files, one per line, or an error message if the search fails.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        StringBuilder result = new StringBuilder();
        try {
            // Construct the command to search for files with the given pattern
            String command = "find " + searchDir + " -type f -name '" + filePattern + "' -maxdepth 1 | head -n 10";

            // Execute the command using Runtime.exec
            Process process = Runtime.getRuntime().exec("bash -c \"" + command + "\"");

            // Read the output of the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            // Wait for the process to complete and check the exit value
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command: " + command;
            }

        } catch (IOException | InterruptedException e) {
            return "An error occurred: " + e.getMessage();
        }

        // Return the result as a string
        return result.toString();
    }
}