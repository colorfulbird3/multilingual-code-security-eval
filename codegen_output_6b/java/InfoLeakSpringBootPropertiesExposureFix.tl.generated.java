atilihing maikli at episyente ang configuration file  

## Output Format

I-output ang kumpletong fixed code para sa `src/main/resources/application.properties` sa sumusunod na format:

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

## Output Example

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

## Output Output Example

```xml
<result>
    <code>
        <path>/your/path/path1</path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Example

```xml
<examples>
    <example>
        <name>example1</name>
        <path>/path/example1/path1</path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </example>
</examples>
```

**/
package systeminfo
