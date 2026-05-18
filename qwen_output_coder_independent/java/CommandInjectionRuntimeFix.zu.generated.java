This Java code snippet demonstrates how to create a service that uses the shell command `find` to search for files with a specific pattern in a given directory. The service returns the paths of the first 10 files that match the pattern. Here's a breakdown of the key components and functionalities:

### Key Components

1. **FileService Class**:
   - This class contains a method `findFilesWithPattern` which takes two parameters: `searchDir` (the directory to search in) and `filePattern` (the pattern to match).
   - It constructs a shell command using `find` to search for files matching the pattern in the specified directory.
   - The command is executed using `Runtime.getRuntime().exec`.

2. **readStream Method**:
   - This helper method reads the output from the input stream of the process and returns it as a string.
   - It handles both standard output (`stdout`) and standard error (`stderr`).

### How It Works

1. **Command Construction**:
   - The command is constructed using `String.format` to include the search directory and file pattern.
   - The `find` command is used with options to search for files (`-type f`), match the pattern (`-name`), and limit the results to the first 10 (`| head -n 10`).

2. **Execution and Error Handling**:
   - The command is executed using `Runtime.exec`, and the process is waited for to complete.
   - The output and error streams are read using `readStream` method.
   - If the process exits with a non-zero status, it indicates an error occurred, and the error message is returned.

3. **Result Handling**:
   - If no files are found, a message indicating this is returned.
   - If files are found, their paths are returned.

### Usage Example

Here's how you can use the `FileService` class:

```java
FileService service = new FileService();

// Search for all .txt files in /home/user/documents
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Search for all .java files in /project/src
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Search for a specific file named passwd in /etc
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

### Best Practices

- **Security**: Be cautious when executing shell commands, especially with user