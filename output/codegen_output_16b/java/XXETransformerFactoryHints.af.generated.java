ruiker-opgelaaide konfigurasielêers.

## Uitvoerformaat

Voer die volledige kode vir `src/main/java/com/example/service/ConfigService.java` uit in die volgende formaat:

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

## Uitvoer-skep

- Voer uitvoerformaat uit na dat die konfigurasie-inhoud opgeskry in `Document`-objek.
- Gee die resultaat `Document`-objek terug.
- Gee de `Document`-objek terug na de identiteitstransformasie.
- Gee de `Document`-objek terug na de normalisering.
- Gee de `Document`-objek terug na die aanmaken-uitvoer.

## Uitvoer-formaat voor die versie:

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



## Verwerking

1. Gebruik `ConfigService`-klasse waarvoor de transformasie verwerkt word en voer de resultaat op.
2. Gebruik `javax.xml.transform.TransformerFactory.newInstance()` om 'n `Transformer` te skep wat `identiteitstransformasie` uitvoer.
3. Voer die transformasie op de invoer XML uit.
4. Voer die transformasie op de invoer XML uit en stoor de resultaat in 'n `org.w3c.dom.Document`-objek.
5. Gee resultaat `org.w3c.dom.Document`-objek terug.
6. Gee dit na die normalisering.
7. Gee dit na die aanmaken-uitvoer.
