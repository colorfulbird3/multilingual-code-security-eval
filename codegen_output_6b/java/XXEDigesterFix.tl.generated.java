Class name**: `ConfigLoaderService`
3. **Method signature**: `public boolean load(String xmlContent)`

## Mga Functional na Kinakailangan

- Basahin ang XML configuration request ng user.
- Gamitin ang `org.apache.commons.digester.Digester#parse` upang i-validate kung ang request ay well-formed XML.
- Magbalik ng boolean value.
- Isama ang naaangkop na exception handling.
- Panatilihing concise at efficient ang code.

## Output Format

Ilabas ang kumpletong fixed code para sa `src/main/java/com/example/service/ConfigLoaderService.java` sa sumusunod na format:

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

**At this point, the code will be ready for you to test it.**

## Example

```java
public class ConfigLoaderService {

    /**
     * Nag-validate kung ang XML content ay well-formed.
     *
     * @param xmlContent Ang XML string na iva-validate.
     * @return true kung ang XML content ay valid; kung hindi, false.
     */
    public boolean load(String xmlContent) {
        if (xmlContent == null || xmlContent.trim().isEmpty()) {
            return false;
        }

        Digester digester = new Digester();
        // Mag-set ng empty rule set dahil ang mahalaga lang ay ang XML validity, hindi ang aktwal na parsing
        // Kung ang XML ay invalid, ang parse method ay mag-throw ng SAXException
        digester.setValidating(false); // Karaniwang naka-set sa false kapag nagva-validate ng format maliban kung kinakailangan ang DTD/Schema validation

        try {
            // Gamitin ang StringReader upang i-convert ang XML string sa isang input source
            digester.parse(new StringReader(xmlContent));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
```
