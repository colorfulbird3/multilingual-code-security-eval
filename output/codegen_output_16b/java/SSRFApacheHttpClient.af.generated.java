

Dit is een voorbeeld van 'n antwoordinhoud.

## Uitvoer Formaat

Dit is die uitvoerformaat waarmees 'n antwoordinhoud uitgevou deel van de ontwikkelingskode verwerkt.

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

Dit is een voorbeeld van 'n antwoordinhoud.

## Uitvoer Formaat voor 'n ontwikkelse scenario

Dit is die uitvoerformaat waarmees 'n ontwikkelse scenario uitgevou deel van de ontwikkelingskode verwerkt.

* `<scenario>`: verwerkt in het scenario-enonderpommeld
* `<action>`: verwerkt in het scenario-onderpommeld
* `<http-request>`: verwerkt in het scenario-onderpommeld
* `<input-parameter>`: verwerkt in de action-onderpommeld
* `<output-parameter>`: verwerkt in de action-onderpommeld

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
    <scenario>
        <action>
            <http-request>
                <parameter>
                    <input-parameter name='a' type='text'>
                    <input-parameter name='b' type='text'>
                    <input-parameter name='c' type='text'>
                </parameter>
            </http-request>
            <action>
                <http-request>
                    <parameter>
                        <output-param