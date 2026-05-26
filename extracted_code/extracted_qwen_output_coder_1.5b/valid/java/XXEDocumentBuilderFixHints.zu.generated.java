import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlLoader {

    private Document document;

    public XmlLoader() {
        this.document = null;
    }

    public void loadFromFile(String filePath) throws DocumentException {
        SAXReader reader = new SAXReader();
        this.document = reader.read(new File(filePath));
    }

    public void loadFromString(String xmlContent) throws DocumentException {
        SAXReader reader = new SAXReader();
        this.document = reader.read(new StringReader(xmlContent));
    }

    public String getXmlAsString() throws IOException {
        if (this.document == null) {
            return "";
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        StringWriter writer = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(writer, format);
        xmlWriter.write(this.document);
        xmlWriter.close();
        return writer.toString();
    }

    public void saveToFile(String filePath) throws IOException {
        if (this.document == null) {
            throw new IllegalStateException("No XML document loaded");
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter(new File(filePath)), format);
        writer.write(this.document);
        writer.close();
    }

    public Document getDocument() {
        return this.document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}