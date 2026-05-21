 Ang code ay dapat na maikli at mahusay
- Walang mga security vulnerabilities

## Output Format

Ilabas ang kumpletong code para sa `src/main/java/com/example/webapp/service/XmlDataParser.java` sa sumusunod na format:

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

## Input Format

```xml
<message>
    <path>
        path1
    </path>
    <content>
        <![CDATA[
            content1
        ]]>
    </content>
</message>
```

## Sample Implementation

```java
public class XmlDataParser implements DataParser<String> {
    @Override
    public String parse(String xmlContent) throws Exception {
        org.jdom2.Document document = new org.jdom2.input.SAXBuilder().build(new StringReader(xmlContent));
        org.jdom2.Element root = document.getRootElement();
        return root.getChildText("code").getText();
    }
}
```

## Sample Output

```java
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

## Sample Input

```xml
<message>
    <path>
        path1
    </path>
    <content>
        <![CDATA[
            content1
        ]]>
    </content>
</message>
```

## References

- [JDOM2](https://github.com/jdom2/jdom2)

*/
