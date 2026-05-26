od na format:

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

- [File-based persistence of Java objects](https://blog.jooq.org/2011/01/introduction-to-file-based-persistence-of-java-objects/)

'''



## Imports

- [API](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html)

## Class

### Methods

'''
public String readFileContent(String filePath) throws IOException
'''

- [Path](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Path.html)
- [FileSystem](https://docs.oracle.com/javase/8/docs/api/java/nio/file/FileSystem.html)
- [FileAttributes](https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/FileAttribute.html)
- [UserPrincipal](https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/UserPrincipal.html)
- [FileAttributeView](https://docs.oracle.com/javase/8/docs/api/java/nio/file/attribute/FileAttributeView.html)
- [Files.readAllBytes](https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html#readAllBytes-java.nio.file.Path)


'''
public final class FileService
    implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public String readFileContent(String filePath) throws IOException {
        Path filePathObject = Paths.get(filePath);
        try (BufferedReader br = Files.newBufferedReader(filePathObject)) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line!= null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            