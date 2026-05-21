 Die metode bevra die onderliggende XML-databerging om rol-inligting te herwin.
     *
     * @param username Die gebruikersnaam om na te soek.
     * @return Die rol van die gebruiker as 'n String, of 'n nulstring as die gebruiker nie gevind word nie.
     */
    public String findUserRoleByUsername(String username) {
        String role = "";
        try {
            // Konstrueer die XPath-uitdrukking om die gebruiker se rol te vind.
            String expression = "//user[name='" + username + "']/role/text()";

            // Dit voer die dinamies gekonstrueerde XPath-uitdrukking uit.
            role = this.path.evaluate(expression, this.xmlDocument);
        } catch (XPathExpressionException e) {
            // Dit mag gebeur met ongeldige XPath-sintaksis
            // Vir eenvoud, keer ons null terug.
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
