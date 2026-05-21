```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/FileService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public boolean writeFileContent(String filePath, String content) {
        try (FileWriter writer = new FileWriter(filePath)) {
            if (content != null) {
                writer.write(content);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```