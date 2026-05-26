 ang impormasyon ng role.
     *
     * @param username Ang username na hahanapin.
     * @return Ang role ng user bilang isang String, o null string kung hindi mahanap ang user.
     */
    public String findUserRoleByUsername(String username) {
        String role = "";
        try {
            // Gamitin ang XPath variable binding upang maiwasan ang injection
            String expression = "//user[name=$username]/role/text()";
            this.path.setXPathVariableResolver(v -> {
                if ("username".equals(v.getLocalPart())) {
                    return username;
                }
                throw new IllegalArgumentException("Hindi kilalang variable: " + v.getLocalPart());
            });
            role = this.path.evaluate(expression, this.xmlDocument);
        } catch (XPathExpressionException e) {
            // Maaaring mangyari ito sa hindi tamang XPath syntax
            // Para sa pagiging simple, nagbabalik tayo ng null.
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
