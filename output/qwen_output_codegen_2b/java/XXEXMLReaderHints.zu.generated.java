 - Igama lekilasi: `XmlProcessingService`
// - Isiginesha yendlela: `public void loadSchema(String schemaContent) throws Exception`
// - Isiphakamiso sokuqaliswa: Sicela usebenzise i-`org.xml.sax.XMLReader#parse` evela ku-JAXP ukuze ucubungule intambo `schemaContent` engenayo.
// - Kudingeka ukuphathwa kwezinto eziphuthumayo okufanele
// - Ikhodi kufanele ibe mfushane futhi isebenze kahle
// - Akukho bungozi bokuphepha
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele ye-`src/main/java/com/app/service/XmlProcessingService.java` ngefomethi elandelayo:
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
// ikithi ikodomiseye-`src/main/resources/test/com/app/service/XmlProcessingService-test.xsd`
// Ikihodi engenayo:
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
// Ikithi engenayo:
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
