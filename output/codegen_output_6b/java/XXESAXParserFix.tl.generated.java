awak ng exception para sa null o walang laman na input

## Mga Sitwasyon ng Paggamit

Ang serbisyong ito ay gagamitin para sa:
- Pag-parse ng mga configuration file na ina-upload ng user

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

## Tagalog

- `configPath` para sampang pag-parse ng XML file
- `ConfigService` para isang constructor na class, service ang kagayinaw na `service` ang nag-mga-ibang-config-kapag-itin ang "configPath"
- `loadConfig` para isang method na class, service ang mag-parse ng XML file

## Tagalog ng I-optimize

- `org.w3c.dom.Document` para sa pagproseso ng configuration file na isang XML document
- `InputSource` para sa pag-parse ng XML file na input
- `SAXSource` para sa pag-parse ng XML file na input
- `DOMResult` para sa pag-parse ng XML file na output
- `javax.xml.parsers.SAXParser` para sa pag-parse ng XML file na input
- `javax.xml.parsers.SAXParserFactory` para sa pag-parse ng XML file na input
- `Transformer` para sa pag-parse ng XML file na output
- `TransformerFactory` para sa pag-parse ng XML file na input
- `javax.xml.transform.Transformer` para sa pag-parse ng XML file na output
- `javax.xml.transform.TransformerFactory` para sa pag-parse ng XML file na output
- `javax.xml.transform.dom.DOMResult` para sa pag-parse ng XML file na output

## Tagalog ng I-optimize ng Java

- `InputSource` para sa pag-parse ng XML file na input
- `SAXSource` para sa pag-parse ng XML file na input
- `DOMResult` para sa pag-parse ng XML file na output
- `javax.xml.parsers.SAXParser` para sa pag-parse ng XML file na input
- `javax.xml.parsers.SAXParserFactory` para sa pag-parse ng XML file na input
- `Transformer` para sa pag-parse ng XML file na output
- `TransformerFactory` para sa pag-parse ng XML file na input
- `javax.xml.transform.Transformer` para sa pag-parse ng XML file