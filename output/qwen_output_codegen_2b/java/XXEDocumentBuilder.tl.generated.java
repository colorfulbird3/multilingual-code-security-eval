**: Path sa XML string file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)
// **Output**: Isang `org.w3c.dom.Document` object para sa susunod na pagproseso ng data
// ## Exception Handling
// - Mag-throw ng `Exception` kapag ang XML format ay hindi valid
// - Magsagawa ng naaangkop na exception handling para sa empty o null na mga input
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
//
// Mag-thaw ang xml string sa `result` ini sa `code` ini sa `path` ini sa `content` ini sa `content`. I-parse ang XML content sa `content` at pag-extract. Mag-output ang XML result na `result`
//
// ## Note
// - I-parse ang XML content sa `content` at pag-extract
// - I-output ang XML result na `result`
// - I-throw ng `Exception` kapag ang XML format
// ## Implementation
// - I-parse ang XML content sa `content` at pag-extract
// - I-output ang XML result na `result`
// - I-throw ng `Exception` kapag ang XML format
// - I-throw ng `EmptyNodeException` kapag ang XML format
// - I-throw ng `NullNodeException` kapag ang XML format
// ## Thread Safety
// - Thread safety is guaranteed by `ThreadLocal<java.lang.String>`
//
// @author Minh Thai <minhthai@gmail.com>
// @since 1.0.0
// @version 1.0.0
// @since 1.0.2
// @version 1.0.3
// @since 1.0.4
// @version 1.0.5
// @since 1.0.6
//
public class ConfigService {
    private static final ThreadLocal<String> _xmlString = new ThreadLocal<>();

    public static String loadConfig(String configPath) throws IOException {
        String xml = _xmlString.get();
        if (null == xml) {
            xml = loadXMLContent(configPath);
            _xmlString.set(xml);
        }
        return xml;
    }

    private static String loadXMLContent(String configPath) throws IOException {
        FileInputStream in = new FileInputStream(configPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder strBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine())!= null) {
            strBuilder.append(line).append('\n');
        }
        return strBuilder.toString();
    }
}
