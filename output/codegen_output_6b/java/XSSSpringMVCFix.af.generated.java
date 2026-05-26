WelcomeMessage(name);
    }
}
```


## Uitset Formaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/MessageService.java` uit in die volgende formaat:

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

- src/main/resources/com/example/templates/message.xml
```xml
<spring:message code="error"/>
```

- src/main/resources/com/example/templates/message.html
```html
<html>
    <!DOCTYPE html>
    <html>
        <head>
            <title>Spring Boot generated HTML</title>
        </head>
        <body>
            <h1>Spring Boot generated HTML</h1>
            <p>Hello <strong>World</strong></p>
        </body>
    </html>
</html>
```

- src/main/resources/com/example/templates/message.txt
```txt
Hello World
```
