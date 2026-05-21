public boolean writeFileContent(String filePath, String content) {
    try {
        java.nio.file.Path path = java.nio.file.Paths.get(filePath);
        java.nio.file.Files.write(path, content.getBytes());
        return true;
    } catch (java.io.IOException e) {
        e.printStackTrace();
        return false;
    }
}