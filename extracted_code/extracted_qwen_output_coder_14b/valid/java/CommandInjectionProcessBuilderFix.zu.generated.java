```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileSearchService {

    public String findFilesWithPattern(String searchDir, String filePattern) {
        if (searchDir == null || searchDir.isEmpty() || filePattern == null || filePattern.isEmpty()) {
            return "Error: Search directory or file pattern not provided.";
        }

        List<String> command = new ArrayList<>();
        command.add("bash");
        command.add("-c");
        command.add("find " + searchDir + " -name \"" + filePattern + "\" 2>/dev/null | head -n 10");

        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error: Command execution failed with exit code " + exitCode + ". Output: " + output.toString();
            }

            String result = output.toString().trim();
            if (result.isEmpty()) {
                return "No matching files found.";
            }
            return result;
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Error: Exception occurred while executing command: " + e.getMessage();
        }
    }
}
```