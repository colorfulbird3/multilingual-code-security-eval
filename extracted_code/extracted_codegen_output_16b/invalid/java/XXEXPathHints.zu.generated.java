public String extractMetric(String xmlContent, String xpathExpression) {
    String metricValue = null;
    XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();
    try {
        XPathExpression expr = xpath.compile(xpathExpression);
        Node node = (Node) expr.evaluate(xmlContent, XPathConstants.NODE);
        if (node!= null) {
            metricValue = node.getTextContent();
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return metricValue;
}