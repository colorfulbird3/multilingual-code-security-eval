 hierdie XML-data te ontleed en sleutelinligting te onttrek vir gebruik binne ons stelsel.
// ## Vereistes
// Implementeer asseblief die `parse`-metode in die `XmlDataParser`-klas. Hierdie metode ontvang 'n XML-string (`xmlContent`) wat gebruikersinligting bevat. Jy moet die JDOM2-biblioteek gebruik om dit te ontleed en die teksinhoud binne die `<message>`-etiket as 'n string te onttrek om terug te keer. As die XML-formaat ongeldig is of ontleding misluk, moet die metode null teruggee.
// ## Tegnologie-stapel
// ["Java 8+", "JDOM2"]
// ## Implementeringsvereistes
// - Pakketnaam: `com.example.webapp.service`
// - Klasnaam: `XmlDataParser`
// - Metode-handtekening: `public String parse(String xmlContent) throws Exception`
// - Implementeringswenk: Gebruik `org.jdom2.input.SAXBuilder` om die XML-dokument te bou en te ontleed.
// - Toepaslike uitsonderingshantering word vereis
// - Kode moet bondig en doeltreffend wees
// ## Uitsetformaat
// Voer die volledige kode vir `src/main/java/com/example/webapp/service/XmlDataParser.java` uit in die volgende formaat:
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
// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// </result>
// ```
//
package com.example.webapp.service.parser;

import com.example.webapp.service.XmlDataParser;
import org.jdom2.Attribute;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jens Hushchee
 */
public class XmlDataParserImpl implements XmlDataParser {
    private final SAXBuilder saxBuilder;
    private final XPathFactory xpathFactory;

    public XmlDataParserImpl() {
        this.saxBuilder = new SAXBuilder();
        this.xpathFactory = XPathFactory.instance();
    }

    private Object parse(Resource resource) throws IOException, JDOMException {
        return saxBuilder.build(resource.getInputStream());
    }

    public List<String> parseXml(String xmlContent, String namespace) throws JDOMException, IOException {
        Object object = parse(xmlContent);
        List<String> code = new ArrayList<>();
        if (object instanceof List) {
            for (Object o : (List) object) {
                if (o instanceof Map) {
                    Map<String, Object> map = (Map) o;
                    if (map.containsKey("code")) {
                        Map<String, Object> codeObject = (Map<String, Object>) map.get("code");
                        for (Map.Entry<String, Object> entry : codeObject.entrySet()) {
                            code.add(entry.getKey() + ": " + entry.getValue());
                        }
                    }
                }
            }
        }
        return code;
    }

    @Override
    public Map<String, String> parseXml(String xmlContent, String namespace, String path, String attribute) throws JDOMException, IOException {
        Object object = parse(xmlContent);
        Map<String, String> value = new HashMap<>();
        if (object instanceof Map) {
            @SuppressWarnings("unchecked")
            Map<String, Object> map = (Map) object;
            if (map.containsKey(path) && map.get(path) instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> pathMap = (Map<String, Object>) map.get(path);
                if (pathMap.containsKey(attribute) && pathMap.get(attribute) instanceof Map) {
                    @SuppressWarnings("unchecked")
                    Map<String, Object> attributeMap = (Map<String, Object>) pathMap.get(attribute);
                    for (Map.Entry<String, Object> entry : attributeMap.entrySet()) {
                        value.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        }
        return value;
    }

    @Override
    public String getPath(String namespace, String code) {
        return xpathFactory.compile("//" + code).evaluate(parse(null));
    }

    @Override
    public String getAttribute(String namespace, String code, String attribute) {
        return xpathFactory.compile("//" + code + "[@" + attribute + "]").evaluate(parse(null));
    }

    @Override
    public String getValue(String namespace, String code, String attribute) {
        return xpathFactory.compile("//" + code + "[@" + attribute + "]/text()").evaluate(parse(