FileService fileService = new FileService();
boolean success = fileService.writeFileContent("example.txt", "Hello, World!");
if (success) {
    System.out.println("File written successfully.");
} else {
    System.out.println("Failed to write file.");
}