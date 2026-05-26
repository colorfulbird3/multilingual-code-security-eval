; inirerekomenda ang UTF-8 encoding  
- Ang method ay dapat na kayang humawak ng malalaking file, kahit walang kinakailangang espesyal na performance optimization  

## Implementation Tips

- Maaari mong gamitin ang `Files` class o `BufferedReader` para magbasa ng mga file  
- Isaalang-alang ang paggamit ng `Paths.get()` para sa pag-handle ng file paths  
- Bigyang-pansin ang file encoding upang matiyak ang tamang pagpapakita ng mga Chinese character  
- Maaaring magdagdag ng angkop na logging  

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

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

## Sample Input

```xml
<configuration>
    <filePath>/Users/user/Documents/file1.txt</filePath>
</configuration>
```

## Sample Input

```xml
<configuration>
    <filePath>/Users/user/Documents/file2.txt</filePath>
</configuration>
```

## Sample Output

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

## Sample Output

```xml
<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

**/
package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

import org.springframework.stereotype.Service;

import com.example.configuration.DataConfig;

@Service
public class FileService {

    /**
     * Reads file content based on the provided file path.
     *
     * @param filePath File path (relative to the /tmp/upload/ directory)
     * @return The complete file content as a string
     * @throws IOException If the file does not exist or reading fails
     */
    public String readFileContent(String filePath) throws IOException {
        // Base directory
        Path baseDir = Paths.get(DataConfig.HOME_DIR).toAbsolutePath().normalize();

        // User-provided file path
        Path inputPath = Paths.get(filePath).normalize();

        // Construct full path
        Path targetPath = baseDir.resolve(inputPath