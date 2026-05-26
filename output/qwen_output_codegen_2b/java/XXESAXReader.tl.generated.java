// **Input**: Path sa XML file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)
// **Output**: Isang `org.w3c.dom.Document` object para sa kasunod na pagproseso ng data
// ## Exception Handling
// - Mag-throw ng `Exception` kapag invalid ang XML format
// - Magsagawa ng angkop na exception handling para sa empty o null na mga input
// - I-handle ang mga I/O exceptions tulad ng file not found
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
// I-output ang kumpletong code para sa:
// ```xml
// <config>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </config>
// ```
// ## Test Code
// ```xml
// <?xml version="1.0" encoding="UTF-8"?>
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
// <config>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </config>
// ```
// ## Test Code
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
// <config>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </config>
// ```
// ## Test Code
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
// <config>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </config>
// ```
// ## Test Code
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
// <config>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </config>
// ```

package mga.kinakailangan;

import org.w3c.dom.Document;

import java.util.ArrayList;

/**
 *
 * @author Fadhitya
 */
public class ConfigService {

    private static ArrayList<String> pathList;
    private static ArrayList<String> contentList;

    public void loadConfig(String path) {
        pathList = new ArrayList<>();
        contentList = new ArrayList<>();
        pathList.add(path);
        try {
            Document doc = Util.loadXMLFile(path);
            if (doc!= null) {
                pathList.addAll(Util.marshallXMLNode(doc));
                contentList = Util.marshallXMLNode(doc);
            } else {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getPathList() {
        return pathList;
    }

    public ArrayList<String> getContentList() {
        return contentList;
    }
}
