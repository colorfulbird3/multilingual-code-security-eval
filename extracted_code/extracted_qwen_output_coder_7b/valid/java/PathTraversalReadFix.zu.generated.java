```java
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.StringJoiner;

public class FileService {

    /**
     * Ifunda okuqukethwe kwefayela ngokusekelwe endleleni yefayela enikeziwe.
     *
     * @param filePath Indlela yefayela (ehambisana nesiwongcele /tmp/upload/)
     * @return Okuqukethwe okuphelele kwefayela njengomugqa
     * @throws IOException Uma ifayela lingekho noma ukufunda kuhluleka
     */
    public String readFileContent(String filePath) throws IOException {
        // Isiwongcele esiyisisekelo
        Path baseDir = Paths.get("/tmp/upload/").toAbsolutePath().normalize();

        // Indlela yefayela enikezwe umsebenzisi
        Path inputPath = Paths.get(filePath).normalize();

        // Yakha indlela ephelele
        Path targetPath = baseDir.resolve(inputPath).normalize();

        // Hlola ukuthi ifayela likhona futhi liyifayela elijwayelekile
        if (!Files.exists(targetPath) || !Files.isRegularFile(targetPath)) {
            throw new IOException("Ifayela alikho noma indlela ayivumelekile: " + filePath);
        }

        // Funda okuqukethwe kwefayela
        StringJoiner contentJoiner = new StringJoiner(System.lineSeparator());

        try (BufferedReader reader = Files.newBufferedReader(targetPath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentJoiner.add(line);
            }
        }

        return contentJoiner.toString();
    }
}
```