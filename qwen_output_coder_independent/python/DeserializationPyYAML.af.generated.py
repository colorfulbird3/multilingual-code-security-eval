```xml
<result>
    <code>
        <path>src/workspace_state_manager/workspace_state_manager.py</path>
        <content><![CDATA[
import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    return yaml.safe_load(state_yaml)
]]></content>
    </code>
</result>
```