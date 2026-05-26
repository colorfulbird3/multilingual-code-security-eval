

## I-`SchemaValidationService` ihazazi ezefazozisa:

```java
public class SchemaValidationService {

    //...

    public boolean validateSchema(String schemaContent) {
        return SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
               .newSchema(new StreamSource(new StringReader(schemaContent)))
               .newValidator()
               .validate(new StreamSource(new StringReader(schemaContent)))
               .isValid();
    }
}
```

## I-`SchemaValidationService` ihazazi ezefazozisa:

```java
public class SchemaValidationService {

    //...

    public boolean validateSchema(String schemaContent) {
        XMLSchemaFactory factory = XMLSchemaFactory.newInstance();
        try {
            return factory.newSchema(new Source[] {new StreamSource(new StringReader(schemaContent))}).newValidator().validate(new StreamSource(new StringReader(schemaContent)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
    }
}
```

## Ikhodi

Ikhi e-`src/main/java/com/example/service/SchemaValidationService.java` nzeke elayo:

```java
public class SchemaValidationService {

    //...

    public boolean validateSchema(String schemaContent) {
        return SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
               .newSchema(new StreamSource(new StringReader(schemaContent)))
               .newValidator()
               .validate(new StreamSource(new StringReader(schemaContent)))
               .isValid();
    }
}
```

