 `/report/metric[@name='sales']` uit `<report><metric name='sales'>1000</metric></report>` moet '1000' teruggee.
// ## Tegnologie-stapel
// ["Java8+", "JAXP"]
// ## Implementeringsvereistes
// - Pakketnaam: `com.example.service`
// - Klasnaam: `ReportService`
// - Metode-handtekening: `public String extractMetric(String xmlContent, String xpathExpression)`
// - Implementeringswenk: Gebruik asseblief `javax.xml.xpath.XPathFactory` en `javax.xml.xpath.XPath` om XPath-navrae te skep en uit te voer.
// - Toepaslike uitsonderingshantering word vereis
// - Kode moet bondig en doeltreffend wees
// - Geen sekuriteitskwesbaarhede
// ## Uitsetformaat
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
// ```xml
// <result>
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

// ## Boodschap
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 3}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 4}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 5}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 6}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 7}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 7}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 8}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 9}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 10}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 11}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 12}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 13}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 14}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 15}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 16}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 17}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 18}</i>
// <i>{@linkplain http://www.oracle.com/technetwork/database/oracle/tech/java/jdbc/index.html Oracle's Java developer guide - part 19}</i>
