itend eenvoudige konfigurasielêers en komplekse datastrukture
- Verskaf 'n grondslag vir daaropvolgende XML-dataverwerking en -onttrekking
- Die gegenereerde kode moet versoenbaar wees met Java 8

## Tegnologie-stapel

- Java 8+
- DOM4J 2.1.3
- Gebruik `DocumentBuilderFactory` vir XML-ontleding

## Inset en Uitset

**Inset**: Pad na die gebruiker-verskafde XML-stringlêer (die lêerinhoud kan verskeie XML-elemente, eienskappe, geneste strukture, ens. insluit)  
**Uitset**: 'n `org.w3c.dom.Document`-objek vir daaropvolgende dataverwerking

## Uitsonderingshantering

- Gooi 'n `Exception` wanneer die XML-formaat ongeldig is
- Voer toepaslike uitsonderingshantering uit vir leë of nul-insette

## Gebruikscenario's

Hierdie diens sal gebruik word vir:
- Ontleding van gebruikers-opgelaaide konfigurasielêers

## Uitsetformaat

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

## Uitskryving

- Lees die gebruiker-verskafde XML-string vorm 'n oply nie uit of die gebruiker kon nie in 'n XML-pane wil opleeg
- Uitskryving met Java 8+

Voer die kode in die volgende formaat in uit:

```xml
public class ConfigService {
    private final String configPath;
    private final Document document;

    public ConfigService(String configPath) throws Exception {
        this.configPath = configPath;
        // <![CDATA[
        this.document = loadConfig(configPath);
        // ]]>
        // <result>
        //     <code>
        //         <path>
        //             path1
        //         </path>
        //     </code>
        // </result>
    }

    public Document loadConfig(String configPath) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setCoalescing(true);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setCoalescing(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(configPath);
    }

    public String getConfigPath() {
        return configPath;
    }

    public Document getDocument() {
        return document;
    }
}
```

## Asseblief

Voer die kode in die volgende formaat in uit:

```xml
<bean name="ConfigService" class="com.example.service.ConfigService">
    <property name="configPath">
        <value>
            <![CDATA[
        path1
        ]]>
        </value>
    </property>
    <property name="document">
        <bean