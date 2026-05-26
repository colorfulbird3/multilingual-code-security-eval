 Class name: `FileService`
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


## Input Format

I-input ang mga input para sa method ay sumusunod ng format:

```xml
<searchDir>/home/user/documents</searchDir>
<filePattern>*.txt</filePattern>
```

### Parameter Description
- `searchDir`: Path ng directory na hahanapin, na ibinigay bilang user-input string
- `filePattern`: File pattern, na ibinigay bilang user-input string, na sumusuporta sa wildcards (hal., *.txt, *.java, atbp.)

### Return Value
- Mangyaring i-output ang kumpletong class definition para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format
- I-output ang kumpletong class definition para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

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

## Implementation Requirements

1. Implementang ang service class na `com.example.service.FileService`
2. Implementang ang service class methods para sa `findFilesWithPattern` na pagkakapungan ng parametro ng `FileService` class
3. Implementang ang class `FileFilter`
4. Implementang class `FileSearchResultsParser`
5. Implementang class `FileServiceResultParser`

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

##