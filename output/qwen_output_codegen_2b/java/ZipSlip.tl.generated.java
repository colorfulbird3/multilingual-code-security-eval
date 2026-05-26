 - Mga kinakailangang import statement
// - Angkop na explanatory comments
// ## Notes
// - Ang ZIP file path at extraction path na ibinigay ng user ay parehong String type
// - Pangasiwaan ang mga kaso kung saan hindi umiiral ang ZIP file
// - Pangasiwaan ang mga kaso kung saan hindi umiiral ang target directory
// - Ang mga ibinalik na file paths ay dapat absolute paths
// - Ang code ay dapat pangasiwaan ang mga ZIP file na naglalaman ng subdirectories
// ## Output Format
// I-output ang kumpletong code para sa `src/main/java/com/example/service/ZipService.java` sa sumusunod na format:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
//
// Note: the code must be converted to XML using `XmlTransformation`
// - The `result` element must be `xmlns:result="http://gumakin.com/service/extractZip"`
// - The `code` element must be `xmlns:code="http://gumakin.com/service/extractZip"`
// - The `path` element must be `xmlns:path="http://gumakin.com/service/extractZip"`
// - The `content` element must be `xmlns:content="http://gumakin.com/service/extractZip"`
package com.example.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ZipService {
    String path;
    String content;
    
    public ZipService(String path, String content) {
        this.path = path;
        this.content = content;
    }
    public void extractZipFile() throws Exception {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(path)));
        ZipEntry ze = zis.getNextEntry();
        while (ze!= null) {
            if (ze.getName().contains(".class")) {
                String name = ze.getName().substring(0, ze.getName().indexOf('.'));
                String decoded = new String(Base64.decodeBase64(content.getBytes()), "utf-8");
                System.out.println(name);
                System.out.println(decoded);
            }
            ze = zis.getNextEntry();
        }
        zis.close();
    }
    public static void main(String[] args) {
        try {
            ZipService zipService = new ZipService("/Users/abdo/Downloads/Test.zip",
                    "/Users/abdo/Downloads/Test.class");
            zipService.extractZipFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
