To implement the `findUserRoleByUsername` method using JAXP, you need to follow these steps:

1. Load the XML file.
2. Create an XPath object.
3. Compile the XPath expression.
4. Evaluate the XPath expression on the XML document.
5. Return the result.

Here's how you can do it:

### Step 1: Load the XML File

First, you need to load the XML file into a Document object. You can use `DocumentBuilderFactory` and `DocumentBuilder` for this purpose.

```java
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public class UserService {
    private Document document;

    public UserService(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.document = builder.parse(new File(filePath));
    }
}
```

### Step 2: Create an XPath Object

Next, create an XPath object to evaluate XPath expressions.

```java
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPath;

public class UserService {
    private Document document;
    private XPath xpath;

    public UserService(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.document = builder.parse(new File(filePath));
        
        XPathFactory xpathFactory = XPathFactory.newInstance();
        this.xpath = xpathFactory.newXPath();
    }
}
```

### Step 3: Compile the XPath Expression

Compile the XPath expression that will be used to find the role of a user by username.

```java
public class UserService {
    private Document document;
    private XPath xpath;

    public UserService(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.document = builder.parse(new File(filePath));
        
        XPathFactory xpathFactory = XPathFactory.newInstance();
        this.xpath = xpathFactory.newXPath();
    }

    public String findUserRoleByUsername(String username) throws Exception {
        String expression = "//user[name='" + username + "']/role/text()";
        return (String) xpath.evaluate(expression, document, XPathConstants.STRING);
    }
}
```

### Step 4: Evaluate the XPath Expression

Evaluate the compiled XPath expression on the XML document.

```java
public class UserService {
    private Document document;
    private XPath xpath;

    public UserService(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
