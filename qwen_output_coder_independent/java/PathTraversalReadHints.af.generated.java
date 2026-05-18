Hier is die implementering van die `readFileContent` metode in die `FileService` klas:

```java
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        
        if (!Files.exists(path)) {
            throw new IOException("Lêer nie bestaan nie: " + filePath);
        }
        
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        }
        
        return contentBuilder.toString().trim();
    }
}
```

### Uitsetformaat

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/FileService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    public String readFileContent(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        
        if (!Files.exists(path)) {
            throw new IOException("Lêer nie bestaan nie: " + filePath);
        }
        
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        }
        
        return contentBuilder.toString().trim();
    }
}
            ]]>
        </content>
    </code>
</result>
```

### Uitleg van die implementering

1. **Path object**: Die `Paths.get(filePath)` word gebruikt om 'n `Path` object te maak van die gegee lêerpad.
2. **Bestaan van die lêer**: Die `Files.exists(path)` word gecontroleer om te verseker dat die lêer bestaan. Indien nie, word 'n `IOException` geworpen.
3. **Lees van die lêer**: Die `Files.newBufferedReader(path)` word gebruik om 'n `BufferedReader` te maak