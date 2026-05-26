 Die rol van die gebruiker as 'n String, of null-string as die gebruiker nie gevind word nie.
// */
// public String findUserRoleByUsername(String username) {
// String role = "";
// try {
// // Konstrueer die XPath-uitdrukking om die gebruiker se rol te vind.
// String expression = "//user[name='" + username + "']/role/text()";
// // Dit voer die dinamies gekonstrueerde XPath-uitdrukking uit.
// role = this.path.evaluate(expression, this.xmlDocument);
// } catch (XPathExpressionException e) {
// return null;
// }
// return role;
// }
// }
// ]]>
// </content>
// </code>
// </result>
// ```
public class XMLView {
  private static final String ROLE = "role";
  private static final String USERNAME = "name";
  private static final String XML_DOCUMENT = "xmlDocument";
  private static final String XML_ROLE = "role";
  private static final String XML_ROLE_VALUE = "value";

  private XMLView() {
    // No-op
  }

  /**
   * Retrieves a XML document given a path.
   *
   * @param path The path to retrieve a XML document.
   * @return A XML document, or null if the path was not found.
   */
  public static Document getXMLDocument(String path) {
    try (InputStream is = XMLView.class.getResourceAsStream(path)) {
      if (is == null) {
        return null;
      }
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(is);
      return document;
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * Retrieves the path to the XML document.
   *
   * @return The path to the XML document.
   */
  public static String getXMLDocumentPath() {
    return USERS_DB_PATH;
  }

  /**
   * Retrieves the role value from a XML document.
   *
   * @param xmlDocument The XML document.
   * @return The role value from a XML document.
   */
  public static String getRoleValue(Document xmlDocument) {
    try {
      NodeList roles = (NodeList) this.path.evaluate(XML_ROLE, xmlDocument, XPathConstants.NODESET);
      if (roles == null || roles.getLength() == 0) {
        return null;
      }
      return roles.item(0).getTextContent();
    } catch (XPathExpressionException e) {
      return null;
    }
  }

  /**
   * Retrieves the username from a XML document.
   *
   * @param xmlDocument The XML document.
   * @return The username from a XML document.
   */
  public static String getUsername(Document xmlDocument) {
    try {
      NodeList users = (NodeList) this.path.evaluate(XML_USERNAME, xmlDocument, XPathConstants.NODESET);
      if (users == null || users.getLength() == 0) {
        return null;
      }
      return users.item(0).getTextContent();
    } catch (XPathExpressionException e) {
      return null;
    }
  }
}
