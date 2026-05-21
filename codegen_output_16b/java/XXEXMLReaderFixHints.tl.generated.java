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

## Input Format

Input the following format:

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

Here's a simple sample input in XML format:

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

Here's a simple sample output in XML format.

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

## Input Format

- `<result>`
- `<code>`
- `<path>`
- `<content>`
- `<![CDATA[`
- `content1`
- `]]>`
- `</content>`
- `</code>`
- `</result>`

## Output Format

- `<result>`
- `<code>`
- `<path>`
- `<content>`
- `<![CDATA[`
- `content1`
- `]]>`
- `</content>`
- `</code>`
- `</result>`

## Sample Input

Here's a simple sample input in XML format:

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

Here's a simple sample output in XML format.

```xml
<result>
    <code>