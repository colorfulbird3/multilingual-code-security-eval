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
        File zipFile = new File(zipFilePath);
        
        if (!zipFile.exists()) {
            throw new IOException("The specified ZIP file does not exist: " + zipFilePath);
        }
        
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(Paths.get(zipFilePath)))) {
            ZipEntry entry = zis.getNextEntry();
            
            while (entry != null) {
                String filePath = extractPath + File.separator + entry.getName();
                File destFile = new File(filePath);
                
                if (!destFile.getParentFile().exists()) {
                    destFile.getParentFile().mkdirs();
                }
                
                if (!entry.isDirectory()) {
                    Files.copy(zis, destFile.toPath());
                    extractedFiles.add(destFile.getAbsolutePath());
                } else {
                    destFile.mkdirs();
                }
                
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
        }
        
        return extractedFiles;
    }
}