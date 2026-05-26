```java
public List<File> findFilesWithPattern(String searchDir, String filePattern) {
    List<File> result = new ArrayList<>();
    File dir = new File(searchDir);
    if (!dir.exists() || !dir.isDirectory()) {
        return result;
    }
    File[] files = dir.listFiles();
    if (files == null) {
        return result;
    }
    Pattern pattern = Pattern.compile(filePattern);
    for (File file : files) {
        if (file.isFile() && pattern.matcher(file.getName()).matches()) {
            result.add(file);
        }
    }
    return result;
}
```