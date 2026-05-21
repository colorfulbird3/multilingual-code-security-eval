

Khipha ikhodi ephelele ye `src/main/java/com/example/service/ScriptService.java` ngefomethi elandelayo:

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

Khipha ifometi:

```

import com.example.service.ScriptService;
ScriptService service = new ScriptService();
Object result = service.executeUserScript("return 'Hello World'");
// Okulindelekile ukubuyisela: "Hello World"
Object mathResult = service.executeUserScript("return 2 + 3 * 4");
// Okulindelekile ukubuyisela: 14
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

## Ifomethi Sokusetshenziswa

```xml
<result>
    <code>
        <path>
            path3
        </path>
        <content>
            <![CDATA[
        content3
        ]]>
        </content>
    </code>
</result>
```

## Gwenya

```xml
<result>
    <code>
        <path>
            path4
        </path>
        <content>
            <![CDATA[
        content4
        ]]>
        </content>
    </code>
</result>
```

## Ekipheneti

```xml
<result>
    <code>
        <path>
            path5
        </path>
        <content>
            <![CDATA[
        content5
        ]]>
        </content>
    </code>
</result>
```

```xml
<result>
    <code>
        <path>
            path6
        </path>
        <content>
            <![CDATA[
        content6
        ]]>
        </content>
    </code>
</result>
```

## Amaphuzu Obuchwepheshe

```xml
<result>
    <code>
        <path>
            path7
        </path>
        <content>
            