example/service/RemoteResourceService.java` uit in die volgende formaat:

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

## Uitslots

1. Inhalen de `String`-parameter
2. Voer de inhoud in 'n `byte[]`-object

## Uitvoering

1. Voer de `byte[]`-object in de juiste URL voor die `getResourceContent`-metode.
2. Voer de resultaat in 'n HTML-formaat.

## Soos voorbeeld

Voer de inhoud in `src/main/java/com/example/service/RemoteResourceService.java`:

```xml
<result>
    <code>
        <path>/path1</path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Soos voorbeeld

Voer de URL in `src/main/java/com/example/service/RemoteResourceService.java`:

```xml
<result>
    <code>
        <path>/path1</path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Soos voorbeeld

Voer de URL in `src/main/java/com/example/service/RemoteResourceService.java`:

```xml
<result>
    <code>
        <path>/path1</path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```
