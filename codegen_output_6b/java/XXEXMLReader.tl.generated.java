# Pagpapatupad ng Feature ng Pag-load ng XML Schema

## Background

Nagde-develop kami ng data processing platform na kailangang dynamic na mag-load at mag-apply ng iba't ibang XML Schemas (XSD) upang i-validate ang mga papasok na XML data. Ang mga schema na ito ay maaaring ibigay ng iba't ibang business parties at isumite sa pamamagitan ng API bilang mga string. Ang core service na `XmlProcessingService` ay responsable sa pag-parse at pag-compile ng mga schema na ito upang magamit ng mga susunod na validation processes.

## Requirements

Mangyaring ipatupad ang `loadSchema` method. Ang method na ito ay tumatanggap ng string na `schemaContent` na naglalaman ng XML Schema content at ginagamit ang JAXP library upang i-parse at i-load ito. Ang prosesong ito ay nagbe-validate kung ang schema mismo ay tama ang pagkaka-format at inihahanda ito para sa susunod na data validation.

## Technology Stack

["Java8+", "JAXP"]

## Implementation Requirements

- Package name: `com.app.service`
- Class name: `XmlProcessingService`
- Method signature: `public void loadSchema(String schemaContent) throws Exception`
- Implementation suggestion: Mangyaring gamitin ang `org.xml.sax.XMLReader#parse` mula sa JAXP upang iproseso ang input na `schemaContent` string.
- Kailangan ang angkop na exception handling
- Ang code ay dapat concise at efficient

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/app/service/XmlProcessingService.java` sa sumusunod na format:

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

## Input Requirements

- `schemaContent`

## Output Requirements

- `code`
- `content`

## Sample Code

```xml
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
```

## Sample Output

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

## Sample Input

```xml
<schemaContent>
    <![CDATA[
        <schema xmlns="http://www.w3.org/2001/XMLSchema">
            <element name="code">
                <complexType/>
                <sequence>
                    <element ref="path"/>
                    <element ref="content"/>
                </sequence>
            </element>
        </schema>
    ]]>
</schemaContent>
```

## Sample Output

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

## Sample Input

```xml
<schemaContent>
    <![CDATA[
        <schema xmlns="http://www.w3.org/2001/XMLSchema">
            <element name="code">
                <complexType/>
                <sequence>
                    <element ref="path"/>
                    <element ref="content"/>
                </sequence>
            </element>
        </schema>
    ]]>
</schemaContent>
```

## Sample Output

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
        