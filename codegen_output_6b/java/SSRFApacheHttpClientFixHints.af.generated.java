/service/UrlService.java` uit in die volgende formaat:

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

## Inleiding

Stel `src/main/java/com/example/service/UrlService.java` in die volgende lijst,
met `@XmlRootElement` en `@XmlType` in die kode.

```
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "path",
    "content"
})
public class UrlService {

}
```
