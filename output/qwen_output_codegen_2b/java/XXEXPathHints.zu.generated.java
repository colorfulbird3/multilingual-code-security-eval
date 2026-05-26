 yendlela: `public String extractMetric(String xmlContent, String xpathExpression)`
// - Umkhombandlela wokusebenza: Sicela usebenzise `javax.xml.xpath.XPathFactory` kanye `javax.xml.xpath.XPath` ukudala nokwenza imibuzo ye-XPath.
// - Kudingeka ukuphathwa kwezimo ezingavamile okufanele
// - Ikhodi kufanele ibe mfushane futhi isebenze kahle
// - Akukho ubungozi bokuphepha
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele ye `src/main/java/com/example/service/ReportService.java` ngefomethi elandelayo:
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
// Kuchadhelele ukuhlaziya wokusebenza ukuqukahatwe:
// ```xml
// <result>
// <code>
// <path>
// path3
// </path>
// <content>
// <![CDATA[
// content3
// ]]>
// </content>
// </code>
// </result>
// ```
//
// ## Ikidiyo Komakha
// Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha, kahalakho. Komakha,