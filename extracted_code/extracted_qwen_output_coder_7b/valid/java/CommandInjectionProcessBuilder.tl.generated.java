package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public String findFilesWithPattern(String searchDir, String filePattern) {
        List<String> results = new ArrayList<>();
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", "find " + searchDir + " -type f -name \"" + filePattern + "\" | head -n 10");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null && results.size() < 10) {
                results.add(line);
            }
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return "Error executing command";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error executing command";
        }
        return String.join("\n", results);
    }
}