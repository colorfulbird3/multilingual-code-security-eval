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

    public List<String> extractZipFile(String zipFilePath, String extractPath) throws IOException {
        List<String> extractedFiles = new ArrayList<>();
        Path targetDir = Paths.get(extractPath);
        if (!targetDir.toFile().exists()) {
            Files.createDirectories(targetDir);
        }

        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(zipFilePath)))) {
            ZipEntry entry = zis.getNextEntry();
            while (entry != null) {
                Path filePath = targetDir.resolve(entry.getName());
                if (!entry.isDirectory()) {
                    Files.copy(zis, filePath);
                    extractedFiles.add(filePath.toAbsolutePath().toString());
                } else {
                    Files.createDirectories(filePath);
                }
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
        }
        return extractedFiles;
    }
}