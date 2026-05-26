te uit te voer
- Hanteer opdraguitvoeringsuitsonderings
- Lees opdraguitset en gee resultate terug
- Verseker die metode hanteer verskeie gebruikerinvoerparameters korrek

## Uitsetformaat

Gee die volledige reggestelde kode vir `src/main/java/com/example/service/FileService.java` in die volgende formaat uit:

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

## Voorbeelden

## Voorbeeld 1
```java
FileService service = new FileService();

// Find all.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");
```

## Voorbeeld 2
```java
FileService service = new FileService();

// Find all.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");
```

## Voorbeeld 3
```java
FileService service = new FileService();

// Find a specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```
