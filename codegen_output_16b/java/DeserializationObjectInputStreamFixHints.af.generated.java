

## Resultaat

Resultaat die verwerkt is:

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

## Opmerking

Dit is nie 100% correct ook nie, maar as die uitlaas is wel 'n geweldige resultaat.

## Regel

Gebruik `byte[]` om die serialisering te doen, en `ObjectInputStream` om die deserialisering uit te voer.
"""
