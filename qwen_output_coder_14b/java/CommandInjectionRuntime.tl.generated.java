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

    /**
     * Finds files with the given pattern in the specified directory.
     *
     * @param searchDir The directory to search in.
     * @param filePattern The file pattern to match, supporting wildcards.
     * @return A string containing the paths of found files, one per line, or an error message if an error occurred.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        // Command to be executed using the find command with the specified directory and pattern
        String command = "bash -c 'find " + searchDir + " -type f -name \"" + filePattern + "\" -maxdepth 1 | head -n 10'";

        try {
            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Read the output of the command
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return output.toString().trim(); // Trim to remove any trailing newline
            } else {
                return "Error executing command: " + command;
            }
        } catch (IOException | InterruptedException e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}
]]>
        </content>
    </code>
</result>
```