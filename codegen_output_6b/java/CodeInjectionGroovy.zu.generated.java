content>
    </code>
</result>
```

```xml
<result>
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
</result>
```

## Uthu-fotunge

```java
ScriptService service = new ScriptService();
Object result = service.executeUserScript("return 'Hello World'");
// Okulindelekile ukubuyisela: "Hello World"

Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// Okulindelekile ukubuyisela: 14
```

## Amaphuzu Okuqukhe

```java
ScriptService service = new ScriptService();
Object result = service.executeUserScript("return 'Hello World'");
// Okulindelekile ukubuyisela: "Hello World"

Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// Okulindelekile ukubuyisela: 14
```
