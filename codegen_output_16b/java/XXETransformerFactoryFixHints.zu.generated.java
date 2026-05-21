

## Umsebenzisa Okumeke

Umsebenzisa okumeke ne-`org.w3c.dom.Document` ukubuyekezwa kwe-XML elinikezwe.

## Ifomethi Okumeke

Ifomethi okumeke ne-`org.w3c.dom.Document` ukugubeza kwezokuphepha kwekhoqo.

## Elingabirana

Elingabirana zokumisa:

```java
    import org.w3c.dom.Document;
    import javax.xml.transform.Transformer;
    import javax.xml.transform.TransformerFactory;
    import javax.xml.transform.dom.DOMResult;
    import javax.xml.transform.stream.StreamSource;
    import java.io.File;
    
    public static void main(String[] args) throws Exception {
        Document doc = loadConfig(args[0]);
        
        TransformerFactory factory = TransformerFactory.newInstance();
        
        // Create an identity transformer
        Transformer transformer = factory.newTransformer();
        
        DOMResult result = new DOMResult();
        
        transformer.transform(new StreamSource(args[0]), result);
        
        System.out.println(result.getNode().getTextContent());
    }
```