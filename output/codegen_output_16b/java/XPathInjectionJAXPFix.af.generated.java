.
     * @return Die rol van die gebruiker as 'n String, of null-string as die gebruiker nie gevind word nie.
     */
    public String findUserRoleByUsername(String username) {
        String role = "";
        try {
            // Konstrueer die XPath-uitdrukking om die gebruiker se rol te vind.
            String expression = "//user[name='" + username + "']/role/text()";

            // Dit voer die dinamies gekonstrueerde XPath-uitdrukking uit.
            role = this.path.evaluate(expression, this.xmlDocument);
        } catch (XPathExpressionException e) {
            return null;
        }
        return role;
    }
}
            ]]>
        </content>
    </code>
</result>
```
 */
public class XpathService {

    private static final String USERS_XML =
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "<users>\n" +
                    "    <user name=\"admin\" password=\"admin\" role=\"admin\"/>\n" +
                    "    <user name=\"user\" password=\"user\" role=\"user\"/>\n" +
                    "</users>";

    private final XPath path;

    /**
     * Constructor that initializes the xpath.
     */
    public XpathService() {
        XPathFactory factory = XPathFactory.newInstance();
        XPath path = factory.newXPath();
        this.path = path;
    }

    /**
     * Get the xpath.
     * @return The xpath.
     */
    public XPath getPath() {
        return this.path;
    }

    /**
     * Get the xpath result.
     * @param expression XPath expression.
     * @param object The document to execute the xpath on.
     * @return The xpath result.
     */
    public String evaluate(String expression, Object object) {
        return (String) path.evaluate(expression, object);
    }
}

"""

if __name__ == '__main__':
    print(__doc__)
