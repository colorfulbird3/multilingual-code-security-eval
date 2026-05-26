```java
package com.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Isevisi yokukhipha amafayela e-ZIP.
 * Le kilasi inikeza indlela yokukhipha okuqukethwe kwefayela le-ZIP
 * iye kumfolda ohlosiwe.
 */
public class ZipService {

    /**
     * Ikhipha ifayela le-ZIP elinikeziwe iye kumfolda ohlosiwe.
     *
     * @param zipFilePath Indlela yefayela le-ZIP okufanele likhishwe
     * @param destDir     Umfolda lapho okuqukethwe kuzokhishwa khona
     * @throws IOException Uma kwenzeka iphutha lokufunda noma lokubhala
     */
    public void extractZipFile(String zipFilePath, String destDir) throws IOException {
        File destDirectory = new File(destDir);
        if (!destDirectory.exists()) {
            destDirectory.mkdirs();
        }

        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry = zipIn.getNextEntry();
            while (entry != null) {
                String filePath = destDir + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipIn, filePath);
                } else {
                    File dir = new File(filePath);
                    dir.mkdirs();
                }
                zipIn.closeEntry();
                entry = zipIn.getNextEntry();
            }
        }
    }

    /**
     * Ikhipha ifayela elilodwa kusuka ku-ZIP stream iye endleleni enikeziwe.
     *
     * @param zipIn   I-ZipInputStream equkethe ifayela
     * @param filePath Indlela yokubhala ifayela
     * @throws IOException Uma kwenzeka iphutha lokubhala
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = zipIn.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
```