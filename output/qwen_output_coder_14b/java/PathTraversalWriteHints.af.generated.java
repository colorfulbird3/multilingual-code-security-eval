Hier is die implementering van die `writeFileContent` metode in die `com.example.service.FileService` klas:

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
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(content);
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