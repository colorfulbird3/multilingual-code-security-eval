</content>
    </code>
</result>
```

## Uitvoerformaat:

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

## Kontroller

Als <code>schemaContent</code> een XML-skema is, kost u <code>validateSchema(schemaContent)</code> een waar.

###
<code>validateSchema(schemaContent) === true</code>

###
<code>validateSchema(schemaContent) === false</code>

###

<code>
<pre>
    import com.example.service.*;
    System.out.println(SchemaValidationService.validateSchema("<schema xmlns=\"http://www.w3.org/2001/XMLSchema\" targetNamespace=\"http://www.example.com/\" xmlns:jaxp=\"http://java.sun.com/xml/jaxp\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.w3.org/2001/XMLSchema http://www.w3.org/2001/XMLSchema.xsd\">" +
"<element name=\"root\" maxOccurs=\"1\">" +
"<complexType name=\"root\">" +
"<sequence>" +
"<element name=\"child1\" type=\"string\"/>" +
"<element name=\"child2\" type=\"string\"/>" +
"</sequence>" +
"</complexType>" +
"</element>" +
"</schema>")</pre>
</code>
