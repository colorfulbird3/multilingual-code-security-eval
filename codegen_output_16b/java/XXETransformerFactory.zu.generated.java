

## I-JAXP

Uma ikiphatha iganga i-XML

```xml
<?xml version="1.0"?>
<config>
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
</config>
```

Uma inguquleni `org.w3c.dom.Document` object

```xml
<?xml version="1.0"?>
<config>
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
</config>
```

## I-JAXP's `TransformerFactory`

- Umlezi `javax.xml.transform.TransformerFactory`
- I-`TransformerFactory` ukudala i-XML

## I-JAXP's `Transformer`

- Umlezi `javax.xml.transform.Transformer`
- Sebenzisa i-identity transform
- I-`Transformer` ukudala i-XML

## I-JAXP's `TransformerFactory` and `Transformer` object

- Umlezi `com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl`
- Umlezi `com.sun.org.apache.xalan.internal.xsltc.trax.Transformer`
- Sebenzisa i-identity transform
- Uma inguquleni `org.w3c.dom.Document` object
- Sebenzisa i-XML inguquko (transformation) ku-XML engenayo futhi ugcine umphumela ku-`org.w3c.dom.Document` object.

## Ekhephumayo

**Ekhephumayo**: I-`org.w3c.dom.Document` object ekhiqizwe ngem