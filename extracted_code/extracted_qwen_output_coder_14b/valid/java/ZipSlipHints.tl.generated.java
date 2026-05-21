package com.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
            throw new IOException("The specified zip file does not exist: " + zipFilePath);
        }
        
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry = zis.getNextEntry();
            
            while (entry != null) {
                Path filePath = Paths.get(extractPath, entry.getName());
                
                // Create directories if necessary
                if (!entry.isDirectory()) {
                    Files.createDirectories(filePath.getParent());
                    
                    // Extract the file
                    try (FileOutputStream fos = new FileOutputStream(filePath.toFile())) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                    extractedFiles.add(filePath.toAbsolutePath().toString());
                } else {
                    // Create the directory
                    Files.createDirectories(filePath);
                }
                
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
        }
        
        return extractedFiles;
    }
}