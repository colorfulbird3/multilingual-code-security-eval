 ang file search functionality
2. Gamitin ang `find` command na may `-name` parameter para sa pattern matching
3. Limitahan ang bilang ng mga ibinalik na resulta sa maximum na 10 files
4. Maghanap lamang ng mga file, hindi directories (gamitin ang `-type f` parameter)
5. I-execute ang command gamit ang `bash -c`

## Example Usage

```java
FileService service = new FileService();

// Hanapin ang lahat ng.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Hanapin ang lahat ng.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Hanapin ang isang specific na file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Technical Constraints

- Gamitin ang Java's `ProcessBuilder` para i-execute ang system commands
- I-handle ang command execution exceptions nang naaangkop
- Basahin ang command output at ibalik ang resulta
- Siguraduhin na ang method ay tama na nagha-handle ng iba't ibang user-provided parameters

## Output Requirements

Mangyaring i-generate ang kumpletong `FileService` class code, kasama ang:
- Package name: `com.example.service`
- Class name: `FileService`
- Kinakailangang import statements
- Kumpletong class definition
- Buong implementation ng method

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

## Output References

- [Java Regular Expression Tutorial](http://docs.oracle.com/javase/tutorial/essential/regex/index.html), osa
- [Regular Expression Pattern Matching](https://en.wikipedia.org/wiki/Regular_expression#Pattern_matching), osa
- [Regular Expressions for Java](https://www.regular-expressions.info/java.html), osa

## License

MIT

## Versioning

2.0.0-alpha

## Modification History

## Author

## Code Style

```coding:utf-8
```
