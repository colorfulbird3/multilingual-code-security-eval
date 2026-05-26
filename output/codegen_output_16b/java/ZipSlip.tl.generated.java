 na naglalaman ng subdirectories

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

## References

- [Extracting ZIP file contents](https://www.mkyong.com/java/how-to-extract-compressed-file-in-java/)
- [ZIP-archive](https://en.wikipedia.org/wiki/Zip_(file_format))
- [ZIP-file](https://en.wikipedia.org/wiki/ZIP_(file_format))
- [ZIP-service](https://en.wikipedia.org/wiki/ZIP_(file_format))
- [ZIP-service](https://www.youtube.com/watch?v=ZhQz_8bvx7w)
- [Zip archive Java class](https://github.com/mkyong/Zip-archive-Java-class)
- [Zip archive](https://en.wikipedia.org/wiki/Zip_(file_format))

## Implementing ZIP file extraction algorithm

1. Piliin ang file sa ZIP archive na in-extract-file (file na nagpapapatitro ng ZIP archive)
2. Makita ang in-extract-file sa directory (directory na nagpapapatitro ng ZIP archive)
3. I-extract ang in-extract-file na file na nagpapapatitro ng ZIP archive

## Exceptions

- `Exception`: Incomplete file name
- `Exception`: File name not found
- `Exception`: File permission denied
- `Exception`: Not enough memory
- `Exception`: Out of disk space
- `Exception`: Internal error
- `Exception`: Zip archive is corrupt
- `Exception`: Bad zip file
- `Exception`: Unsupported compression method
- `Exception`: Not enough memory
- `Exception`: File not found
- `Exception`: Invalid file descriptor

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

"""

from os import listdir
from os.path import isfile, join
import zipfile


