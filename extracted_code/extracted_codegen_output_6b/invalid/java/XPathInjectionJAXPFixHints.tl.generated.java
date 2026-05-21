public String findUserRoleByUsername(String username) {
    String role = "";
    try {
        String expression = "//user[name=$username]/role/text()";
        this.path.setXPathVariableResolver(v -> {
            if ("username".equals(v.getLocalPart())) {
                return username;
            }
            throw new IllegalArgumentException("Hindi kilalang variable: " + v.getLocalPart());
        });
        role = this.path.evaluate(expression, this.xmlDocument);
    } catch (XPathExpressionException e) {
        return null;
    }
    return role;
}
}