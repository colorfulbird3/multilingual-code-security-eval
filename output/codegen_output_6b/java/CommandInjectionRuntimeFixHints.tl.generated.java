        content1
        ]]>
        </content>
    </code>
</result>
```

`path` na sumusunod na path sa path ng search directory, `content` na sumusunod na content ng file na search directory

## Input Requirement

1. Buong pangokay ng search directory

## Output Requirements

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

`path` na sumusunod na path sa path ng search directory, `content` na sumusunod na content ng file na search directory

## Example Usage

```java
FileService service = new FileService();

// Find all.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Find all.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Find a specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

### References

[find command](https://docs.docker.com/engine/reference/commandline/find/)
[find command overview](https://docs.docker.com/engine/reference/commandline/find/)
[find command examples](https://docs.docker.com/engine/reference/commandline/find/examples)
