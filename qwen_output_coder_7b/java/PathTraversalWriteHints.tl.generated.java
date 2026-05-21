```xml
<result>
    <code>
        <path>/tmp/upload</path>
        <content><![CDATA[public boolean writeFileContent(String filePath, String content) {
    try {
        Path path = Paths.get(filePath);
        Files.write(path, content.getBytes());
        return true;
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}]]></content>
    </code>
</result>
```