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

public class FileService {

    public String findFilesWithPattern(String searchDir, String filePattern) {
        // Validate inputs
        if (searchDir == null || searchDir.isEmpty() || filePattern == null || filePattern.isEmpty()) {
            return "Invalid input parameters";
        }

        // Construct the command to execute
        String command = "find " + searchDir + " -maxdepth 1 -type f -name '" + filePattern + "' | head -n 10";

        try {
            // Execute the command
            Process process = Runtime.getRuntime().exec("bash -c \"" + command + "\"");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            // Read the output of the command
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command: " + command;
            }

            // Return the output as a string
            return output.toString().trim();
        } catch (IOException | InterruptedException e) {
            return "Exception occurred: " + e.getMessage();
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```