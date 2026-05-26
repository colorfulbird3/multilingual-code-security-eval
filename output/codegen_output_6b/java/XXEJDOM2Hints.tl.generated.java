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

- `result` is the root tag
- `code` is the tag with `path` and `content`
- `content` tag contains `<![CDATA[` and `]]>` string, the CDATA string.
- `path` tag contains the path
- `path1` is the path1
- `content1` is the content1

## Examples

## Code

```xml
<root>
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
</root>
```

```java
XmlDataParser xmlDataParser = new XmlDataParser();
String xmlData = "<root><code><path>path1</path><content><![CDATA[content1]]></content></code></root>";
String result = xmlDataParser.parse(xmlData);
// output:
// <result>
//     <code>
//         <path>
//             path1
//         </path>
//         <content>
//             <![CDATA[
//         content1
//         ]]>
//         </content>
//     </code>
// </result>
```

## Output

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

- `result` is the root tag
- `code` is the tag with `path` and `content`
- `content` tag contains `<![CDATA[` and `]]>` string, the CDATA string.
- `path` tag contains the path
- `path1` is the path1
- `content1` is the content1

```java
XmlDataParser xmlDataParser = new XmlDataParser();
String xmlData = "<root><code><path>path1</path><content><![CDATA[content1]]></content></code></root>";
String result =