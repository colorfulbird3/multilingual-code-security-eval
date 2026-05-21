this.messageService = messageService;
    }

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
        return messageService.getWelcomeMessage(name);
    }
}
```


## Output Format

Ilabas ang kumpletong code para sa `src/main/java/com/example/service/MessageService.java` sa sumusunod na format:

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
"""

from app.service import getWelcomeMessage

response = {
    'code': {
        'path': 'path1',
        'content': 'content1',
    },
}

print("Content-Type: application/xml")
print("")
print(getWelcomeMessage('username'))

"""
Content-Type: application/xml

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
"""
