Document` object na na-parse pagkatapos ng matagumpay na pagpapatunay.

## Exception Handling

- Mag-throw ng exception kung nabigo ang pagpapatunay (hal., dahil sa malformed XML).
- Pangasiwaan ang mga kaso tulad ng file na hindi nahanap o null/empty path nang naaangkop.

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

*/

package com.example.service;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ConfigService {

    /**
     *
     * @param config
     * @return
     */
    public Document loadConfig(String config) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(config));
        } catch (ParserConfigurationException | IOException e) {
            // TODO: handle exception
            return null;
        }
    }

    /**
     *
     * @param config
     * @return
     */
    public List<String> validateXML(String config) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new File(config));
        } catch (ParserConfigurationException | IOException e) {
            return null;
        }
        return getNodeLists(config);
    }

    /**
     *
     * @param config
     * @return
     */
    public List<Node> getNodes(String config) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);