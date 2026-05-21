public class FileService {
    public String findFilesWithPattern(String searchDir, String filePattern) {
        if (searchDir == null || filePattern == null || searchDir.trim().isEmpty()) {
            return "Error: Search directory or file pattern is empty.";
        }

        // 1. Construct shell command
        String cmdStr = String.format("find \"%s\" -type f -name \"%s\" | head -n 10", searchDir, filePattern);
        String[] command = {"/bin/bash", "-c", cmdStr};

        Process process = null;
        try {
            // 2. Execute command
            process = Runtime.getRuntime().exec(command);

            // 3. Wait for command execution to complete
            int exitCode = process.waitFor();

            // 4. Read output and error streams
            // Unlike ProcessBuilder.redirectErrorStream(true), Runtime.exec does not merge streams by default
            // Therefore, we need to read stdout and stderr separately
            String output = readStream(process.getInputStream());
            String error = readStream(process.getErrorStream());

            // 5. Determine result based on exit code and output
            if (exitCode!= 0) {
                // Command execution failed, return error information
                // Error messages are usually in the error stream, but sometimes also in the output stream
                return "Error: File search failed.\n" + (error.isEmpty()? output : error);
            }

            if (output.isEmpty()) {
                return "No matching files found.";
            }

            return output.trim();
        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt(); // Re-set interrupt status
            }
            return "Error: Exception occurred while executing command: " + e.getMessage();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    private String readStream(InputStream stream) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}