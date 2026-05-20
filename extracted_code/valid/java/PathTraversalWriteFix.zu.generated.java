public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        boolean success = fileService.writeFileContent("/tmp/upload/example.txt", "Hello, World!");
        if (success) {
            System.out.println("File written successfully.");
        } else {
            System.out.println("Failed to write file.");
        }
    }
}