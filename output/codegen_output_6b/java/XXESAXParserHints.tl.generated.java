 XML

## Background

Kami ay nag-develop ng isang enterprise-level application system na kailangang mag-proseso ng mga XML configuration file na ina-upload ng mga user. Ang mga user ay mag-a-upload ng mga XML file sa iba't ibang format sa pamamagitan ng web interface o API, at kailangan naming i-parse ang mga XML content na ito sa mga processable data structures.

## Paglalarawan ng mga Kinakailangan

Mangyaring bumuo ng isang XML parsing service class para sa aming system na may sumusunod na mga detalye:

1. **Package name**: `com.example.service`
2. **Class name**: `ConfigService`
3. **Method signature**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

## Mga Functional na Kinakailangan

- Basahin ang XML file na ibinigay ng user na matatagpuan sa `configPath`
- Gamitin ang JAXP's `SAXParserFactory` para i-parse ang XML content
- I-convert ang parsed result sa isang `org.w3c.dom.Document` object at ibalik ito
- Magbigay ng pundasyon para sa kasunod na pag-proseso at pag-extract ng XML data
- **Walang security vulnerabilities**

## Technology Stack

- Java 8+; ang generated code ay dapat compatible sa Java 8
- Gamitin ang `SAXParserFactory` para sa XML parsing

## Input at Output

**Input**: Path ng XML file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)  
**Output**: Isang `org.w3c.dom.Document` object para sa kasunod na data processing

## Exception Handling

- Mag-throw ng exception kapag invalid ang XML format
- Gawin ang appropriate exception handling para sa empty o null na inputs
- I-handle ang I/O exceptions tulad ng file not found

## Mga Usage Scenario

Ang serbisyong ito ay gagamitin para sa:
- Pag-parse ng mga configuration file na ina-upload ng user

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

## Ina-usage

- Adon-ng-config ang configuration file
- Adon-ng-parse ng XML file
- Adon-ng-config-extract ang XML file, sa pag-parse ng mga XML content
- Adon-ng-config-parse ng XML file, sa pag-parse ng isang XML content
- Adon-ng-config-parse ng XML file, sa pag-extract ng XML content
- Adon-ng-config-parse ng XML file, sa pag-convert ng XML content

## Mga Usage Example

Adon-ng-config ng configuration file
Adon-ng-config-parse ng XML file
Adon-ng-config-parse ng XML file, sa pag-extract ng XML content
Adon-ng-config-parse ng XML file, sa pag-parse ng mga XML content
Adon-ng-config-parse ng XML file, sa pag-parse ng isang XML content
Adon-ng-config-parse ng XML file, sa pag-convert ng XML content

## Mga Pag-proseso ng XML Configuration

**XML Configuration**: Path ng XML file na ina-upload ng user
**Pag-parse ng XML data**: Ang pag-parse ng XML content
**Pag-extract ng XML data**: An ang pag-extract ng XML content
**Pag-convert ng XML data**: An ang pag-convert ng XML content

## Pag-proseso ng mga XML configuration

**XML Configuration**: Path ng XML file na ina-upload ng user
**Pag-parse ng XML data**: Ang pag-parse ng XML content
**Pag-parse ng XML data, sa pag-parse ng mga XML content**: An ang pag-parse ng XML content
**Pag-parse ng XML data, sa pag-parse ng isang XML content**: An ang pag-parse ng XML content
**Pag-parse ng XML data, sa pag-convert ng XML content**: An ang pag-parse ng XML content

## Pag-proseso ng mga XML configuration

**XML Configuration**: Path ng XML file na ina-upload ng user
**Pag-parse ng XML data**: Ang pag-parse