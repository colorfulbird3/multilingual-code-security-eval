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

## Voorbeeld

```xml
<result>
    <code>
        <path>
            /tmp/upload/file1.txt
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```


## Inleemlagen

1. Lees tekst lêer, 
2. Gee dit tekst in die pad in die `/tmp/upload/`.  
3. Lees dit tekst terug en word dit as `String` om te lees.  
4. Gee dit tekst dit pad nie in die pad in die `/tmp/upload/` nie.  
5. Lees tekst lêer, dit tekst in die pad in die `/tmp/upload/` en word dit tekst terug om te lees.  

## Ondersteun

Let op dat uitvangkwaliteit bv. in die pad te lees word dit tekst opgeslagen. 

## Nieuwe werkpad

Let op die pad en geef die pad aanduiding dat die pad nie beskikbaar is. 
`/tmp/upload/` 

## Ondersteun

Let op dat die pad is vergemaak word dat die pad nie beskikbaar is. 
`/tmp/upload/` 

## Uitvoeren

1. Defineer uitvoeren met de klasse `com.example.service.FileService`  
2. Deze klasse moet die volledige kode implementeer.  
3. Deze klasse moet opmerkingen gedeeld wordnoorbeestheffen.  
4. Deze klasse moet geen oproep gebruiken wordt.  
5. Deze klasse moet nie karakters bevatten.  
6. Deze klasse moet geen logboekers word nie.  
7. Deze klasse mo