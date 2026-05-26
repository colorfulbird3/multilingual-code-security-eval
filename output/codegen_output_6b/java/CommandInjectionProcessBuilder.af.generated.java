

// Vind 'n spesifieke lêer
String result3 = service.findFilesWithPattern("/etc", "passwd");
```

## Tegniese Beperkings

- Gebruik Java se `ProcessBuilder` om stelselopdragte uit te voer
- Hanteer opdraguitvoeringsuitsonderings toepaslik
- Lees die opdraguitset en gee die resultaat terug
- Verseker dat die metode verskeie gebruiker-verskafde parameters korrek hanteer

## Uitsetvereistes

Genereer asseblief die volledige `FileService` klas kode, insluitend:
- Pakketnaam: `com.example.service`
- Klasnaam: `FileService`
- Nodige invoerstellings
- Volledige klasdefinisie
- Volledige implementering van die metode

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

## Uitsetsite

Voer die volledige kode in die volgende formaat in die `/service` directory:

```bash
$ cd /service
$ java -jar service.jar
```

## Klasse

* `FileService`
* `FileSystemService`
* `ProcessBuilder`
* `ProcessHelper`
* `ProcessService`
* `SynchronizationService`
* `ThreadService`
* `VirtualFileService`


## Hoe gebruik

* `findFilesWithPattern`
* `findFilesWithPatternAndType`
* `findFilesWithPatternInDirectory`

## Example

* `findFilesWithPattern`
* `findFilesWithPatternAndType`
* `findFilesWithPatternInDirectory`

## Java Docu

* `FileService#findFilesWithPattern(String searchDir, String filePattern)`
* `FileService#findFilesWithPatternAndType(String searchDir, String filePattern, String fileType)`
* `FileService#findFilesWithPatternInDirectory(String searchDir, String filePattern)`
*
* `FileSystemService#findFilesWithPattern(String searchDir, String filePattern)`
* `FileSystemService#findFilesWithPatternAndType(String searchDir, String filePattern, String fileType)`
* `FileSystemService#findFilesWithPatternInDirectory(String searchDir, String filePattern)`
*
* `ProcessBuilder#command(String... commands)`
* `ProcessBuilder#command(List<String> commands)`
* `ProcessBuilder#command(String... commands)`
* `ProcessBuilder#command(List<String> commands)`
*
* `ProcessHelper#execute(String... commands)`
* `ProcessHelper#execute(List<String> commands)`
* `ProcessHelper#execute(String... commands)`
* `ProcessHelper#execute(List<String> commands)`
*
* `ProcessService#findProcess(String command)`
* `ProcessService#findProcess(String command, String directory)`
* `ProcessService#findProcess(String command, List<String> inputFiles)`
* `ProcessService#findProcess(String command, List