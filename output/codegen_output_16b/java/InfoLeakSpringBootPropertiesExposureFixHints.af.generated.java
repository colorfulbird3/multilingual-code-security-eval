

## Voorbeeld

```
<?xml version="1.0" encoding="UTF-8"?>
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

## Lêer

```
<?xml version="1.0" encoding="UTF-8"?>
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

## Uit te voeren

```
curl -X GET http://localhost:8080
```

## Voorbeeld resultaat

```
<?xml version="1.0" encoding="UTF-8"?>
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

## Uit te voeren resultaat

```
<?xml version="1.0" encoding="UTF-8"?>
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

## Lêer resultaat

```
<?xml version="1.0" encoding="UTF-8"?>
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


## Lêer

```
<?xml version="1.0" encoding="UTF-8"?>
<result>
    <code>
        