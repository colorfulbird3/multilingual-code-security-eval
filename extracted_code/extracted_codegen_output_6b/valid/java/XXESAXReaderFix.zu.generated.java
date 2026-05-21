import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;

import java.io.File;

public class XmlParser {

    public Document parseXmlFile(String filePath) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        org.dom4j.Document dom4jDocument = saxReader.read(new File(filePath));
        return dom4jDocument.getDocument();
    }
}