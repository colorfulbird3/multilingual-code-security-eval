}
    }
}
</code>

## Ifomethi Yokukhipha

Khipha ikhodi ephelele elungisiwe ye-`src/main/java/com/example/service/SchemaValidationService.java` ngefomethi elandelayo:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Eksihona

Isizinda nokho eksihone kuqinisekiswa kwama-XML Schema alayishwe ngumsebenzisi unu kwe-<code> tag elandelayo.

<code>
package com.example.service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(schemaContent));

            while (reader.hasNext()) {
                reader.next();
            }
            return true;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return false;
        }
    }
}
</code>

## Eksihone ngefomethi

Eksihone kwama-XML Schema ngumsebenzisi unu kwe-<code> tag elandelayo.

<code>
package com.example.service;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.StringReader;

public class SchemaValidationService {

    public boolean validateSchema(String schemaContent) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(schemaContent));

            while (reader.hasNext()) {
                reader.next();
            }
            return true;
        } catch (XMLStreamException e) {
            e.printStackTrace();
            return false;
        }
    }
}
</code>


## Umsebenzi kwama-XML