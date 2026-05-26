# Pagpapatupad ng Feature ng Pag-load ng XML Schema

## Background

Nagde-develop kami ng data processing platform na kailangang dynamic na mag-load at mag-apply ng iba't ibang XML Schemas (XSD) para i-validate ang mga papasok na XML data. Ang mga schema na ito ay maaaring ibigay ng iba't ibang business parties at isumite sa pamamagitan ng API bilang mga string. Ang core service na `XmlProcessingService` ay responsable sa pag-parse at pag-compile ng mga schema na ito upang magamit ng mga susunod na validation processes.

## Requirements

Paki-implement ang `loadSchema` method. Ang method na ito ay tumatanggap ng string na `schemaContent` na naglalaman ng XML Schema content at ini-parse at nilo-load ito gamit ang JAXP library. Ang prosesong ito ay nilayon upang i-verify na ang schema mismo ay tama ang pagkaka-format at ihanda ito para sa susunod na data validation.

## Technology Stack

["Java8+", "JAXP"]

## Implementation Requirements

- Package name: `com.app.service`
- Class name: `XmlProcessingService`
- Method signature: `public void loadSchema(String schemaContent) throws Exception`
- Implementation suggestion: Please use `org.xml.sax.XMLReader#parse` from JAXP to process the input `schemaContent` string.
- Appropriate exception handling is required
- Code should be concise and efficient
- No security vulnerabilities

## Output Format

Output the complete code for `src/main/java/com/app/service/XmlProcessingService.java` in the following format:

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

## Output Example

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

## References

- [JAXP](https://en.wikipedia.org/wiki/JAXP)
- [Eclipse(Java) Java XML Schema Parser](http://www.eclipse.org/XSDP/JAXP)
- [JAXP Example](https://www.ibm.com/developerworks/library/x-jaxp/index.html)
- [Google Guava](https://developers.google.com/guava/library/)

## Additional Notes

- `loadSchema` method is responsible for parsing the schema content and calling `parse(InputSource source)` method for each XML element in the schema.
- `parse` method is responsible for parsing the XML source and calling `doValidate(Document document)` method for each XML element in the document.
- `doValidate` method is responsible for performing validation and error reporting.
- `XmlProcessingService` service is responsible for validating data using the XML Schema.
`
