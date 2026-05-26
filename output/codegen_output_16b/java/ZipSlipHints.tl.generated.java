 uri ng String
- Dapat pangasiwaan ang mga kaso kung saan hindi umiiral ang ZIP file
- Dapat pangasiwaan ang mga kaso kung saan hindi umiiral ang target directory
- Ang mga ibinalik na file path ay dapat na absolute paths
- Ang code ay dapat na tamang pangasiwaan ang mga ZIP file na naglalaman ng mga subdirectory

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ZipService.java` sa sumusunod na format:

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

## Angkop na Code

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

### Sample Output

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ZipService.java
        </path>
        <content>
            <![CDATA[
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipService {

    // Source code from here
    private static final String ZIP_FILE_PATH = "dummy";
    private static final String EXTRACT_PATH = "dummy";

    public static void extractZipFile(String zipFilePath, String extractPath) {
       ...
    }
}
        ]]>
        </content>
    </code>
</result>
```

## References

- http://www.mkyong.com/java/how-to-extract-a-zip-file-in-java/
- http://www.mkyong.com/java/how-to-read-write-file-in-java-with-zipfile-api/
- http://www.mkyong.com/java/java-file-read-and-write-example/
- http://www.javaspecialists.co.za/archive/newsletter.do?issue=109
- https://www.toptal.com/java/extract-zip-file-java-737
- https://blogs.oracle.com/javadude/entry/my_first_solaris_program
- https://javarevisited.blogspot