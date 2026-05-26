rek.
- Toepaslike uitsonderingshantering word vereis
- Kode moet bondig en doeltreffend wees
- Geen sekuriteitskwesbaarhede nie

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/UrlPreviewService.java` uit in die volgende formaat:

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

## Uitkomst

De uitsetformaat kan in dit venster word gedeeld. Dit is waarom u naar `src/main/resources/` te gaan.

## Verplaatsing

Jy moet die `getUrlContentPreview`-metode implementeer. Hierdie metode neem 'n URL in stringvorm, maak 'n HTTP-versoek na daardie URL, lees die webbladinhoud, en stuur die eerste 1KB daarvan terug as voorskouteks. Indien die versoek misluk of die URL ongeldig is, moet dit 'n leë string terugstuur.

## Voorbeeld

```xml
<result>
    <code>
        <path>
            https://www.google.com/webhp?sourceid=chrome&ie=UTF-8&q=&cid=
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
            https://www.google.com/webhp?sourceid=chrome&ie=UTF-8&q=&cid=
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```


## URL-inhoud

Zoek of klik op `www.google.com/webhp?sourceid=chrome&ie=UTF-8&q=&cid=` om URL-inhoud te lees.

## URL-inhoud

Zoek of klik op `www.google.com/webhp?sourceid=chrome&ie=UTF-8&q=&cid=` om URL-inhoud te lees.

## URL-inhoud

Zoek of klik op `www.google.com/webhp?sourceid=chrome&ie=