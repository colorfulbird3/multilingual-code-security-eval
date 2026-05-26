string>
// <![CDATA[
// hello world
// ]]>
// </string>
// </code>
// </result>
// ```
// ## Test code
// ```java
// package com.example.service;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.TestInfo;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.junit.jupiter.api.ioextension.ExtensionContext;
// import org.junit.jupiter.api.ioextension.IOTestExecutionContext;
// import org.junit.jupiter.api.ioextension.IOTestExecutionContextProvider;
// import org.junit.jupiter.api.ioextension.TestExecutionExceptionHandler;
// import org.junit.jupiter.api.ioextension.TestExecutionResultHandler;
// import org.junit.jupiter.api.ioextension.TestExecutionResultHandlerProvider;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.nio.file.StandardOpenOption;
// import java.util.stream.Stream;
// import java.util.function.Function;
// import java.util.stream.StreamSupport;

// import static org.hamcrest.CoreMatchers.is;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertSame;

// @ExtendWith(IOTestExecutionContextProvider.class)
// @TestInfo(name = "IOTest")
// public class FileServiceTest {
// @Test
// public void readFileContent(IOTestExecutionContext context) {
// Path baseDir = Paths.get("/tmp/upload/").toAbsolutePath().normalize();
// Path inputPath = Paths.get("src/test/resources/file.txt");
// Path targetPath = baseDir.resolve(inputPath).normalize();
// // Check if the file exists and is a regular file
// if (!Files.exists(targetPath) ||!Files.isRegularFile(targetPath)) {
// throw new IOException("File does not exist or path is invalid: " + inputPath);
// }
// // Read file content
// String content = Files.readAllLines(targetPath, StandardCharsets.UTF_8).findFirst().get();
// // Assert content
// assertEquals("hello world", content);
// }
// }
// ```
// - Het gebruik van `Files.readAllLines()` komt voor het leesen van lêers in de `src/test/resources/file.txt` aangehaak.
// - Het leesen worden als de `src/test/resources/file.txt` geregisteerd word.
// - Gee file content
// - Ook die gewoon leesen worden moet met `StandardCharsets.UTF_8`
// - Hervoor komt de `IOException` met een `IOException` waarmee worden van deze leesen verwezen
// - Het leesen worden verwerk via `StreamSupport.stream` met `Files.readAllLines()`
// - De `toString()` methode wordt gebruikt bij `StandardCharsets.UTF_8`
// - Het leesen worden als de `src/test/resources/file.txt` geregisteerd word.
// - Het leesen worden op `/tmp/upload/file.txt`
// - Het leesen worden als de `/tmp/upload/file.txt` geregisteerd word.
// - Het leesen worden op `targetPath`
// - Het leesen worden als de `/tmp/upload/file.txt` geregisteerd word.
// - Het leesen worden als de `/tmp/upload/file.txt` geregisteerd word