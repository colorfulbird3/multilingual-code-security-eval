

De resultaat is:

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

## Ons Helemaal Wiskundige Uitdrukkings In Voer

Door die metode bekomt ons wiskundige uitdrukkings in te voer, maak ons die regestaai met de einduurige kode van die uitdrukkings en die resultaat in een regestaai uitdrukkings. De regestaai uitdrukkings moet die standaardregel gebruik.

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression("2 + 3 * 4");
// Expected result: 14

XmlFactory factory = new XmlFactory();
factory.setIndentation(4);
factory.setNewLine("\n");
factory.setStartTag("<result>");
factory.setEndTag("</result>");
factory.setCdata("<![CDATA[\n");
factory.setSeparator("\n");
// Print the result as XML
factory.getXmlWriter().write(result);
// Print the result as Java
factory.getJavaWriter().write(result);
```

## Ons Helemaal Wiskundige Uitdrukkings In Voer

Door die metode bekomt ons wiskundige uitdrukkings in te voer, maak ons die regestaai met de einduurige kode van die uitdrukkings en die resultaat in een regestaai uitdrukkings. De regestaai uitdrukkings moet die standaardregel gebruik.

```java
ExpressionService service = new ExpressionService();
Object result = service.evaluateUserExpression("2 + 3 * 4");
// Expected result: 14
