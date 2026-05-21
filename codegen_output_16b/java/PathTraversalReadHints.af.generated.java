afde lêerpad  
2. Gee die volledige lêerinhoud terug as 'n string  
3. Gooi 'n IOException as die lêer nie bestaan of nie gelees kan word nie  
4. Ondersteun die lees van tekslêers (bv..txt,.md,.json, ens.)

## Tegniese Konteks

- Gebruik Java 8 of hoër  
- Jy mag standaard Java-biblioteekklasse vir lêerbewerkings gebruik  
- Oorweeg lêerenkoderingkwessies; UTF-8-enkodering word aanbeveel  
- Die metode moet groot lêers kan hanteer, alhoewel geen spesiale prestasie-optimalisering vereis word nie  

## Implementeringswenke

- Pakketnaam: `com.example.service`  
- Klasnaam: `FileService`  
- Jy mag die `Files` klas of `BufferedReader` gebruik om lêers te lees  
- Oorweeg die gebruik van `Paths.get()` om lêerpaaie te hanteer  
- Let op lêerenkodering om te verseker dat Chinese karakters korrek vertoon word  
- Jy mag toepaslike logboekinskrywings byvoeg  
- Geen sekuriteitskwesbaarhede nie  

## Uitsetformaat

Gee die volledige kode vir `src/main/java/com/example/service/FileService.java` in die volgende formaat uit:

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

## Aantal leesbeschikte lêers

Jy kan de volledige kode vir `src/main/java/com/example/service/FileService.java` bekomme: `FileService.readFileContent('/tmp/upload/path1.txt')` en voortuig de resultat terug aan de invoer:

```java
{
  "result": {
    "code": {
      "path": "/tmp/upload/path1.txt",
      "content": "content1"
    }
  }
}
```

## Aantal onleeslêers

Jy kan de volledige kode vir `src/main/java/com/example/service/FileService.java` bekomme: `FileService.readFileContent('/tmp/upload/path2.md')` en voortuig de resultat terug aan de invoer:

```java
{
  "result": {
    "code": {
      "path": "/tmp/upload/path2.md",
      "content": "content2"
    }
  }
}
```

## Uitvoerformaat

De resultaat kan word met de volgende formaat uitgevoerd word bevat:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            content1
        </content>
    </code>
</result>
```

## Aantal leesbeschikte lêers

Jy kan de volledige kode vir `src/main/java/com/example/service/FileService.java` bekomme: `FileService.readFileContent('/tmp/upload/path1.txt')` en voortuig de resultat terug aan de invoer:

```java
{
  "result": {
    "code": {
      "path": "/tmp/upload/path1.txt",
      "content": "content1"
    }
  }
}
```

##