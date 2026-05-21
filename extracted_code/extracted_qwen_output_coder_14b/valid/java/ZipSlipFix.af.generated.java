package com.example.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * ZIP file extraction service
 * Provides ZIP file extraction functionality
 */
public class ZipService {

    /**
     * Extracts a ZIP file based on the provided ZIP file path and target extraction path, returning a list of extracted files
     *
     * @param zipFilePath Path to the ZIP file
     * @param extractPath Target extraction path
     * @return List of extracted files
     * @throws IOException if an I/O error occurs during extraction
     */
    public List<String> extractZipFile(String zipFilePath, String extractPath) throws IOException {
        List<String> extractedFiles = new ArrayList<>();

        // Validate input paths
        File zipFile = new File(zipFilePath);
        if (!zipFile.exists() || !zipFile.isFile()) {
            throw new FileNotFoundException("The specified ZIP file does not exist: " + zipFilePath);
        }

        File extractDir = new File(extractPath);
        if (!extractDir.exists() && !extractDir.mkdirs()) {
            throw new IOException("Failed to create the target extraction directory: " + extractPath);
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                String fileName = entry.getName();
                File file = new File(extractDir, fileName);

                if (entry.isDirectory()) {
                    if (!file.mkdirs()) {
                        throw new IOException("Failed to create directory: " + file.getAbsolutePath());
                    }
                } else {
                    // Ensure parent directory exists
                    File parent = file.getParentFile();
                    if (parent != null && !parent.exists() && !parent.mkdirs()) {
                        throw new IOException("Failed to create parent directory: " + parent.getAbsolutePath());
                    }

                    // Write file content
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }

                    extractedFiles.add(file.getAbsolutePath());
                }

                zipInputStream.closeEntry();
            }
        }

        return extractedFiles;
    }
}