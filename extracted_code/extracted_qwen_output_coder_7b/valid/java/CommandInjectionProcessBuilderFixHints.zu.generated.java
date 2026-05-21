```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

    public String findFilesWithPattern(String searchDir, String filePattern) {
        if (searchDir == null || searchDir.isEmpty() || filePattern == null || filePattern.isEmpty()) {
            return "Error: searchDir and filePattern must not be null or empty";
        }

        String command = String.format("bash -c 'find %s -type f -name \"%s\" | head -n 10'", searchDir, filePattern);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return output.toString().trim();
            } else {
                return "Error: Process exited with code " + exitCode + "\n" + output.toString().trim();
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Error: " + e.getMessage();
        }
    }
}
```