package com.example.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    private static final String BASE_PATH = "/tmp/upload";

    public boolean writeFileContent(String filePath, String content) {
        if (filePath == null || filePath.isEmpty()) {
            return false;
        }

        File targetFile;
        if (new File(filePath).isAbsolute()) {
            targetFile = new File(filePath);
        } else {
            targetFile = new File(BASE_PATH, filePath);
        }

        File parentDir = targetFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try {
            if (targetFile.createNewFile()) {
                // File created successfully
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            writer.write(content);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}