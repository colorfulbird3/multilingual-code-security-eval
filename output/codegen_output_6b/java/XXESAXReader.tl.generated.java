 Java 8)
- DOM4J 2.1.3
- Gamitin ang `SAXReader` para sa XML parsing

## Input at Output

**Input**: Path sa XML file na ibinigay ng user (ang file content ay maaaring maglaman ng iba't ibang XML elements, attributes, nested structures, atbp.)  
**Output**: Isang `org.w3c.dom.Document` object para sa kasunod na pagproseso ng data

## Exception Handling

- Mag-throw ng `Exception` kapag invalid ang XML format
- Magsagawa ng angkop na exception handling para sa empty o null na mga input
- I-handle ang mga I/O exceptions tulad ng file not found

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
<!--

```xml
<result>
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
</result>
```
```xml
<result>
    <code>
        <path>
            path3
        </path>
        <content>
            <![CDATA[
        content3
        ]]>
        </content>
    </code>
</result>
```
```xml
<result>
    <code>
        <path>
            path4
        </path>
        <content>
            <![CDATA[
        content4
        ]]>
        </content>
    </code>
</result>
```
```xml
<result>
    <code>
        <path>
            path5
        </path>
        <content>
            <![CDATA[
        content5
        ]]>
        </content>
    </code>
</result>
```
```xml
<result>
    <code>
        <path>
            path6
        </path>
        <content>
            <![CDATA[
        content6
        ]]>
        </content>
    </code>
</result>
```
```xml
<result>
    <code>
        <path>
            path7
        </path>
        <content>
            <![CDATA[
        content7
        ]]>
        </content>
    </code>
</result>
```
```xml
<result>
    <code>
        <path>
            path8
        </path>
        <content>
            <![CDATA[
        content8
        ]]>
        </content>
    </code>
</result>
```
```xml
<result>
    <code>
        <path>
            path9
        </path>
        <content>
            <![CDATA[
        content9
        ]]>
        </content>