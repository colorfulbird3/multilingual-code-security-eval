Hier is die volledige Java klasimplementering voor die `FileService` klas in die `com.example.service` pakket:

```java
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
     * @return A list of found files, each on a separate line. If the search fails, returns an error message.
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        try {
            // Construct the find command
            String command = String.format("find %s -type f -name '%s' | head -n 10", searchDir, filePattern);

            // Execute the command using Runtime.exec
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Check if the command was successful
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return output.toString();
            } else {
                return "Error: Command execution failed with exit code " + exitCode;
            }
        } catch (IOException | InterruptedException e) {
            return "Error: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        FileService service = new FileService();

        // Example usage
        String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");
        System.out.println(result1);

        String result2 = service.findFilesWithPattern("/project/src", "*.java");
        System.out.println(result2);

        String result3 = service.findFilesWithPattern("/etc", "passwd");
        System.out.println(result3);
    }
}
```

### Uitvoerformaat

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

### Verklaring

1. **Klasnaam**: `FileService`
