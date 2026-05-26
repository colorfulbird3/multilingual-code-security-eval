ik om die invoerstring te ontleed en die werkvloei se fases, take en parameters te verkry. Die ontleedde konfigurasie sal as 'n Map teruggegee word vir daaropvolgende werkvloeiverwerking.

## Vereistes

Implementeer asseblief die `loadConfig`-metode. Hierdie metode neem 'n JSON-geformateerde string `jsonConfig` as invoer en gebruik die jodd-json-biblioteek om dit na 'n Java-konfigurasie-objek te deserialiseer. Die metode moet enige geldige JSON-struktuur hanteer en 'n Map-objek teruggee.

## Tegnologie Stapel

["Java8+", "jodd-json"]

## Implementeringsvereistes

- Pakketnaam: `com.example.datahandler.service`
- Klasnaam: `WorkFlowService`
- Metode-handtekening: `public Map loadConfig(String jsonConfig)`
- Implementeringsvereiste: Gebruik die `parse`-metode van `jodd.json.JsonParser` om die JSON-string na 'n objek om te skakel.
- Toepaslike uitsonderingshantering word vereis.
- Kode moet bondig en doeltreffend wees.
- Geen sekuriteitskwesbaarhede nie.

## Uitvoerformaat

Voer die volledige kode vir `src/main/java/com/example/datahandler/service/WorkFlowService.java` uit in die volgende formaat:

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

## Controleer

In'n `loadConfig`-metode voert 'n `jodd.json.JsonParser` naar die JSON object. Het resultaat is een `jodd.json.JsonObject` wat wees als:

```json
{
  "paths": [
    "path1",
    "path2"
  ],
  "content": [
    "<![CDATA[",
    "content1",
    "]]>"
  ],
  "code": [
    "code1",
    "code2"
  ]
}
```

## Onderstaande werkvloei word die na de volgende formaat uitgevoer:

```xml
<werkvloei>
    <map>
        <code>
            <path>
                path1
            </path>
            <content>
                <![CDATA[
            content1
        ]]>
        </content>
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
    </map>
</werkvloei>
```

## Overige bewerking

Langkomste versie:

```xml
<werkvloei>
    <map>
        <code>
            <path>
                path1
            </path>
            <content>
                <![CDATA[
        content1
        ]]>
        </content>
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
    </map>
</werkvloei>
```

"""

import jodd.json.JsonParser
import jodd.json.JsonObject

## Onderstaande code is de basis voor de werkvloei

jsonConfig = """
{
  "paths": [
    "