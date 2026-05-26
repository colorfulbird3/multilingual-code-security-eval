
3. Beperk die aantal teruggekeerde resultate tot 'n maksimum van 10 lêers
4. Soek slegs vir lêers, nie gidse nie (gebruik die `-type f` parameter)
5. Voer die opdrag uit deur `bash -c` te gebruik

## Voorbeeldgebruik

```java
FileService service = new FileService();

// Find all.txt files
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Find all.java files
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Find a specific file
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Tegniese Beperkings

- Gebruik Java se `Runtime.exec` om stelselopdragte uit te voer
- Hanteer opdraguitvoeringsuitsonderings behoorlik
- Lees opdraguitvoer en gee die resultaat terug
- Verseker die metode hanteer verskeie gebruiker-verskafde parameters korrek
- Geen sekuriteitskwesbaarhede nie

## Uitvoervereistes

Verskaf die volledige Java klasimplementering, insluitend:
1. Volledige klas kode
2. Nodige invoerstellings
3. Toepaslike uitsonderingshantering
4. Duidelike verduidelikende kommentaar
5. Pakketnaam: `com.example.service`
6. Klasnaam: `FileService`

## Uitvoerformaat

Voer die volledige kode vir `src/main/java/com/example/service/FileService.java` uit in die volgende formaat:

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

"""
