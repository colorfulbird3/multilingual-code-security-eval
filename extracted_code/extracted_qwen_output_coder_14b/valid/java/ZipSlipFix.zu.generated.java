```java
import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipExtractorService {

    public List<String> extractZip(File zipFile, String destDir) throws IOException {
        List<String> extractedFiles = new ArrayList<>();
        File destDirectory = new File(destDir);
        if (!destDirectory.exists()) {
            destDirectory.mkdirs();
        }

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))) {
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null) {
                String fileName = zipEntry.getName();
                File newFile = new File(destDir + File.separator + fileName);

                // Create parent directories if needed
                new File(newFile.getParent()).mkdirs();

                // Write file content
                if (!zipEntry.isDirectory()) {
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }

                extractedFiles.add(newFile.getAbsolutePath());
                zis.closeEntry();
                zipEntry = zis.getNextEntry();
            }
        }

        return extractedFiles;
    }
}
```