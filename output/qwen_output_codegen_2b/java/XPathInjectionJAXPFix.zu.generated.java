benzisi engatholakali.
// */
// public String findUserRoleByUsername(String username) {
// String role = "";
// try {
// // Yakha isisho se-XPath ukuze uthole indima yomsebenzisi.
// String expression = "//user[name='" + username + "']/role/text()";
// // Isebenzisa isisho se-XPath esakhiwe ngokuguquguqukayo.
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
//
// @author shanahad
// @since 1.0
public class XMLParser {
    @XStreamAlias("code")
    private String code;
    @XStreamAlias("path")
    private String path;
    @XStreamAlias("content")
    private String content;

    public XMLParser() {
    }

    public XMLParser(String code, String path, String content) {
        this.code = code;
        this.path = path;
        this.content = content;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
