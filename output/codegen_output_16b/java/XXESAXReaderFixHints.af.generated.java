

## Uitsetformaat 2

Lewer die volledige reggestelde kode vir `src/main/java/com/example/service/ConfigService.java` in die volgende formaat:

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
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## Verwerkingsprocedures

### Uitvoer

1. Lê `org.w3c.dom.Document`-objek van lêerinhoud en lêe die `org.w3c.dom.Element`-elementen terug. 
2. Verwerf de grondslag en de verwerking van de ontledingsresultaat. 

### Ontvangen

1. Lê `org.w3c.dom.Document`-objek van de XML-ondering die wordt uitgevoerd. 
2. Lê `org.w3c.dom.NodeList`-elementen van de 'n `org.w3c.dom.Node`-element met naam `code` die die bepaalde `org.w3c.dom.Element`-elementen bevat. 
3. Voer de `org.w3c.dom.NodeList`-elementen in een `java.util.List`-object. 
4. Voer de `java.util.List`-object dat met de `org.w3c.dom.NodeList`-elementen in en de `org.w3c.dom.Document`-object dat die die in de vorige stap gebruikt is uit. 
5. Voer de `org.w3c.dom.Document`-object terug. 

## Voorbeeld

In de vor