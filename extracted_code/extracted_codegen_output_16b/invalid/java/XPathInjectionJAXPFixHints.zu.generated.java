public String getRole(String username) {
    String role = null;
    try {
        // Simulate XPath evaluation
        if ("admin".equals(username)) {
            role = "admin";
        } else if ("user".equals(username)) {
            role = "user";
        }
    } catch (XPathExpressionException e) {
        // Lokhu kungenzeka nge-syntax ye-XPath engavumelekile
        // Ukuze kube lula, sibuyisela i-null.
        return null;
    }
    return role;
}