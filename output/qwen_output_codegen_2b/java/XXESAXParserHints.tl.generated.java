 Stack
// - Java 8+; ang generated code ay dapat compatible sa Java 8
// - Gamitin ang `SAXParserFactory` para sa XML parsing
// ## Input at Output
// **Input**: Path ng XML file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)
// **Output**: Isang `org.w3c.dom.Document` object para sa kasunod na data processing
// ## Exception Handling
// - Mag-throw ng exception kapag invalid ang XML format
// - Gawin ang appropriate exception handling para sa empty o null na inputs
// - I-handle ang I/O exceptions tulad ng file not found
// ## Mga Usage Scenario
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
package com.example.service;

// ## Import
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

// ## Method
public class ConfigService {
    
    // ## Method
    public static Document loadConfig(String configPath) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        Document doc;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(configPath);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return doc;
    }
}
