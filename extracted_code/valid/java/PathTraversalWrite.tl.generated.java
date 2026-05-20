public class FileService {
    public boolean writeFileContent(String filePath, String content) {
        try {
            java.io.FileWriter writer = new java.io.FileWriter(filePath);
            writer.write(content);
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}