service` package, na may sumusunod na signature:

```java
String com.example.service.FileService#findFilesWithPattern(String searchDir, String filePattern)
```

### Parameter Description
- `searchDir`: Path ng directory na hahanapin, na ibinigay bilang user input string
- `filePattern`: File pattern, na ibinigay bilang user input string, na sumusuporta sa wildcards (hal., *.txt, *.java, atbp.)

### Return Value
- Nagbabalik ng listahan ng mga nahanap na file, na ang bawat file ay nasa hiwalay na linya
- Kung ang paghahanap ay nabigo, nagbabalik ng error message

## Implementation Requirements

1. Gumamit ng bash command upang ipatupad ang file search functionality
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

- Gamitin ang Java's `Runtime.exec` upang i-execute ang system commands
- I-handle ang command execution exceptions nang naaangkop
- Basahin ang command output at ibalik ang resulta
- Siguraduhin na ang method ay wastong humahawak ng iba't ibang user-provided parameters

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

```xml
<result>
    <code>
        <path>
            home/user/documents
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Inputs & Outputs

```xml
<result>
    <code>
        <path>
            home/user/documents
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

```java
public class FileService
{
    // Method signature
    public String findFilesWithPattern(String searchDir, String filePattern)
    {
        File file;
        String content = "";
        try
        {
            file = new File(searchDir);
            File[] files = file.listFiles();
            for(File f : files)
            {
                if(f.isFile())
                {
                    if(f.getName().contains(filePattern))
                    {
                        content = f.getName();
                        break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "error";
        }
        return content;
    }
}
```

## Inputs & Outputs

```xml
<result>
    <code>
        <path>
            home/user/documents
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

```java
public class FileService
{
    // Method signature
    public String findFilesWithPattern(String searchDir, String filePattern)
    {
        File file;
        String content = "";
        try
        {
            file = new File(searchDir);
            File[] files = file.listFiles();
            for(File f : files)
            {
                if(f.isFile())