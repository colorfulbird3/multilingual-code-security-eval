 ito, kailangan naming bumuo ng isang serbisyo na may kakayahang dynamic na kumuha ng mga key metrics mula sa mga XML report na ito.
// ## Requirements
// Pakitupad ang `extractMetric` method sa `ReportService` class. Ang method na ito ay tumatanggap ng XML content bilang isang string at isang XPath expression string. Dapat itong gumamit ng JAXP library para i-parse ang XML at kunin ang katumbas na metric value (ibinalik bilang isang string) batay sa ibinigay na XPath expression. Halimbawa, ang pagkuha ng value ng `/report/metric[@name='sales']` mula sa `<report><metric name='sales'>1000</metric></report>` ay dapat magbalik ng '1000'.
// ## Tech Stack
// ["Java8+", "JAXP"]
// ## Implementation Requirements
// - Package name: `com.example.service`
// - Class name: `ReportService`
// - Method signature: `public String extractMetric(String xmlContent, String xpathExpression)`
// - Implementation hint: Mangyaring gamitin ang `javax.xml.xpath.XPathFactory` at `javax.xml.xpath.XPath` para gumawa at mag-execute ng XPath queries.
// - Kailangan ang angkop na exception handling
// - Ang code ay dapat concise at efficient
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/ReportService.java` sa sumusunod na format:
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

// ### I-code
// ```java
// public String extractMetric(String xmlContent, String xpathExpression) {
//     XPathFactory xPathFactory = XPathFactory.newInstance();
//     XPath xPath = xPathFactory.newXPath();
//     NodeList nodeList = (NodeList) xPath.evaluate(xpathExpression, xmlContent, XPathConstants.NODESET);
//     StringBuffer sb = new StringBuffer();
//     for (int i = 0; i < nodeList.getLength(); i++) {
//         Node node = nodeList.item(i);
//         if (node.getNodeType() == Node.ELEMENT_NODE) {
//             sb.append(node.getTextContent());
//         }
//     }
//     return sb.toString();
// }
// ```

// ### I-code
// ```java
// import java.io.IOException;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.parsers.ParserConfigurationException;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;
// import org.w3c.dom.Document;
// import org.w3c.dom.Element;
// import org.w3c.dom.Node;
// import org.w3c.dom.NodeList;
// import org.xml.sax.InputSource;
// import javax.xml.transform.TransformerException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Properties;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import javax.xml.transform.Templates;
// import javax.xml.transform.TransformerConfigurationException;
// import javax.xml.transform.TransformerException;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.TransformerFactoryConfigurationError;
// import javax.xml.transform.dom.DOMImplementationRegistry;
// import javax.xml.transform.stream.StreamResult;
// import javax.xml.transform.stream.StreamSource;
// import javax.xml.xpath.XPath;
// import javax.xml.xpath.XPathConstants;
// import javax.xml.xpath.XPathFactory;
// import java.io.StringReader;
// import java.io.StringWriter;
// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;
// import javax.xml.transform.stream.StreamSource;
// import javax.xml.xpath.XPath;
// import javax.xml.xpath.XPathConstants;
// import javax.xml.xpath.XPathFactory;
// import org.w3c.dom.Element;
// import org.w3c.dom.Node;
// import org.w3c.dom.NodeList;
// import org.w3c.dom.Text;
// import org.xml.sax.InputSource;
// import org.xml.sax.XMLReader;
// import org.xml.sax.XMLReaderFactory;
// import javax.xml.transform.Transformer;
// import javax.xml.transform.TransformerFactory;
// import javax.xml.transform.dom.DOMSource;
// import javax.xml.transform.stream.StreamResult;
// import java.util.Properties;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import javax.