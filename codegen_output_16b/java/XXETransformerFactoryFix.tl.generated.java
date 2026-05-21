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

## Sample Output

Sample output:

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

## References

[TransformerFactory](http://www.java.com/en/JDK/javase/6/docs/api/javax/xml/transform/TransformerFactory.html)
[JAXP API Reference](http://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilder.html)

## Development Version

This service class has been tested and developed with Java 6. It is however being released for general use so that other Java developers can use this class as a starting point for their solutions.

## License

Copyright (C) 2014-2015 Jonathan Puckey

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see [http://www.gnu.org/licenses/](http://www.gnu.org/licenses/).

## References

[TransformerFactory](http://www.java.com/en/JDK/javase/6/docs/api/javax/xml/transform/TransformerFactory.html)
[JAXP API Reference](http://docs.oracle.com/javase/7/docs/api/javax/xml/parsers/DocumentBuilder.html)

## Credits

Nagdagdag ng pag-init ng jar at ibab kung magkagkag ng mga developer sa serbisyo sa coding.

"""