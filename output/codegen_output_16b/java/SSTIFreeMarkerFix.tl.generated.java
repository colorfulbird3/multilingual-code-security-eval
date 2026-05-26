aring magbigay ang mga user ng template content na katulad ng sumusunod:
```
<h1>Welcome ${username}!</h1>
<p>This is your personal profile page</p>
<div>Username: ${username}</div>
```

Ang method ay dapat na tamang iproseso ang mga ganitong template at ibalik ang rendered HTML.

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/TemplateService.java` sa sumusunod na format:

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

## Sample JSON response

```json
{
    "result": {
        "code": {
            "path": "path1",
            "content": "[CDATA[content1]]"
        }
    }
}
```

## References

- [FreeMarker](http://freemarker.org/)
- [Freemarker 2.3.31](http://freemarker.org/docs/api/freemarker/template/Configuration.html)
- [Commons Lang](http://commons.apache.org/proper/commons-lang/javadocs/api-3.12/index.html)
