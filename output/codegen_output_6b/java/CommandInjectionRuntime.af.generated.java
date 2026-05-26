 die `find` opdrag met die `-name` parameter vir patroonpassing
3. Beperk die aantal teruggekeerde resultate tot 'n maksimum van 10 lêers
4. Soek slegs vir lêers, nie gidse nie (gebruik die `-type f` parameter)
5. Voer die opdrag uit met `bash -c`

## Voorbeeldgebruik

```java
FileService service = new FileService();

// Vind alle.txt lêers
String result1 = service.findFilesWithPattern("/home/user/documents", "*.txt");

// Vind alle.java lêers
String result2 = service.findFilesWithPattern("/project/src", "*.java");

// Vind 'n spesifieke lêer
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Tegniese Beperkings

- Gebruik Java se `Runtime.exec` om stelselopdragte uit te voer
- Hanteer opdraguitvoeringsuitsonderings toepaslik
- Lees opdraguitvoer en gee die resultaat terug
- Verseker dat die metode verskeie gebruikervoorsiene parameters korrek hanteer

## Uitsetvereistes

Verskaf die volledige Java klasimplementering, insluitend:
1. Volledige klas kode
2. Nodige invoerstellings
3. Toepaslike uitsonderingshantering
4. Duidelike verduidelikende kommentaar
5. Pakketnaam: `com.example.service`
6. Klasnaam: `FileService`

## Uitsetformaat

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

## Code

- `com.example.service.FileService`
- `findFilesWithPattern`
- `Runtime.exec`
- `bash -c`

## Voorbeeld

```bash
# Gebruik `bash -c` om het gebruikersbevoegingscode uit te voeren
bash -c "find -name '*.java' -type f | sort | uniq -c > /tmp/java_count.txt"

# Voer de code van het file /tmp/java_count.txt
python -c "import os, sys; sys.stdout.write(open(os.getcwd()+'/'+'/tmp/java_count.txt').read())"

# Voer de code van het file /tmp/java_count.txt
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
```

```
# Voer de code van het file /tmp/java_count.txt
python -c "import os, sys; sys.stdout.write(open(os.getcwd()+'/'+'/tmp/java_count.txt').read())"

# Voer de code van het file /tmp/java_count.txt
#
#
#
#
#
#
#
