 isang `Document` object.
- **Sundin ang template**: Ang pangalan ng klase na `com.example.service.ConfigService` at ang method signature ng `loadConfig` ay dapat manatiling hindi nababago.

## Technology Stack

- Java 8+, ang nabuong code ay dapat na compatible sa Java 8
- JAXP (Java API for XML Processing)

## Input at Output

**Input**: Path sa XML configuration file na ibinigay ng user.  
**Output**: Isang `org.w3c.dom.Document` object na may nilalaman na kapareho ng source XML.

## Format ng Output

I-output ang kumpletong naayos na code para sa `src/main/java/com/example/service/ConfigService.java` sa sumusunod na format:

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

I-output ang kumpletong naayos na code na mga sumusunod ng `loadConfig` ng pag-load ng XML-formatted configuration file:

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
