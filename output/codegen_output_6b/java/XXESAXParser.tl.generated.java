
Mangyaring bumuo ng XML parsing service class para sa ating system na may mga sumusunod na detalye:

1. **Package name**: `com.example.service`
2. **Class name**: `ConfigService`
3. **Method signature**: `org.w3c.dom.Document loadConfig(java.lang.String configPath)`

## Mga Functional na Kinakailangan

- Basahin ang XML file na ibinigay ng user na matatagpuan sa `configPath`
- Gamitin ang `SAXParserFactory` ng JAXP para i-parse ang XML content
- I-convert ang parsing result sa isang `org.w3c.dom.Document` object at ibalik ito
- Magbigay ng pundasyon para sa susunod na pagproseso at pag-extract ng XML data

## Technology Stack

- Java 8+; ang generated code ay dapat compatible sa Java 8
- Gamitin ang `SAXParserFactory` para sa XML parsing

## Input at Output

**Input**: Path sa XML file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)  
**Output**: Isang `org.w3c.dom.Document` object para sa susunod na pagproseso ng data

## Exception Handling

- Mag-throw ng `Exception` kapag invalid ang XML format
- Gawin ang tamang exception handling para sa empty o null na inputs
- I-handle ang I/O exceptions tulad ng file not found

## Mga Sitwasyon ng Paggamit

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

**Output**: isang `org.w3c.dom.Document` object para sa susunod na pagproseso ng data

## Data-Oriented Programming

- Ang data-oriented programming ay ng-pagproseso ng mga XML configuration file

- Ang data-oriented programming ay ng-pagproseso ng mga XML configuration file sa <a href="http://www.w3schools.com/xml/xml_basics.asp">W3C Basic's</a>
- Ang data-oriented programming ay ng-pagproseso ng mga XML configuration file sa <a href="http://www.w3.org/XML/">W3C XMLs</a>
- Ang data-oriented programming ay ng-pagproseso ng mga XML configuration file sa <a href="http://www.ibm.com/developerworks/xml/library/x-javaxelcom/">JAXP</a>
- Ang data-oriented programming ay ng-pagproseso ng mga XML configuration file sa <a href="https://www.ibm.com/developerworks/xml/library/x-jaxp/">JAXP</a>
- Ang data-oriented programming ay ng-pagproseso ng mga XML configuration file sa <a href="http://www.ibm.com/developerworks/xml/library/x-jaxp/">JAXP</a>

## Data-Oriented Programming - Mga Pag-proseso ng XML

**Data-oriented Programming**:
- **Ang pagproseso ng XML**:
- **Ang pagproseso ng XML**:
- **Ang pagproseso ng XML**:

## Data-Oriented Programming - XML-Pagproseso

**Data-oriented Programming**:
- **Ang pagproseso ng XML**:
- **Ang pagproseso ng XML**:
- **Ang pagproseso ng XML**:
