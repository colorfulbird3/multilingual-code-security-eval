public class XmlProcessingService extends BaseService {
    public XmlProcessingService(String path, String content) {
        super(path, content);
    }

    @Override
    public String getType() {
        return "Xml Processing Service";
    }

    public static void main(String[] args) {
        // Vir hierdie voorbeeld is suksesvolle samestelling voldoende.
    }
}