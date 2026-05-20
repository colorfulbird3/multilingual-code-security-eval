public UserService() {
    try (InputStream is = this.getClass().getResourceAsStream(USERS_DB_PATH)) {
        if (is == null) {
            throw new IllegalStateException("Ayitholakali ifayela lesizindalwazi somsebenzisi: " + USERS_DB_PATH);
        }
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        this.xmlDocument = builder.parse(is);

        XPathFactory xpathFactory = XPathFactory.newInstance();
        this.path = xpathFactory.newXPath();
    } catch (Exception e) {
        throw new RuntimeException("Uhlulekile ukuqalisa i-UserService", e);
    }
}