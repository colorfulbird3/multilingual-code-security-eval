package com.example.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipService {

    public List<String> extractZipFile(String zipFilePath, String extractPath) {
        List<String> extractedFiles = new ArrayList<>();
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(zipFilePath)))) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String filePath = Paths.get(extractPath, entry.getName()).toString();
                if (!entry.isDirectory()) {
                    File parentDir = new File(filePath).getParentFile();
                    if (!parentDir.exists() && !parentDir.mkdirs()) {
                        throw new IOException("Failed to create directory " + parentDir);
                    }
                    Files.copy(zis, Paths.get(filePath));
                    extractedFiles.add(filePath);
                } else {
                    File dir = new File(filePath);
                    if (!dir.exists() && !dir.mkdirs()) {
                        throw new IOException("Failed to create directory " + dir);
                    }
                }
                zis.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extractedFiles;
    }
}