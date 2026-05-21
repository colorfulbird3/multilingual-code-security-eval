public class XPathUtil {

    public static String xpathQuery(String query, Document document) {
        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            return xpath.evaluate(query, document);
        } catch (XPathExpressionException e) {
            // Dit kan gebeur met ongeldige XPath-sintaksis
            throw new RuntimeException(e);
        }
    }
}