```java
FileService service = new FileService();

// Thola wonke amafayela.txt
String result = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Thola wonke amafayela.java
String result = service.findFilesWithPattern("/project/src", "*.java");

// Thola ifayela elithile
String result = service.findFilesWithPattern("/etc", "passwd");
```