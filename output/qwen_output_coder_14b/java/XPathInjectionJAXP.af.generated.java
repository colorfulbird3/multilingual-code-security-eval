Hier is die volledige implementering van die `UserService`-klas met die `findUserRoleByUsername`-metode:

```xml
<result>
    <code>
        <path>
            src/main/java/com/example/xpath/service/UserService.java
        </path>
        <content>
            <![CDATA[
package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import java.io.InputStream;

public class UserService {

    public String findUserRoleByUsername(String username) {
        try {
            // Laai die XML-lêer
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Stel die XPath-uitdrukking op om die rol van die gebruiker te vind
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//user[name='" + username + "']/role/text()";
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);

            // Kontroleer of die knoop bestaan en stuur die rol terug, anders stuur null terug
            if (node != null) {
                return node.getNodeValue();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
]]>
        </content>
    </code>
</result>
```

Hier is 'n korte beskrywing van die implementering:

1. **XML-lêer laai**: Die `findUserRoleByUsername`-metode begin met die laai van die `users.xml`-lêer. Dit word gedaan met behulp van 'n `InputStream` en 'n `DocumentBuilder`.

2. **XPath-uitdrukking**: 'n XPath-uitdrukking word gestel om die rol van die gebruiker te vind. Die uitdrukking soek na 'n `user`-noo met 'n `name`-element wat ooreenstem met die gegewe `username`, en dan het die `role`-element se teksinhoud.

3. **XPath-evaluering**: Die XPath-uitdrukking word geëvalueer met behulp van die `XPath#evaluate`-metode. Indien die knoop bestaan, word die teksinhoud daarvan teruggegee. Indien die knoop nie bestaan nie, word `null` teruggegee.

4. **Uitsonderingshantering**: Die metode handel almalige uitsonderings af en druk die stack trace af.

Hier is die volledige implementering van die `UserService`-klas met die `findUserRoleByUsername`-metode:

```java
package com.example.xpath.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import java.io.InputStream;

public class UserService {

    public String findUserRoleByUsername(String username) {
        try {
            // Laai die XML-lêer
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Stel die XPath-uitdrukking op om die rol van die gebruiker te vind
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "//user[name='" + username + "']/role/text()";
            Node node = (Node) xPath.evaluate(expression, document, XPathConstants.NODE);

            // Kontroleer of die knoop bestaan en stuur die rol terug, anders stuur null terug
            if (node != null) {
                return node.getNodeValue();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
```