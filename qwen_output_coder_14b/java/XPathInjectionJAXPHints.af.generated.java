Hier is die implementering van die `findUserRoleByUsername` metode in die `UserService`-klas:

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
            // Load the XML document from the resource
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Create an XPath instance
            XPath xpath = XPathFactory.newInstance().newXPath();

            // Construct the XPath expression to find the user node with the given username
            String expression = "//user[name='" + username + "']/role/text()";
            String role = (String) xpath.evaluate(expression, document, XPathConstants.STRING);

            return role.isEmpty() ? null : role;
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

### Omskrywing van die Implementering:

1. **XML-dokument Laai**: Die XML-dokument word laai vanaf die `users.xml`-lêer wat in die `src/main/resources` directory gevestig is. Dit word gebruik deur `getClass().getClassLoader().getResourceAsStream("users.xml")` om 'n `InputStream` te verkry.

2. **XPath Onderhouder**: 'n `XPath`-onderhouder word geskep om XPath-uitdrukkinge te evalueer.

3. **XPath Uitdrukking**: 'n XPath-uitdrukking word konstrueer om die `role`-element van die `user`-nodus te vind wat die gegewe `username` het. Die uitdrukking is `"//user[name='" + username + "']/role/text()"`.

4. **Evaluering van XPath**: Die `XPath#evaluate`-metode word gebruik om die XPath-uitdrukking op die XML-dokument te evalueer. Indien die rol gevind word, word dit teruggegee; anders word `null` teruggegee.

5. **Uitsonderingshantering**: 'n Try-catch-blok word gebruik om eventuele uitsonderings te handel, waaronder `XPathExpressionException` en ander moglike IO-uitsonderings.