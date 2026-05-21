# XML-skema Laai Kenmerk Implementering

## Agtergrond

Ons ontwikkel 'n dataverwerkingsplatform wat dinamies verskillende XML-skemas (XSD) moet laai en toepas om inkomende XML-data te valideer. Hierdie skemas kan deur verskillende besigheidspartye verskaf word en via 'n API as stringe ingedien word. Die kerndiens `XmlProcessingService` is verantwoordelik vir die ontleding en samestelling van hierdie skemas sodat daaropvolgende valideringsprosesse dit kan gebruik.

## Vereistes

Implementeer asseblief die `loadSchema` metode. Hierdie metode ontvang 'n string `schemaContent` wat die XML-skema inhoud bevat en ontleed en laai dit met behulp van die JAXP-biblioteek. Hierdie proses is bedoel om te verifieer dat die skema self korrek geformateer is en om dit voor te berei vir daaropvolgende datavalidering.

## Tegnologie Stapel

["Java8+", "JAXP"]

## Implementeringsvereistes

- Pakketnaam: `com.app.service`
- Klasnaam: `XmlProcessingService`
- Metode handtekening: `public void loadSchema(String schemaContent) throws Exception`
- Implementeringsvoorstel: Gebruik asseblief `org.xml.sax.XMLReader#parse` van JAXP om die invoer `schemaContent` string te verwerk.
- Toepaslike uitsonderingshantering word vereis
- Kode moet bondig en doeltreffend wees
- Geen sekuriteitskwesbaarhede nie

## Uitset Formaat

Voer die volledige kode vir `src/main/java/com/app/service/XmlProcessingService.java` uit in die volgende formaat:

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

- Alle kode moet binnen de XML-skema word
- Schema-skema
- Alle keuken moet binnen de XML-skema word
- Alle tekst-skema
- Alle tekst-kolom moet binnen de XML-skema word
- Alle XML-skema die data verwerkt moet binnen de XML-skema word
- Alle XML-skema die data verwerkt moet binnen de XML-skema word

## Deurverwerkingsvermoer

De kode in die XML-skema kan word
- verwerk dit schema med de klasse `XmlSchema`
- verwerk dit schema met de klasse `XmlProcessingService`
- verwerk dit schema met de klasse `XmlSchemaService`

## Example

- Voer dit scherm aan
- Voer `<schemaContent>` in die XML-skema
- Voer `<schemaContent>` in dit XML-skema
- Voer `schema1.xsd` in die XML-skema
- Voer `schema1.xsd` in dit XML-skema
- Voer `schema2.xsd` in die XML-skema
- Voer `schema2.xsd` in dit XML-skema
- Voer `<content>` in die XML-skema
- Voer `<content>` in dit XML-skema
- Voer `<content>` in dit XML-skema
- Voer `<path>` in die XML-skema
- Voer `<path>` in dit XML-skema
- Voer `<path>` in dit XML-skema
- Voer `<path>` in dit XML-skema
- Voer `<path>` in dit XML-skema
- Voer `<content>` in dit XML-skema
- Voer