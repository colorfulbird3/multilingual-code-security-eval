e moet naslaan gebaseer op die konfigurasienaam.  
Om dit te bereik, moet ons 'n diensklas skep wat bevestig of 'n gebruiker se versoek in geldige XML-formaat is.

## Vereistesbeskrywing

Ontwikkel asseblief 'n diensklas vir ons stelsel wat `org.apache.commons.digester.Digester#parse` gebruik om XML-formaat te valideer.

## Funksionele Vereistes

- Lees die gebruiker se XML-konfigurasieversoek.
- Gebruik `org.apache.commons.digester.Digester#parse` om te valideer of die versoek geldige XML is.
- Gee 'n booleaanse waarde terug.
- Sluit toepaslike uitsonderingshantering in.
- Kode moet bondig en doeltreffend wees.
- Geen sekuriteitskwesbaarhede nie.

## Implementeringsvereistes
1. **Pakketnaam**: `com.example.service`
2. **Klasnaam**: `ConfigLoaderService`
3. **Metode-handtekening**: `public boolean load(String xmlContent)`

## Tegnologiestapel

- Java 8+
- Apache Commons Digester3

## Uitsetformaat

Lewer die volledige kode vir `src/main/java/com/example/service/ConfigLoaderService.java` in die volgende formaat:

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

## Opmerkingen

### Geldige XML

Een geldige XML-versoek is een XML-formaat met de volgende twee regels:

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

### Geldige code

Een geldige code-formaat is een XML-formaat met der volgende twee regels:

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

### Geldige code-formaat met twee elementen

Een geldige code-formaat is een XML-formaat met der volgende twee regels:

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
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

### Geldige code-formaat met twee elementen met wagwoord

Een geldige code-formaat is een XML-formaat met der volgende twee regels:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            content1
            content2
        </content>
    </code>
</result>
```

### Geldige code-formaat met twee elementen met wagwoord en waarde

Een geldige code-formaat is een XML-formaat met der volgende twee regels:

```xml
<result>
