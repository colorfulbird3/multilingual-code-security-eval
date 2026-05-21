

## Tegnisweergave

### JUnit

```java
@org.junit.Test
public void testFileService() {
    FileService fileService = new FileService();

    // Teste om lêer van te koppelen
    String fileContent = fileService.readFileContent("/tmp/upload/path/to/file.txt");
    assertEquals("content1", fileContent);

    // Teste om lêer van te koppelen
    String fileContent1 = fileService.readFileContent("path/to/file.txt");
    assertEquals("content1", fileContent1);

    // Teste om lêer van te koppelen
    String fileContent2 = fileService.readFileContent("path/to/file.md");
    assertEquals("content1", fileContent2);
}
```
"""
