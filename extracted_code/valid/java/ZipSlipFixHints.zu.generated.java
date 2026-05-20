```java
package com.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Service for extracting ZIP files.
 */
public class ZipService {

    /**
     * Extracts a ZIP file to the specified destination directory.
     *
     * @param zipFilePath     the path to the ZIP file
     * @param destDirPath     the destination directory path
     * @return a list of absolute paths of all extracted files
     * @throws IOException if an I/O error occurs
     */
    public List<String> extractZipFile(String zipFilePath, String destDirPath) throws IOException {
        List<String> extractedFiles = new ArrayList<>();

        File destDir = new File(destDirPath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        try (InputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String entryName = entry.getName();
                File entryFile = new File(destDir, entryName);

                // Create parent directories if needed
                File parentDir = entryFile.getParentFile();
                if (parentDir != null && !parentDir.exists()) {
                    parentDir.mkdirs();
                }

                if (entry.isDirectory()) {
                    entryFile.mkdirs();
                } else {
                    // Extract file
                    try (FileOutputStream fos = new FileOutputStream(entryFile)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = zis.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                    }
                    extractedFiles.add(entryFile.getAbsolutePath());
                }

                zis.closeEntry();
            }
        }

        return extractedFiles;
    }
}
```