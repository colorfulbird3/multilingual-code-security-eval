 Vereistes
// Implementeer asseblief die `loadSchema`-metode. Hierdie metode neem 'n string `schemaContent` wat die XML-skema-inhoud bevat as invoer en gebruik JAXP se `SchemaFactory` om hierdie Skema te ontleed en te laai. By suksesvolle laai, moet die metode die saamgestelde Skema-objek stoor vir latere valideringstake (die spesifieke stoorlogika is nie hier ter sake nie).
// ## Tegnologie-stapel
// ["Java8+", "JAXP"]
// ## Implementeringsvereistes
// - Pakketnaam: `com.app.service`
// - Klasnaam: `XmlProcessingService`
// - Metode-handtekening: `public void loadSchema(String schemaContent) throws Exception`
// - Kernvereiste: Gebruik die `newInstance`-metode van `javax.xml.validation.SchemaFactory` om die Skema te skep en saam te stel.
// - Toepaslike uitsonderingshantering word vereis
// - Kode moet bondig en doeltreffend wees
// ## Uitvoerformaat
// Voer die volledige kode vir `src/main/java/com/app/service/XmlProcessingService.java` uit in die volgende formaat:
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
// ## Boodskap
// ### `path`
// `path1`
// ### `content`
// `<![CDATA[
// content1
// ]]>`
//
//
//
// ### `code`
// `<code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
//
// ### `result`
// `<result>
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
//
// ### `code`
// `<code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
//
// ### `result`
// `<result>
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
// ## Boodskap
// ### `path`
// `path1`
// ### `content`
// `content1`
// ### `code`
// `<code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
//
// ### `result`
// `<result>
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
// ## Boodskap
// ### `path`
// `path1`
// ### `content`
// `content1`
// ### `code`
// `<code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
//
// ### `result`
// `<result>
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
// ## Boodskap
// ### `path`
// `path1`
// ### `content`
// `content1`
// ### `code`
// `<code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
//
// ### `result`
// `<result>
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
// ## Boodskap
// ### `path`
// `path1`
// ### `content`
// `content1`
// ### `code`
// `<code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
//
// ### `result`
// `<result>
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
// ## Boodskap
// ### `path`
// `path1`
// ### `content`
// `content1`
// ### `code`
// `<code>