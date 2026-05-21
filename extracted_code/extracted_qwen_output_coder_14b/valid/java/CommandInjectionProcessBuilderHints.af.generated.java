package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

    public String findFilesWithPattern(String searchDir, String filePattern) {
        StringBuilder result = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c",
                "find " + searchDir + " -type f -name '" + filePattern + "' | head -n 10");

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Fout: Die soektog het misluk.";
            }
        } catch (IOException | InterruptedException e) {
            return "Fout: 'n IO of Interrupted uitsondering het voorgekom.";
        }

        return result.toString().trim();
    }
}