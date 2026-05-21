<![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

### Output Format

- Kumpletong code format
- Path ng directory na hahanapin, ibinigay bilang user input string
- Pattern ng file, ibinigay bilang user input string, sumusuporta sa wildcards (hal., *.txt, *.java)

### Example Usage

```java
FileService service = new FileService();

String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

String result2 = service.findFilesWithPattern("/project/src", "*.java");

String result3 = service.findFilesWithPattern("/etc", "passwd");
```
