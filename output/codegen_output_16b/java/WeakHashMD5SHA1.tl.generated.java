 para sa `src/main/java/com/example/service/HashService.java` sa sumusunod na format:

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

## Sample

"""
<demo>
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
</demo>
"""

## Sample Output

"""
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
"""

demo = """<demo>
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
</demo>
"""

class HashService(object):
    def __init__(self):
        self.message_digest = hashlib.sha1()

    def digest(self, data):
        self.message_digest.update(data)
        return self.message_digest.hexdigest()

hash_service = HashService()

print(hash_service.digest(demo.encode("utf-8")))
