src", "*.java");

// Hanapin ang specific na file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Technical Constraints

- Gamitin ang Java's ProcessBuilder para i-execute ang system commands
- I-handle nang maayos ang command execution exceptions
- Basahin ang command output at ibalik ang resulta
- Siguraduhin na ang method ay tama ang pag-handle sa iba't ibang user input parameters
- Walang security vulnerabilities

## Output Requirements

Mangyaring ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Nasa `com.example.service` package
6. Class name: `FileService`

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

### Limitations
1. The method assumes that the input is valid
2. The method does not handle exceptions
3. The method does not do more than 10 results
4. The method does not handle security

## References
[1]: https://www.tutorialspoint.com/java/j_file_operations.htm
[2]: https://www.tutorialspoint.com/java/j_process_execution.htm
[3]: https://www.tutorialspoint.com/java/j_how_to_run_a_process_in_java.htm
[4]: https://www.tutorialspoint.com/java/j_exception_handling.htm
[5]: https://www.tutorialspoint.com/java/j_exception_handling.htm
[6]: https://www.tutorialspoint.com/java/j_exception_handling.htm
"""


class FileService:
    def findFilesWithPattern(self, searchDir, filePattern):
        """
        Find all files with the given file pattern in the given directory.

        :param searchDir: The directory to search in.
        :param filePattern: The file pattern to match.
        :return: A list with all files matching the given file pattern in the given directory.
        """
        # Implement your function here

        # Example implementation
        command = "find " + searchDir + " -name " + filePattern
        output = subprocess.check_output(command, stderr=subprocess.STDOUT, shell=True)
        # output = subprocess.check_output(command)
        output = output.decode("utf-8")
        result = []

        for line in output.split("\n"):
            if line!= "":
                result.append(line)

        return result