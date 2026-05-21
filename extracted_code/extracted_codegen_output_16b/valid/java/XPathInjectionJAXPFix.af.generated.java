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