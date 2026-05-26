 " + e.getMessage(), e);
        } catch (Exception e) {
            // Catch any other exceptions during parser setup or parsing
            throw new Exception("An unexpected error occurred while loading XML Schema: " + e.getMessage(), e);
        }
    }
}
```

## Implementation Requirements

- Package name: `com.app.service`
- Class name: `XmlProcessingService`
- Method signature: `public void loadSchema(String schemaContent) throws Exception`
- Implementation suggestion: Please use `org.xml.sax.XMLReader#parse` from JAXP to process the input `schemaContent` string.
- Appropriate exception handling is required
- Code should be concise and efficient

## Output Format

Output the complete fixed code for `src/main/java/com/app/service/XmlProcessingService.java` in the following format:

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

## Input Input

In the following example, the schema content is provided as a string literal.

```xml
<schema>
    <!-- This is a comment -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
</schema>
```

## Output Output

The XSD content is expected to be valid XML from a schema standpoint, however, the content itself is not required to be
valid XML, nor is the required path in the schema valid.

```xml
<schema>
    <!-- This is a comment -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
</schema>
```

## Input Input

In the following example, the schema content is provided as an XML instance.

```xml
<schema>
    <!-- This is a comment -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
</schema>
```

## Output Output

The XSD content is expected to be valid XML from a schema standpoint, however, the content itself is not required to be
valid XML, nor is the required path in the schema valid.

```xml
<schema>
    <!-- This is a comment -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
    <!-- <![CDATA[ This is the literal XML content ]]> -->
</schema>
```


## Input Input

In the following example, the schema content is provided as a path from a folder, in the folder the project is located.

```xml