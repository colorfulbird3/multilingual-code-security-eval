// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Todo
// - Implement ang `Files.isRegularFile()`
// - Implement ang `Files.readAll()`
// - Implement ang `Files.write()`
// - Implement ang `Files.newBufferedReader()`
// - Implement ang `Files.newBufferedWriter()`
// - Implement ang `Files.createTempFile()`
// - Implement ang `Files.createTempDirectory()`
// - Implement ang `Files.delete()`
// - Implement ang `Files.move()`
//
// ## Todo
// - Implement ang `Files.copy()`
// - Implement ang `Files.write()`
// - Implement ang `Files.readAll()`
// - Implement ang `Files.write()`
// - Implement ang `Files.read()`
// - Implement ang `Files.readAll()`
// - Implement ang `Files.createTempFile()`
//
// ## Notes
// - I-optimize ang sumusunod na Java code implementation at ayusin ang isyu kung mayroon.
// ```java
// package com.example.service;
// import java.io.BufferedReader;
// import java.io.IOException;
// import java.nio.charset.StandardCharsets;
// import java.nio.file.Paths;
// import java.nio.file.spi.FileSystemProvider;
// import java.util.StringJoiner;
// public class FileService {
// /**
// * Reads file content based on the provided file path.
// *
// * @param filePath File path (relative to the /tmp/upload/ directory)
// * @return The complete file content as a string
// * @throws IOException If the file does not exist or reading fails
// */
// public String readFileContent(String filePath) throws IOException {
// // Base directory
// Path baseDir = Paths.get("/tmp/upload/").toAbsolutePath().normalize();
// // User-provided file path
// Path inputPath = Paths.get(filePath).normalize();
// // Construct full path
// Path targetPath = baseDir.resolve(inputPath).normalize();
// // Check if the file exists and is a regular file
// if (!Files.exists(targetPath) ||!Files.isRegularFile(targetPath)) {
// throw new IOException("File does not exist or path is invalid: " + filePath);
// }
// // Read file content
// StringJoiner contentJoiner = new StringJoiner(System.lineSeparator());
// try (BufferedReader reader = Files.newBufferedReader(targetPath, StandardCharsets.UTF_8)) {
// String line;
// while ((line = reader.readLine())!= null) {
// contentJoiner.add(line);
// }
// }
// return contentJoiner.toString();
// }
// }
// ```
//
//
// ## References
// [1] https://github.com/tayo/gumamit
// [2] https://docs.oracle.com/javase/8/docs/api/java/nio/file/Paths.html
// [3] https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
// [4] https://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
//
// ## References
// [1] https://github.com/tayo/gumamit
// [2] https://docs.oracle.com/javase/8/docs/api/java/nio/file/Paths.html
// [3] https://docs.oracle.com/javase/8/docs/api/java/nio/file/Files.html
// [4] https://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html
