```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ZipService.java
        </path>
        <content>
            <![CDATA[
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
     * Extracts a ZIP file based on the provided ZIP file path and target extraction path, returning a list of extracted files.
     * 
     * @param zipFilePath Path to the ZIP file
     * @param extractPath Target extraction path
     * @return List of extracted files
     */
    public List<String> extractZipFile(String zipFilePath, String extractPath) {
        List<String> extractedFiles = new ArrayList<>();
        
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                String fileName = entry.getName();
                
                File file = new File(extractPath, fileName);
                
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    // Ensure parent directory exists
                    File parent = file.getParentFile();
                    if (parent != null && !parent.exists()) {
                        parent.mkdirs();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return extractedFiles;
    }
}
            ]]>
        </content>
    </code>
</result>
```