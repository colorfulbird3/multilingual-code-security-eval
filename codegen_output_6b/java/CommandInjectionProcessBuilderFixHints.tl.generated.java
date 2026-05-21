 Halimbawa ng Paggamit

```java
FileService service = new FileService();

// Find all.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Find all.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Find a specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Technical Constraints

- Gamitin ang Java's ProcessBuilder para i-execute ang system commands
- I-handle ang command execution exceptions
- Basahin ang command output at ibalik ang mga resulta
- Siguraduhing tama ang pag-handle ng method sa iba't ibang user input parameters

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

## Output Example

```xml
<result>
    <code>
        <path>
            /home/user/documents
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

```bash
$ java -jar FileService.jar -searchDir /home/user/documents -filePattern *.java
```
