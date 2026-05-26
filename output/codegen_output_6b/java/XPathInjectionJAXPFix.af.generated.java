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
public class XPathTest {

    public static void main(String[] args) {
        XPathTest xp = new XPathTest();
        System.out.println(xp.findUserRoleByUsername("gert"));
    }

}
