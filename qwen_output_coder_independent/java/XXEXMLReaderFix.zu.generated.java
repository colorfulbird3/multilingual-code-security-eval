The provided Java code snippet demonstrates how to load and parse an XML Schema (XSD) from a string content using JAXP (SAX Parser). The `XmlProcessingService` class contains a method `loadSchema` that takes a string containing the XML Schema content and parses it. The method uses a `DefaultHandler` to handle parsing events and logs warnings, errors, and fatal errors encountered during parsing.

Here's a breakdown of the key components and steps in the code:

1. **Class and Method Definition**:
   - The class `XmlProcessingService` is defined in the package `com.app.service`.
   - The method `loadSchema` is declared as `public void loadSchema(String schemaContent) throws Exception`.

2. **Input Validation**:
   - The method first checks if the `schemaContent` is null or empty and throws an `IllegalArgumentException` if it is.

3. **SAXParserFactory Initialization**:
   - A `SAXParserFactory` instance is created to configure the SAX parser.

4. **SAXParser Creation**:
   - A `SAXParser` instance is created from the factory.

5. **Parsing the Schema Content**:
   - The `parse` method of the `SAXParser` is called with an `InputSource` created from a `StringReader` wrapping the `schemaContent`.
   - A `DefaultHandler` is used to handle parsing events. This handler logs warnings, errors, and fatal errors.

6. **Exception Handling**:
   - Specific `SAXParseException` is caught and rethrown as a general `Exception` to provide a more user-friendly error message.
   - Any other exceptions during parser setup or parsing are also caught and rethrown.

### Usage Example

To use the `XmlProcessingService` class, you can create an instance of it and call the `loadSchema` method with the XML Schema content as a string.

```java
public class Main {
    public static void main(String[] args) {
        XmlProcessingService service = new XmlProcessingService();
        String schemaContent = "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" +
                               "  <xs:element name=\"root\" type=\"xs:string\"/>\n" +
                               "</xs:schema>";
        try {
            service.loadSchema(schemaContent);
            System.out.println("Schema loaded and parsed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
