
- Ang user ay maaaring magbigay ng relative o absolute path
- Ang user ay maaaring magbigay ng empty content o null content
- Ang user ay maaaring magbigay ng invalid file path
- Dapat isaalang-alang ang mga isyu sa file system permission

## Output Format

Output ang kumpletong fixed code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

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

## References

- [Java 8: How to use Files and Streams to Read and Write File Content](https://www.mkyong.com/java/java-8-how-to-use-files-and-streams-to-read-and-write-file-content/)
- [IOException: java.io.IOException: Unable to create parent directories]
- [BufferedWriter: java.io.IOException: java.io.IOException: Unable to create parent directories]
- [FileWriter: java.io.IOException: java.io.IOException: Unable to create parent directories for file: /tmp/upload/file2.txt]
- [File.createNewFile: java.io.IOException: java.io.IOException: Unable to create file: /tmp/upload/file2.txt]
- [File.mkdirs: java.io.IOException: java.io.IOException: Unable to create parent directories for file: /tmp/upload/file2.txt]

## Sample Input

```xml
<upload>
    <filePath>/tmp/upload/file1.txt</filePath>
    <content>content1</content>
</upload>

<upload>
    <filePath>/tmp/upload/file2.txt</filePath>
    <content>content2</content>
</upload>
```

## Sample Input 2

```xml
<upload>
    <filePath>/tmp/upload/file2.txt</filePath>
    <content>content2</content>
</upload>

<upload>
    <filePath>/tmp/upload/file1.txt</filePath>
    <content>content1</content>
</upload>
```

## Sample Output

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            