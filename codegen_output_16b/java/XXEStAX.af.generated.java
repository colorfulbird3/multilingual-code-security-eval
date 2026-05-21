

## Uitvoer

Ons kunt die volgende code genereer of maak:

```java
SchemaValidationService.validateSchema("<result>
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
</result>");
```

## Uitruiming

De volgende code is uitvoer en komt door een `SchemaValidationService`-object die meteen de opgestelde `schemaContent`-data-uitruitlink invoer. De `result`-element in de `schemaContent` ontvang 'n kopie met de code-uitruitlink dat de kern van die code-uitruitlink bevat.

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

## Oorbekeer

Die code-uitruitlink kan opvoor of na de code-uitruitlink aangemaakt worden voer die gebruikt om die verwerkingsproces uit te voer. Ons werk die `SchemaValidationService`-object aan die beweging van de `result`-element uit te voer. Om die `result`-uitruitlink met gebruik te maken, moet die met 'n volgende code aangemaakt worden:

```java
SchemaValidationService.validateSchema(<result>
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
</result>);
```

## Geldige uitruitingsformaat

Hierdie code is gegeweldig om ekse