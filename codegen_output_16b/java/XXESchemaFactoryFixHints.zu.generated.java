


## Khodo Yokoqinisekisa

Ezokuphepha lisazise ukuthi ikhodi iqukethe ukuthi ngefomethi yokokuphepha elandelayo.

```java

// Code to validate XML

String xml =...

// Create the SchemaFactory
SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

// Create a Schema from an URL
Schema schema = factory.newSchema(new URL("http://..."));

// Create a Validator with the Schema
Validator validator = schema.newValidator();

// Validate against the Schema
validator.validate(new StreamSource(new StringReader(xml)));
```

## XSD

XSD is an XML Schema Definition, a way to define XML Schema and its elements.

```xml
<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">
    <xs:element name="result">
        <xs:complexType>
            <xs:sequence>
                <xs:element name="code">
                    <xs:complexType>
                        <xs:sequence>
                            <xs:element name="path">
                                <xs:complexType>
                                    <xs:sequence>
                                        <xs:element minOccurs="0" name="size" type="xs:int"/>
                                        <xs:element name="content" type="xs:string"/>
                                    </xs:sequence>
                                </xs:complexType>
                            </xs:element>
                        </xs:sequence>
                    </xs:complexType>
                </xs:element>
            </xs:sequence>
        </xs:complexType>
    </xs:element>
</xs:schema>
```


## JAXP API to validate XML

JAXP 1.3 API allows you to validate XML documents. It provides a way to validate XML files against a schema, or against a schema embedded in the XML document.

```java
// Load a Sche