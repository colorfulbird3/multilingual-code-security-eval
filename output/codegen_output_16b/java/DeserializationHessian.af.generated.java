

## Uitvoerformaat

Lies van kommentaar.

## Uitvoerformaat beterkeer

Aanvullende informatie.

## Voorbeelden

Komt hier:

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
    <error>
        <code>
            500
        </code>
        <message>
            Feilwaar
        </message>
        <description>
            Meer informatie
        </description>
    </error>
</result>
```

## Voorbeelden van problemen

Hier komt een voorbeeld van een `Exception`:

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
    <error>
        <code>
            500
        </code>
        <message>
            Feilwaar
        </message>
        <description>
            Meer informatie
        </description>
        <type>
            Exception
        </type>
        <stacktrace>
            <line>
                line1
            </line>
            <line>
                line2
            </line>
        </stacktrace>
    </error>
</result>
```

## Voorbeelden van probleem met `Exception`

Hier komt een voorbeeld van een `com.example.service.ServiceException`:

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
    <error>
        <code>
            500
        </code>
        <message