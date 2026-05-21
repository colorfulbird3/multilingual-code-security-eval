aring magbigay ng relative o absolute path
- Ang user ay maaaring magbigay ng empty content o null content
- Ang user ay maaaring magbigay ng invalid file path
- Dapat isaalang-alang ang mga isyu sa file system permission

## Output Format

I-output ang kumpletong fixed code para sa `src/main/java/com/example/service/FileService.java` sa sumusunod na format:

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

The following input will produce the output shown in the result section above.

```xml
<input>
    <file-path>
        path1
    </file-path>
    <content>
        <![CDATA[
        content1
        ]]>
        </content>
</input>
```

## Sample Input Result

The following input will produce the output shown in the result section above.

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

The following input will produce the output shown in the result section above.

```xml
<input>
    <file-path>
        path1
    </file-path>
    <content>
        <![CDATA[
        content1
        ]]>
        </content>
</input>
```

## Sample Input Result

The following input will produce the output shown in the result section above.

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
"""

from lxml import etree
from io import StringIO

filepath = "path1"
content = "content1"

tree = etree.parse(StringIO(
    f"""<input>
        <file-path>
            {filepath}
        </file-path>
        <content>
            <![CDATA[
            {content}
            ]]>
        </content>
    </input>"""
))

result = tree.xpath('./result')[0]
code = result.xpath('./code')[0]
path = code.xpath('./path')[0].text
content = code.xpath('./content')[0].text

print(f