drukking. Byvoorbeeld, die onttrekking van die waarde van `/report/metric[@name='sales']` uit `<report><metric name='sales'>1000</metric></report>` moet '1000' teruggee.
// ## Tegnologie Stapel
// ["Java8+", "JAXP"]
// ## Implementeringsvereistes
// - Pakketnaam: `com.example.service`
// - Klasnaam: `ReportService`
// - Metode handtekening: `public String extractMetric(String xmlContent, String xpathExpression)`
// - Implementeringswenk: Gebruik asseblief `javax.xml.xpath.XPathFactory` en `javax.xml.xpath.XPath` om XPath-navrae te skep en uit te voer.
// - Toepaslike uitsonderingshantering word vereis
// - Kode moet bondig en doeltreffend wees
// ## Uitset Formaat
// Voer die volledige kode vir `src/main/java/com/example/service/ReportService.java` uit in die volgende formaat:
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
//
// ## Boodschappen
// - Java-verschil
// - JAXP-bibliothek
// - XPath
// - JAXP-bibliothek
// - Java-verschil
// - JAXP-bibliothek
// - Java-verschil
// - JAXP-bibliothek
//
// ## Boodschappen vermerkingen
// - Java-verschil:
// - JAXP-bibliothek kennisneer:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - JAXP-bibliothek kennisneer:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-verschil:
// - Java-