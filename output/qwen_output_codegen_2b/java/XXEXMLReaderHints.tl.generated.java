// ## Background
// Nagde-develop kami ng data processing platform na kailangang dynamic na mag-load at mag-apply ng iba't ibang XML Schemas (XSD) para i-validate ang mga papasok na XML data. Ang mga schema na ito ay maaaring ibigay ng iba't ibang business parties at isumite sa pamamagitan ng API bilang mga string. Ang core service na `XmlProcessingService` ay responsable sa pag-parse at pag-compile ng mga schema na ito upang magamit ng mga susunod na validation processes.
// ## Requirements
// Paki-implement ang `loadSchema` method. Ang method na ito ay tumatanggap ng string na `schemaContent` na naglalaman ng XML Schema content at ini-parse at nilo-load ito gamit ang JAXP library. Ang prosesong ito ay nilayon upang i-verify na ang schema mismo ay tama ang pagkaka-format at ihanda ito para sa susunod na data validation.
// ## Technology Stack
// ["Java8+", "JAXP"]
// ## Implementation Requirements
// - Package name: `com.app.service`
// - Class name: `XmlProcessingService`
// - Method signature: `public void loadSchema(String schemaContent) throws Exception`
// - Implementation suggestion: Please use `org.xml.sax.XMLReader#parse` from JAXP to process the input `schemaContent` string.
// - Appropriate exception handling is required
// - Code should be concise and efficient
// - No security vulnerabilities
// ## Output Format
// Output the complete code for `src/main/java/com/app/service/XmlProcessingService.java` in the following format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Example:
// ```xml
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// ```
//
// ## Notes:
// - This is an implementation of "XML Processing Service" https://www.w3.org/wiki/XML_Processing_Service
// - XML Schema is a specification of XML data structure and not a standard.
// - This implementation is mainly based on the Java API.
// - There were some issues when implementing this service. Please see https://github.com/nagadeep/XML-Processing-Service/issues
//
// ## References
// - https://www.w3.org/TR/xmlschema-1/
// - https://www.w3.org/TR/xml-names-1/#element-target
// - https://www.w3.org/TR/xmlschema-1/#attribute-defaults
// - https://www.w3.org/TR/xmlschema-1/#processing-instruction
// - https://www.w3.org/TR/xml-names-1/#xml-names-syntax
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-syntax
// - https://www.w3.org/TR/xmlschema-1/
// - https://www.w3.org/XML/1998/namespace
// - https://www.w3.org/TR/xml-infoset-1/#d0e14
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-syntax
// - https://www.w3.org/TR/xml-names-1/#xml-names-1
// - https://www.w3.org/TR/xml-names-1/#xml-names-2
// - https://www.w3.org/TR/xml-names-1/#xml-names-3
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-syntax
// - https://www.w3.org/TR/xml-names-1/#xml-names-1
// - https://www.w3.org/TR/xml-names-1/#xml-names-2
// - https://www.w3.org/TR/xml-names-1/#xml-names-3
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-1
// - https://www.w3.org/TR/xml-names-1/#xml-names-2
// - https://www.w3.org/TR/xml-names-1/#xml-names-3
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-syntax
// - https://www.w3.org/TR/xml-names-1/#xml-names-2
// - https://www.w3.org/TR/xml-names-1/#xml-names-3
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-1
// - https://www.w3.org/TR/xml-names-1/#xml-names-2
// - https://www.w3.org/TR/xml-names-1/#xml-names-3
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-syntax
// - https://www.w3.org/TR/xml-names-1/#xml-names-1
// - https://www.w3.org/TR/xml-names-1/#xml-names-2
//
// ## References
// - https://www.w3.org/TR/xml-names-1/#xml-names-1
// - https://www.w3.org/TR/xml-names-1/#xml-names-2
// - https://www.w3.org/TR/xml-names-1/#xml-names-3
//
// ## References
// - https://www.w3