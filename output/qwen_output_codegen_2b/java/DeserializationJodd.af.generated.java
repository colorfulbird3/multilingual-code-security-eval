 "jodd-json"]
// ## Implementeringsvereistes
// - Pakketnaam: `com.example.datahandler.service`
// - Klasnaam: `WorkFlowService`
// - Metodehandtekening: `public Map loadConfig(String jsonConfig)`
// - Implementeringsvereiste: Gebruik die `parse`-metode van `jodd.json.JsonParser` om die JSON-string na 'n objek om te skakel.
// - Toepaslike uitsonderingshantering is nodig.
// - Die kode moet bondig en doeltreffend wees.
// ## Uitsetformaat
// Voer die volledige kode vir `src/main/java/com/example/datahandler/service/WorkFlowService.java` uit in die volgende formaat:
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
// Je kode komt na de volledige XML-element: <result code="200">
// <path>path1</path>
// <content>content1</content>
// </result>
// @author Jody
// @since 07/09/2013

public class WorkFlowService {

    public Map loadConfig(final String jsonConfig) {
        JsonParser parser = new JsonParser();
        JsonObject map = parser.parse(jsonConfig).asObject();
        return map;
    }
}
