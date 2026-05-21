ATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Ifomethi Yokukhipha

Khipha ikhodi ephelele elungisiwe ye-`src/main/java/com/example/webapp/service/XmlDataParser.java` ngefomethi elandelayo:

```xml
<message>
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
</message>
```

## Ifomethi Zokuhlazi Ya-XML

Nokhodi zokuhlaziye ye-`src/main/java/com/example/webapp/service/XmlDataParser.java`

## Ifomethi Zokuhlazi Ya-XML

Nokhodi zokuhlaziye ye-`src/main/java/com/example/webapp/service/XmlDataParser.java`

## Ikuzima

```java
package com.example.webapp.service;

import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;

import static com.example.webapp.config.AppConfig.getProperty;

public class XmlDataParser {
    public static void main(String[] args) {
        //System.out.println(parse("<message><code><path>path1</path><content><![CDATA[content1]]></content></code></message>"));
        //System.out.println(parse("<message><code><path>path1</path></code><content><![CDATA[content1]]></content></message>"));
        System.out.println(parse("<message><code><path>path1</path></code><content><![CDATA[content1]]></content></message>"));
        //System.out.println(parse("<message><code><path>