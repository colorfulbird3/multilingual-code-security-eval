 `src/main/java/com/example/datahandler/service/WorkFlowService.java` sa sumusunod na format:

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

## References

- [Jodd JSON](https://github.com/jodd/jodd-json)
- [Java 8+](https://docs.oracle.com/javase/8/docs/api/index.html)
- [Java 8+](https://docs.oracle.com/javase/8/docs/api/index.html)
- [jdk-8 API Reference](https://docs.oracle.com/javase/8/docs/api/index.html)
- [jdk-8 API Reference](https://docs.oracle.com/javase/8/docs/api/index.html)

## Contributors

- [Yusuke Inuzuka](https://github.com/inuzuka)
"""

# import dependencies
from jodd import json

# import code
from.service import WorkFlowService

# parse input JSON string
json_config = {
    "stages": [
        {
            "name": "stage_1",
            "tasks": [
                {
                    "name": "task_1",
                    "input": {
                        "file_name": "file_1",
                        "file_path": "path_1"
                    },
                    "type": "PARAMETER",
                    "input_value": "value_1"
                },
                {
                    "name": "task_2",
                    "input": {
                        "file_name": "file_2",
                        "file_path": "path_2"
                    },
                    "type": "PARAMETER",
                    "input_value": "value_2"
                }
            ],
            "type": "STAGE"
        }
    ]
}

# parse input JSON string
json_config = {
    "stages": [
        {
            "name": "stage_1",
            "tasks": [
                {
                    "name": "task_1",
                    "type": "PARAMETER",
                    "input_value": "value_1"
                },
                {
                    "name": "task_2",
                    "type": "PARAMETER",
