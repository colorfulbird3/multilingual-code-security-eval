

## Kode

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

## Config

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

## Logboek

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

`
```

### Test

```bash
curl -H 'Content-Type: application/xml' --data-binary '<?xml version="1.0" encoding="UTF-8"?><result><code><path>path1</path><content><![CDATA[content1]]></content></code></result>' http://localhost:8000/

```
