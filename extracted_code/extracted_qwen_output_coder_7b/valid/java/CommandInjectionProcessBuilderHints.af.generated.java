package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public String findFilesWithPattern(String searchDir, String filePattern) {
        try {
            // Maak 'n ProcessBuilder vir die bash-opdrag
            ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c", String.format("find %s -type f -name '%s' | head -n 10", searchDir, filePattern));
            processBuilder.redirectErrorStream(true);

            // Start die proses
            Process process = processBuilder.start();

            // Lees die output van die proses
            List<String> outputLines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    outputLines.add(line);
                }
            }

            // Verwacht die proses om te eindig
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return String.join("\n", outputLines);
            } else {
                return "Fout: Soektog misluk.";
            }
        } catch (IOException | InterruptedException e) {
            return "Fout: " + e.getMessage();
        }
    }
}