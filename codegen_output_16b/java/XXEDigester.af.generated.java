

## Uitset Uitstaande

Voer uit de volgende code uit na die uitstaande van de kode voor die konfigurasie:

```java
import com.example.service.ConfigLoaderService;

public class ConfigLoaderService {
    public static void main(String args[]) {
        ConfigLoaderService loader = new ConfigLoaderService();
        loader.load("<result><code><path>path1</path><content><![CDATA[content1]]></content></code></result>");
    }

    private void load(String xmlContent) {
        ConfigLoaderService loader = new ConfigLoaderService();
        // Do something with the contents.
        //...
    }
}
```

## Implementering Uitstaande

Voer uit de volgende code uit na die uitstaande van die konfigurasie:

```java
import com.example.service.ConfigLoaderService;

public class ConfigLoaderService {
    @SuppressWarnings("unchecked")
    private void load(String xmlContent) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(xmlContent)));
            Element result = document.getDocumentElement();
            Element code = result.getElementsByTagName("code").item(0);
            Element path = code.getElementsByTagName("path").item(0);
            Element content = code.getElementsByTagName("content").item(0);

            // Do something with the contents.
            //...
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
```

## Ontwikkelings-diensklas skep

Veranduur na 'n diensklas:

```xml
<ontwikkelings-diensklas>
    <class name="ConfigLoaderService" >
    </class>
</ontwikkelings-diensklas>
```

## Ontwikkelings-diensklas beskrywing

Voer u