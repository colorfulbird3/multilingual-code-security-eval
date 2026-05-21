
- Ang ZIP file path at extraction path na ibinigay ng user ay parehong uri ng String
- Pangasiwaan ang mga kaso kung saan hindi umiiral ang ZIP file
- Pangasiwaan ang mga kaso kung saan hindi umiiral ang target na direktoryo
- Ang mga ibinalik na file path ay dapat na absolute paths
- Ang code ay dapat humawak ng mga ZIP file na naglalaman ng mga subdirectory

## Format ng Output

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/ZipService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Mga Tala

- Ang kumpletong kaso kung saan hindi umiiral ang ZIP file
- Ang kumpletong kaso kung saan hindi umiiral ang target na direktoryo
- Ang kumpletong kaso kung saan hindi umiiral ang absolute path ng file
- Ang kumpletong kaso kung saan hindi umiiral ang absolute path ng mga subdirectory

## Mga Buukan

- Ang kumpletong kaso kung saan umiiral ang mga ZIP file na mga i-output
- Ang kumpletong kaso kung saan umiiral ang mga target na mga i-output
- Ang kumpletong kaso kung saan umiiral ang mga absolute path ng i-output
- Ang kumpletong kaso kung saan umiiral ang mga absolute path ng i-output

---

## Mga Teknikal na Kinakailangan

Java Code

```java
package com.example.service;

import java.io.*;
import java.util.*;

public class ZipService {
    
    public List<String> extractZipFile(String zipFilePath, String extractPath) {
        List<String> extractedFiles = new ArrayList<>();
        
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry())!= null) {
                String fileName = entry.getName();
                
                File file = new File(extractPath, fileName);
                
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    // Ensure parent directory exists
                    File parent = file.getParentFile();
                    if (parent!= null &&!parent.exists()) {
                        parent.mkdirs();
                    }
                    
                    // Write file content
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length