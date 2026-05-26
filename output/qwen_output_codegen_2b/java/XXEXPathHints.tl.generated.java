 na kumuha ng mga pangunahing sukatan mula sa mga XML report na ito.
// ## Requirements
// Paki-implement ang `extractMetric` method sa `ReportService` class. Ang method na ito ay tumatanggap ng XML content bilang string at isang XPath expression string. Dapat itong gumamit ng JAXP library para i-parse ang XML at kunin ang kaukulang metric value (ibinalik bilang string) batay sa ibinigay na XPath expression. Halimbawa, ang pagkuha ng value ng `/report/metric[@name='sales']` mula sa `<report><metric name='sales'>1000</metric></report>` ay dapat magbalik ng '1000'.
// ## Tech Stack
// ["Java8+", "JAXP"]
// ## Implementation Requirements
// - Package name: `com.example.service`
// - Class name: `ReportService`
// - Method signature: `public String extractMetric(String xmlContent, String xpathExpression)`
// - Implementation hint: Mangyaring gamitin ang `javax.xml.xpath.XPathFactory` at `javax.xml.xpath.XPath` para gumawa at mag-execute ng XPath queries.
// - Kinakailangan ang angkop na exception handling
// - Ang code ay dapat concise at efficient
// - Walang security vulnerabilities
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
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// </result>
// ```
// ## Dependencies
// - `javax.xml.xpath.XPathFactory` at `javax.xml.xpath.XPath`
// - `javax.xml.xpath.XPath`
// - `com.sun.org.apache.xerces.internal.parsers.DOMParser`
// - `javax.xml.transform.TransformerFactory`
// - `javax.xml.transform.Transformer`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.Transformer`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.TransformerHandler`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.TransformerHandlerFactory`
// - `javax.xml.transform.dom.DOMResult`
// - `javax.xml.transform.dom.DOMSource`
// - `javax.xml.transform.stream.StreamResult`
// - `javax.xml.transform.stream.StreamSource`
// - `org.w3c.dom.Document`
// - `javax.xml.parsers.DocumentBuilderFactory`
// - `javax.xml.parsers.DocumentBuilder`
// - `javax.xml.parsers.DocumentBuilderFactory.newInstance()`
// - `org.w3c.dom.Element`
// - `javax.xml.parsers.DocumentBuilderFactory.newInstance()`
// - `org.w3c.dom.DocumentBuilderFactory`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.NodeList`
// - `org.w3c.dom.Text`
// - `org.w3c.dom.Document`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Attr`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Node`
// - `org.w3c.dom.NodeList`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Text`
// - `org.w3c.dom.Document`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Attr`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Node`
// - `org.w3c.dom.NodeList`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Attr`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Node`
// - `org.w3c.dom.NodeList`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Attr`
// - `org.w3c.dom.Element`
// - `org.w3c.dom.Node`
// - `org.w3c.dom.NodeList`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.Templates`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactory`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.Transformer`
// - `com.sun.org.apache.xalan.internal.xsltc.trax.TransformerHandler