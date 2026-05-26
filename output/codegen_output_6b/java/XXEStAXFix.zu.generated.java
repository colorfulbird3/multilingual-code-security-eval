

## Isizinda

I-`SchemaValidationService` yethu ekhona yethu I-Schema ye-XML.

## Izidingo

Thuthukisa ukusetshenziswa kwekhodi ye-Java ngaphakathi kwe-`<code>` XML tag ngezansi, futhi ulungise noma yiziphi izinkinga uma zikhona.

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
