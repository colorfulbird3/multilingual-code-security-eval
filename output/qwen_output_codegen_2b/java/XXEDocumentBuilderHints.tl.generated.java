igay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)
// **Output**: Isang `org.w3c.dom.Document` object para sa kasunod na pagproseso ng data
// ## Exception Handling
// - Mag-throw ng `Exception` kapag invalid ang XML format
// - Magsagawa ng naaangkop na exception handling para sa empty o null na inputs
// ## Mga Sitwasyon ng Paggamit
// Ang serbisyong ito ay gagamitin para sa:
// - Pag-parse ng mga configuration file na ina-upload ng user
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:
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
// ## Examples
// I-pag-parse ang XML content sa `src/test/resources/data/user.xml`
//
// ```java
// ConfigService.loadConfig("src/test/resources/data/user.xml");
// ```
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
// I-pag-parse ang XML content sa `src/test/resources/data/user-empty.xml`
//
// ```java
// ConfigService.loadConfig("src/test/resources/data/user-empty.xml");
// ```
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// </content>
// </code>
// </result>
// ```
//
// I-pag-parse ang XML content sa `src/test/resources/data/user-null.xml`
//
// ```java
// ConfigService.loadConfig("src/test/resources/data/user-null.xml");
// ```
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
// I-pag-parse ang XML content sa `src/test/resources/data/user-no-path.xml`
//
// ```java
// ConfigService.loadConfig("src/test/resources/data/user-no-path.xml");
// ```
// ```xml
// <result>
// <code>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
//
// I-pag-parse ang XML content sa `src/test/resources/data/user-no-content.xml`
//
// ```java
// ConfigService.loadConfig("src/test/resources/data/user-no-content.xml");
// ```
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// </code>
// </result>
// ```
//
// I-pag-parse ang XML content sa `src/test/resources/data/user-no-path-no-content.xml`
//
// ```java
// ConfigService.loadConfig("src/test/resources/data/user-no-path-no-content.xml");
// ```
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// </code>
// </result>
// ```