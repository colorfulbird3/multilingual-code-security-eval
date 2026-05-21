public String findUserRoleByUsername(String username) {
    String role = "";
    try {
        String expression = "//user[name='" + username + "']/role/text()";
        role = this.path.evaluate(expression, this.xmlDocument);
    } catch (XPathExpressionException e) {
        return null;
    }
    return role;
}