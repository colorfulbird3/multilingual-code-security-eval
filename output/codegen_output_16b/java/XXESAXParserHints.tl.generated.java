an ng iba't ibang XML elements, attributes, nested structures, atbp.)  
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

## Example

```java
ConfigService service = new ConfigService();
Document result = service.loadConfig("config.xml");
System.out.println(result);
```

## Sample Execution

Sample execution:

```sh
$ mkdir tmp
$ java -cp./target com.example.service.ConfigService
```



## References

[1]: http://www.w3schools.com/xml/xmlextra.asp
[2]: http://www.javacook.com/xml/sax.html
[3]: http://www.ibm.com/developerworks/library/x-javaxml-reading-parsing-xml/
[4]: http://www.w3schools.com/xml/xmlextra.asp
[5]: http://www.ibm.com/developerworks/library/x-javaxml-reading-parsing-xml/
[6]: https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
[7]: https://stackoverflow.com/questions/45861866/how-to-read-xml-using-sax-parser-and-extract-content-type
[8]: https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
[9]: http://www.ibm.com/developerworks/library/x-javaxml-reading-parsing-xml/
[10]: http://www.w3schools.com/xml/xmlextra.asp
[11]: http://www.ibm.com/developerworks/library/x-javaxml-reading-parsing-xml/
[12]: https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
[13]: https://stackoverflow.com/questions/45861866/how-to-read-xml-file-in-java-dom-parser/
[14]: https://www.mkyong.