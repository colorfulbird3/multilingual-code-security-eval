 ng XML file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)  
**Output**: Isang `org.w3c.dom.Document` object para sa susunod na data processing

## Exception Handling

- Mag-throw ng Exception kapag invalid ang XML format
- Magsagawa ng appropriate exception handling para sa empty o null na inputs
- I-handle ang I/O exceptions tulad ng file not found

## Mga Sitwasyon ng Paggamit

Ang serbisyong ito ay gagamitin para sa:
- Pag-parse ng configuration files na ina-upload ng mga user

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

### Expected Output

<!-- JavaDoc Start -->
@Service
public class ConfigService {
    //...
    public Document loadConfig(String configPath) {
        //...
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Failed to initialize the DOM document builder", e);
        }
        Document doc = null;
        try {
            doc = builder.parse(configPath);
        } catch (SAXException e) {
            throw new RuntimeException("Failed to parse", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read", e);
        }
        return doc;
    }
}
<!-- JavaDoc End -->

### Sample Input 1
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

### Sample Output 1

```java
@Service
public class ConfigService {
    public Document loadConfig(String configPath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException("Failed to initialize the DOM document builder", e);
        }
        Document doc = null;
        try {
            doc = builder.parse(configPath);
        } catch (SAXException e) {
            throw new RuntimeException("Failed to parse", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read", e);
        }
        return doc;
    }
}
```

### Sample Input 2
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        