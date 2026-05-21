```java
public class UserService {
    private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public String findUserRoleByUsername(String username) {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("users.xml");
            
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "/users/user[name='" + username + "']/role";
            
            return xPath.evaluate(expression, document);
        } catch (Exception e) {
            throw new RuntimeException("Error finding user role", e);
        }
    }
}
```