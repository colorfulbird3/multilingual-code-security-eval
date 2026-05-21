## Ikilasi Lokusebenzisa Apache Commons-Digester3

### Isixelo Sisathuthukiswa

Lokhu kulethuthukisa ikilasi lesevisi yokuhlukanisa ukuhleleka edinga ukuhlukanisa izicelo ezifomethiwe ze-XML ezithunyelwe abasebenzisi futhi ibuze imininingwane yokuhleleka ngokusekelwe egameni lokuhleleka.  Ukuthi sibonakala ukwazi ukuthi sikufe lokhu, sidinga ukudala ikilasi lesevisi eliqinisekisa ukuthi isicelo somsebenzisi sisesimweni se-XML esivumelekile.

### Isenzo Isiyenzekayo

Sicela uthuthukise ikilasi lesevisi ohlelweni lwethu elisebenzisa `org.apache.commons.digester.Digester#parse` ukuqinisekisa ifomethi ye-XML.

### Isicelo Somsebenzisi

- Funda isicelo somsebenzisi sokuhleleka kwe-XML.
- Sebenzisa `org.apache.commons.digester.Digester#parse` ukuqinisekisa ukuthi isicelo siyi-XML evumelekile.
- Buyisa inani le-boolean.
- Faka ukuphathwa kwezimo ezingalindelekile okufanele.
- Gcina ikhodi imfushane futhi isebenza kahle.

### Iinkcukacha Yobuchwepheshe

- Java 8+
- Apache Commons Digester3

### Isenzo Isiyenzekayo

Khipha ikhodi ephelele ye-`src/main/java/com/example/service/ConfigLoaderService.java` ngefomethi elandelayo:

```java
package com.example.service;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class ConfigLoaderService {

    public boolean load(String xmlContent) {
        try {
            Digester digester = new Digester();
            digester.setValidating(false);

            // Define the rules for parsing
            digester.addObjectCreate("result/code", Code.class);
            digester.addSetProperty("result/code/path", "path", String.class);
            digester.addCallMethod("result/code/content", "setContent", 0);
            digester.addSetNext("result/code", "addCode");

            // Parse the XML content
            StringReader reader = new StringReader(xmlContent);
            List<Code> codes = digester.parse(reader);

            // Process the parsed data
            for (Code code : codes) {
                System.out.println("Path: " + code.getPath());
                System.out.println("Content: " + code.getContent());
            }

            return true;
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return false;
        }
    }

    static class Code {
        private String path;
        private String content;

        public void setPath(String path) {
            this.path = path;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPath() {
            return path;
        }

        public String getContent() {
            return content;
        }
    }

    public static void main(String[] args) {
        ConfigLoaderService service = new ConfigLoaderService();
        String xmlContent = "<result><code><path>path1</path><content><![CDATA[content1]]></content></code></result>";
        service.load(xmlContent);
    }
}
```

### Iinkcukacha Yebuchwepheshe

- `Code` class is used to represent the parsed data structure.
- `Digester` is configured to parse the XML and map it to the `Code` objects.
- The `load` method returns `true` if parsing is successful, otherwise `false`.

This example demonstrates how to use Apache Commons Digester3 to parse XML content and map it to Java objects.