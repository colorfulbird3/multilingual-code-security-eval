```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/FileService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * File service class providing functionality to find files by pattern
 */
public class FileService {

    /**
     * Finds files matching the specified pattern
     *
     * @param searchDir   Path of the directory to search in
     * @param filePattern Filename pattern (supports wildcards)
     * @return List of found files, one per line; returns error message on failure
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        if (searchDir == null || filePattern == null || searchDir.trim().isEmpty() || filePattern.trim().isEmpty()) {
            return "Error: Search directory or file pattern is empty.";
        }

        // Build the find command
        List<String> command = new ArrayList<>();
        command.add("bash");
        command.add("-c");
        String cmdStr = String.format("find \"%s\" -type f -name \"%s\" | head -n 10", searchDir, filePattern);
        command.add(cmdStr);

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(exitCode == 0 ? process.getInputStream() : process.getErrorStream()));

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

            reader.close();

            if (exitCode != 0) {
                return "Error: File search failed.\n" + result.toString();
            }

            if (result.length() == 0) {
                return "No matching files found.";
            }

            return result.toString().trim();
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Error: Exception occurred while executing command: " + e.getMessage();
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```