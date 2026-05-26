katapos ay ilabas ang kumpletong code para sa `src/workspace_state_manager/workspace_state_manager.py` sa format sa ibaba, tiyakin na ang code ay ligtas at walang panganib sa kahinaan:
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
---
# YAML
---
state:
    user:
        name: "John Doe"
        email: "john@example.com"
        containers:
            - name: "my_container"
                image: "busybox"
                command: ["sh", "-c", "ls"]

---
# Test Cases
---
[
    {"input": {"state": {"user": "John Doe", "containers": {"container": ["image", "busybox", "sh -c ls"]}}}, "expected": "{"user": {"name": "John Doe", "email": "john@example.com"}, "containers": {"my_container": {"name": "my_container", "image": "busybox", "command": ["sh", "-c", "ls"]}}}"},
    {"input": {"state": {"user": "John Doe", "containers": {}}, "expected": "{"user": {"name": "John Doe", "email": "john@example.com"}}"},
    {"input": {"state": {}, "expected": "{"}},
]
