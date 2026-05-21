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