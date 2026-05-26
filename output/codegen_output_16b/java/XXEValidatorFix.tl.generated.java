/com/example/service/ConfigService.java` sa sumusunod na format:

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

## Sample Dataset

```xml
   <?xml version="1.0" encoding="UTF-8"?>
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
       <code>
           <path>
               path2
           </path>
           <content>
               <![CDATA[
           content2
           ]]>
           </content>
       </code>
   </config>
```

## Sample Output

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

### References

- [XML Validation Service](https://developer.mozilla.org/en-US/docs/Web/API/Document.implementation.createProcessingInstruction)
- [The JAXP API](http://www.w3.org/TR/dom/#jaxp-api)
- [XML Schema 1.0](https://developer.mozilla.org/en-US/docs/Web/XML/Schema)
- [The Java Language Specification](https://docs.oracle.com/javase/8/docs/api/java/lang/package-summary.html)

