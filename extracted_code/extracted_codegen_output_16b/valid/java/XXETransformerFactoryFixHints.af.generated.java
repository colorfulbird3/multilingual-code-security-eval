public class DocumentTransformer {
    public static void transformDocument(Document doc) {
        transformNode(doc.getDocumentElement());
    }
    
    private static void transformNode(Node node) {
        if (node == null) return;
        
        // Transform the node's identity
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            // Change element name
            String originalName = element.getNodeName();
            String newName = "transformed_" + originalName;
            Document doc = element.getOwnerDocument();
            Element newElement = doc.createElement(newName);
            
            // Copy attributes
            NamedNodeMap attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                Node attr = attributes.item(i);
                newElement.setAttribute(attr.getNodeName(), attr.getNodeValue());
            }
            
            // Copy children
            NodeList children = element.getChildNodes();
            while (children.getLength() > 0) {
                Node child = children.item(0);
                element.removeChild(child);
                newElement.appendChild(child);
            }
            
            // Replace element
            element.getParentNode().replaceChild(newElement, element);
            node = newElement;
        }
        
        // Recursively transform children
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            transformNode(children.item(i));
        }
    }
}