public class Main {
    public static void main(String[] args) {
        try {
            XmlProcessingService service = new XmlProcessingService();
            
            // Example XSD content
            String xsdContent = "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n" +
                                "  <xs:element name=\"root\" type=\"xs:string\"/>\n" +
                                "</xs:schema>";
            
            // Load the schema
            service.loadSchema(xsdContent);
            
            System.out.println("Schema loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}