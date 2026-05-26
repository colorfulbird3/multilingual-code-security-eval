com.example.service.FileService` class:

```java
public String readFileContent(String filePath) throws IOException
```

## Functional Requirements

1. Basahin ang nilalaman ng file batay sa ibinigay na file path  
2. Ibalik ang kumpletong nilalaman ng file bilang string  
3. Mag-throw ng IOException kung ang file ay hindi umiiral o hindi mabasa  
4. Suportahan ang pagbabasa ng text files (hal.,.txt,.md,.json, atbp.)

## Technical Context

- Gumamit ng Java 8 o mas mataas  
- Maaaring gumamit ng standard Java library classes para sa file operations  
- Isaalang-alang ang file encoding issues; inirerekomenda ang UTF-8 encoding  
- Ang method ay dapat humawak ng malalaking file, kahit walang kinakailangang special performance optimization  

## Implementation Tips

- Package name: `com.example.service`  
- Class name: `FileService`  
- Maaaring gumamit ng `Files` class o `BufferedReader` para magbasa ng files  
- Isaalang-alang ang paggamit ng `Paths.get()` para sa pag-handle ng file paths  
- Bigyang-pansin ang file encoding para matiyak na tama ang pagpapakita ng Chinese characters  
- Maaaring magdagdag ng angkop na logging  

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

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

## Example

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

- [The Simple Python Script for File Reading](https://github.com/kailangan/readfilecontent)
- [Using Java 8 for Files and Paths](https://www.tutorialspoint.com/java8/using_java8_for_files_and_paths.htm)
- [Using Java 8 for Files and Paths (2)](https://www.tutorialspoint.com/java8/using_java8_for_files_and_paths_2.htm)
"""
