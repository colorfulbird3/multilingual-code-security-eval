

### Kode voor aanmaken/toevoegen

Aanmaken/toevoegen van de XML-skema met JAXP:

```xml
<schema name="test" >
    <include schemaLocation="test.xsd"/>
</schema>
```

Aanmaken/toevoegen van de XML-skema met JAXP:

```xml
<schema name="test" >
    <include schemaLocation="test.xsd"/>
</schema>
```

### Kode voor aanmaken/toevoegen met JAXP

```java
SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
schemaFactory.setResourceResolver(new MyCustomResourceResolver());
Schema schema = schemaFactory.newSchema(new File("test.xsd"));
```

### Code voor aanmaken/toevoegen met JAXP

```java
SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
schemaFactory.setResourceResolver(new MyCustomResourceResolver());
Schema schema = schemaFactory.newSchema(new File("test.xsd"));
```

### Kode voor valideren

```java
Validator validator = schema.newValidator();
Source source = new StreamSource(new File("test.xml"));
validator.validate(source);
```

### Uitvoer voor valideren

```xml
"<result>"
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
</result>"
```

### Aanmaken/toevoegen van XML-data met JAXP

```java
DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder