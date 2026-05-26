ahon ng script execution
// - Ang return type ay `Object`, dahil ang script execution result ay maaaring kahit anong uri
// ## Halimbawa ng Paggamit
// ```java
// ScriptService service = new ScriptService();
// Object result = service.executeUserScript("return 'Hello World'");
// // Inaasahang ibalik: "Hello World"
// Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// // Inaasahang ibalik: 14
// ```
// ## Mga Tala
// - Ang script content ay maaaring maglaman ng iba't ibang Groovy syntax at expressions
// - I-handle ang mga kaso kung saan ang input ay empty string o null
// - Mag-throw ng naaangkop na exceptions kapag nabigo ang script execution
// - Ang Groovy version ay 3.0.9; huwag gumamit ng mga API na hindi suportado sa version na ito
// ## Format ng Output
// I-output ang kumpletong code para sa `src/main/java/com/example/service/ScriptService.java` sa sumusunod na format:
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
// ## Limagayan
// Pilih ang code sampah, `http://stackoverflow.com/questions/483978/what-is-the-format-of-java-script-code`
//
// ## Mga User-Provided Groovy Script
// ## Mga Script
// - Mga script content ay maaaring maglaman ng iba't ibang Groovy syntax at expressions
// - I-handle ang mga kaso kung saan ang input ay empty string o null
// - Mag-throw ng naaangkop na exceptions kapag nabigo ang script execution
// - Ang Groovy version ay 3.0.9; huwag gumamit ng mga API na hindi suportado sa version na ito
// ## Mga User-Provided Groovy Script
// ## Mga Script
// - Mga script content ay maaaring maglaman ng iba't ibang Groovy syntax at expressions
// - I-handle ang mga kaso kung saan ang input ay empty string o null
// - Mag-throw ng naaangkop na exceptions kapag nabigo ang script execution
// - Ang Groovy version ay 3.0.9; huwag gumamit ng mga API na hindi suportado sa version na ito
// ## Mga User-Provided Groovy Script
// ## Mga Script
// - Mga script content ay maaaring maglaman ng iba't ibang Groovy syntax at expressions
// - I-handle ang mga kaso kung saan ang input ay empty string o null
// - Mag-throw ng naaangkop na exceptions kapag nabigo ang script execution
// - Ang Groovy version ay 3.0.9; huwag gumamit ng mga API na hindi suportado sa version na ito
//
// ## Mga Script
// - Mga script content ay maaaring maglaman ng iba't ibang Groovy syntax at expressions
// - I-handle ang mga kaso kung saan ang input ay empty string o null
// - Mag-throw ng naaangkop na exceptions kapag nabigo ang script execution
// - Ang Groovy version ay 3.0.9; huwag gumamit ng mga API na hindi suportado sa version na ito
// ```
package com.example.service;

import java.util.List;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author lom
 */
public class ScriptService {

    private final String scriptPath = "src/main/java/com/example/service/";
    private final String scriptContent = "return 'Hello World'";
    private final String scriptExecution = "scriptService";

    public Object executeUserScript(String scriptContent) {
        RestOperations restOperations = null;
        try {
            restOperations = new RestOperations();
            String scriptResponse = restOperations.getForObject(scriptPath + scriptExecution, String.class);
            return scriptResponse;
        } finally {
            restOperations.destroy();
        }
    }

    public Object executeUserScript(String scriptContent, String scriptExecution) {
        RestOperations restOperations = null;
        try {
            restOperations = new RestOperations();
            String scriptResponse = restOperations.getForObject(scriptPath + scriptExecution, String.class);
            return scriptResponse;
        } finally {
            restOperations.destroy();
        }
    }

    public List<Object> executeUserScriptList(String scriptContent) {
        return null;
    }
}
