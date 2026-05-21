package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileService {

    public String findFilesWithPattern(String searchDir, String filePattern) {
        StringBuilder result = new StringBuilder();
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "-c",
                "find " + searchDir + " -type f -name '" + filePattern + "' -maxdepth 1 | head -n 10");

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command";
            }
        } catch (IOException | InterruptedException e) {
            return "Error: " + e.getMessage();
        }

        return result.toString().trim();
    }
}