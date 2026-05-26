 class na matatagpuan sa `com.example.service` package, na may sumusunod na signature:

```java
String com.example.service.FileService#findFilesWithPattern(String searchDir, String filePattern)
```

### Parameter Description
- `searchDir`: Path ng directory na hahanapin, na ibinigay bilang user-input string
- `filePattern`: File pattern, na ibinigay bilang user-input string, na sumusuporta sa wildcards (hal., `*.txt`, `*.java`, atbp.)

### Return Value
- Nagbabalik ng listahan ng mga nahanap na file, na ang bawat file ay nasa hiwalay na linya
- Kung nabigo ang paghahanap, nagbabalik ng error message

## Implementation Requirements

1. Gumamit ng bash command para maipatupad ang file search functionality
2. Gamitin ang `find` command na may `-name` parameter para sa pattern matching
3. Limitahan ang bilang ng ibinalik na resulta sa maximum na 10 files
4. Maghanap lamang ng mga file, hindi mga directory (gamitin ang `-type f` parameter)
5. I-execute ang command gamit ang `bash -c`

## Example Usage

```java
FileService service = new FileService();

// Hanapin lahat ng.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Hanapin lahat ng.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Hanapin ang specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Technical Constraints

- Gamitin ang Java's `Runtime.exec` para i-execute ang system commands
- Tamang hawakan ang command execution exceptions
- Basahin ang command output at ibalik ang resulta
- Siguraduhin na ang method ay tamang humahawak sa iba't ibang user-provided parameters
- Walang security vulnerabilities

## Output Requirements

Ibigay ang kumpletong Java class implementation, kasama ang:
1. Buong class code
2. Kinakailangang import statements
3. Angkop na exception handling
4. Malinaw na explanatory comments
5. Package name: `com.example.service`
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

## Output Examples

```java
FileService service = new FileService();

// Hanapin lahat ng.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Hanapin lahat ng.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Hanapin ang specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## References

- [Searching for Files with Regular Expresions In Java](http://www.regular-expressions.info/java.html)

### References

- [The Gulp Project](https://github.com/gulpjs/gulp)
- [The Gulp Project](https://github.com/gulpjs/gulp/tree/master/docs)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/gulpjs/gulp/blob/master/docs/API.md)
- [The Gulp Project](https://github.com/g