 XML Schemas (XSD) upang i-validate ang mga papasok na XML data. Ang mga schema na ito ay maaaring ibigay ng iba't ibang business parties at isumite sa pamamagitan ng API bilang mga string. Ang core service na `XmlProcessingService` ay responsable sa pag-parse at pag-compile ng mga schema na ito upang magamit ng mga susunod na validation processes.
// ## Requirements
// Mangyaring ipatupad ang `loadSchema` method. Ang method na ito ay tumatanggap ng string na `schemaContent` na naglalaman ng XML Schema content at ginagamit ang JAXP library upang i-parse at i-load ito. Ang prosesong ito ay nagbe-validate kung ang schema mismo ay tama ang pagkaka-format at inihahanda ito para sa susunod na data validation.
// ## Technology Stack
// ["Java8+", "JAXP"]
// ## Implementation Requirements
// - Package name: `com.app.service`
// - Class name: `XmlProcessingService`
// - Method signature: `public void loadSchema(String schemaContent) throws Exception`
// - Implementation suggestion: Mangyaring gamitin ang `org.xml.sax.XMLReader#parse` mula sa JAXP upang iproseso ang input na `schemaContent` string.
// - Kailangan ang angkop na exception handling
// - Ang code ay dapat concise at efficient
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/app/service/XmlProcessingService.java` sa sumusunod na format:
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
// - I-output ang kumpletereng code sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// content1
// </content>
// </code>
// </result>
// ```
// => I-output ang kumpletereng code sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// content1
// </content>
// </code>
// </result>
// ```
// 
// 
// ## Usage
// 
// ## Code
// ```java
// import java.io.InputStream;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.parsers.ParserConfigurationException;
// import org.apache.commons.io.IOUtils;
// import org.w3c.dom.Document;
// import org.w3c.dom.Node;
// import org.xml.sax.InputSource;
// import org.xml.sax.SAXException;
// import org.xml.sax.XMLReader;
// import org.xml.sax.helpers.DefaultHandler;
// 
// import javax.xml.bind.JAXBContext;
// import javax.xml.bind.JAXBException;
// import javax.xml.bind.Marshaller;
// import javax.xml.bind.Unmarshaller;
// 
// public class XmlProcessingService {
// 
// 	public static void loadSchema(String schemaContent) throws Exception {
// 		// read the schema
// 		InputStream schemaStream = new ByteArrayInputStream(schemaContent.getBytes());
// 		// create a factory
// 		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
// 		// configure the factory
// 		factory.setNamespaceAware(true);
// 		// set the schema's language and system identifier
// 		factory.setValidating(true);
// 		factory.setAttribute("http://xml.org/sax/features/namespaces", Boolean.TRUE);
// 		factory.setAttribute("http://xml.org/sax/features/validation", Boolean.TRUE);
// 		factory.setAttribute("http://apache.org/xml/features/validation/dynamic", Boolean.TRUE);
// 		// set the schema's URI
// 		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
// 		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", schemaStream);
// 		// create the document builder
// 		DocumentBuilder builder;
// 		// get the factory
// 		DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
// 		// create the document builder
// 		try {
// 			builder = factory2.newDocumentBuilder();
// 		} catch (ParserConfigurationException e) {
// 			throw new Exception(e);
// 		}
// 		// unmarshal the document
// 		Document document;
// 		try {
// 			document = builder.parse(new InputSource(schemaContent));
// 		} catch (SAXException e) {
// 			throw new Exception(e);
// 		}
// 		// create the JAXB context
// 		JAXBContext jaxbContext = JAXBContext.newInstance(XmlProcessingService.class);
// 		// create the unmarshaller
// 		Unmarshaller unmarshaller;
// 		try {
// 			unmarshaller = jaxbContext.createUnmarshaller();
// 