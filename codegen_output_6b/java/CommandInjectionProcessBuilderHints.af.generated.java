 `-name` parameter vir patroonpassing
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

- Gebruik Java se ProcessBuilder om stelselopdragte uit te voer
- Hanteer opdraguitvoering uitsonderings toepaslik
- Lees opdraguitset en gee die resultaat terug
- Verseker die metode hanteer verskeie gebruiker invoer parameters korrek
- Geen sekuriteitskwesbaarhede

## Uitsetvereistes

Verskaf asseblief die volledige Java klas implementering, insluitend:
1. Volledige klas kode
2. Nodige invoerstellings
3. Toepaslike uitsonderingshantering
4. Duidelike verduidelikende kommentaar
5. Geleë in die `com.example.service` pakket
6. Klasnaam: `FileService`

## Uitsetformaat

Gee die volledige kode vir `src/main/java/com/example/service/FileService.java` in die volgende formaat:

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

## Uitvoeren

Voer die `bash -c` opdrag

## Uiterlagen

- Gebruik dit stelsel opdrag om de funksie te implementeer
- Gebruik die `bash -c` opdrag
- Gebeerbeperking van die lys

## Ontwikkeling

- Gebruik die `bash -c` opdrag om de Java klass te implementeer
- Gebruik die `bash -c` opdrag
- Gebeerbeperking van die lys
- Gebruik die `bash -c` opdrag om de funksie te implementeer
- Gebruik die `bash -c` opdrag
- Gebeerbeperking van die lys

**Pas vir lys**

- Uitslippen
- Gebruik die `bash -c` opdrag om de Java klass te implementeer
- Gebeerbeperking van die lys
- Uitslippen
- Gebeerbeperking van die lys

**Voorbeeld**

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

**Hoe moet 'n gebeurk worden**

- [JavaDoc](http://docs.oracle.com/javase/7/docs/api/java/lang/Package.html#getDoc(java.lang.String,java.lang.String,java.lang.String)
- [JavaDoc](http://docs.oracle.com/javase/7/docs/api/java/lang/Package.html#getDoc(java.lang.String,java.lang.String,java.lang.String)
- [JavaDoc](http://docs.oracle.com/javase/7/docs/api/java/lang/Package.html#getDoc(java.lang.String,java.lang.String,java.lang.String)
- [