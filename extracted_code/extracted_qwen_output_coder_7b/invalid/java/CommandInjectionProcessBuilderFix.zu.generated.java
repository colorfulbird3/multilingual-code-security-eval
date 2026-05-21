FileService service = new FileService();

// Search for all .txt files in /home/user/documents
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Search for all .java files in /project/src
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Search for a specific file named passwd in /etc
String result3 = service.findFilesWithPattern("/etc", "passwd");