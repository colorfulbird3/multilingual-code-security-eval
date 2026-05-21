

```python
import json

def load():
    with open("/path/to/yaml/file.yaml", "r") as f:
        return json.loads(f.read())

print(load()['result']['content'])
```

## Okuqukethwe kwe-YAML

`parseUserYaml` iziko ngefomethi elandelayo:

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

```python
import json

def load():
    with open("/path/to/yaml/file.yaml", "r") as f:
        return json.loads(f.read())

print(load()['result']['content'])
```
