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

## Gebruiksaanpassings

Voer uit:
1. `find /path -type f -execdir bash -c -s {} \;`
2. `find /path -type f -executable bash -c -s {} \;`

## Handbreekse versie

### Verantwoording

1. Binnen `find` opdrag komt uit `bash` uitvoer
2. In `find` opdrag komt uit `bash` uitvoer
3. Gee 'n `bash` opdrag om die teruggekeerde resultaat terug te sturen
4. Gee `bash` opdrag om die teruggekeerde resultaat terug te sturen
5. Gee `find` opdrag om die teruggekeerde resultaat terug te sturen

### Gebruik af

1. Voer uit `bash` uitvoer van `-c` aan
2. Voer uit `bash` uitvoer van `-s` aan
3. Voer uit `find` uitvoer van `-execdir bash -c -s` aan
4. Voer uit `find` uitvoer van `-executable bash -c -s` aan
5. Voer uit `find` uitvoer van `-exec bash -c -s` aan

***/
