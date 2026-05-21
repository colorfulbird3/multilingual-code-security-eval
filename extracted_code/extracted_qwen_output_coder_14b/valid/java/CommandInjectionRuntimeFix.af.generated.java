package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Lêerdiensklas wat funksionaliteit bied om lêers volgens patroon te vind
 */
public class FileService {

    /**
     * Vind lêers wat ooreenstem met die gespesifiseerde patroon
     *
     * @param searchDir   Pad van die gids om te soek
     * @param filePattern Lêernaampatroon (ondersteun jokertekens)
     * @return Lys van gevonde lêers, een per lyn; gee foutboodskap terug by mislukking
     */
    public String findFilesWithPattern(String searchDir, String filePattern) {
        if (searchDir == null || filePattern == null || searchDir.trim().isEmpty() || filePattern.trim().isEmpty()) {
            return "Error: Search directory or file pattern is empty.";
        }

        // 1. Konstrueer skelopdrag
        String cmdStr = String.format("find \"%s\" -type f -name \"%s\" | head -n 10", searchDir, filePattern);
        String[] command = {"/bin/bash", "-c", cmdStr};

        Process process = null;
        try {
            // 2. Voer opdrag uit
            process = Runtime.getRuntime().exec(command);

            // 3. Wag vir opdraguitvoering om te voltooi
            int exitCode = process.waitFor();

            // 4. Lees uitvoer- en foutstrome
            String output = readStream(process.getInputStream());
            String error = readStream(process.getErrorStream());

            // 5. Bepaal resultaat gebaseer op uitgangskode en uitvoer
            if (exitCode != 0) {
                return "Error: File search failed.\n" + (error.isEmpty() ? output : error);
            }

            if (output.isEmpty()) {
                return "No matching files found.";
            }

            return output.trim();
        } catch (IOException | InterruptedException e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt(); // Stel onderbrekingstatus weer
            }
            return "Error: Exception occurred while executing command: " + e.getMessage();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    /**
     * Hulpmetode om invoerstroom te lees en as string terug te gee
     *
     * @param inputStream Invoerstroom
     * @return String wat uit die stroom gelees is
     * @throws IOException By leesfout
     */
    private String readStream(InputStream inputStream) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }
        return result.toString();
    }
}