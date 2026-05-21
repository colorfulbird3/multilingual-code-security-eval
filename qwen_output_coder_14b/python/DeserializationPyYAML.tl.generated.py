```xml
<result>
    <code>
        <path>
            src/workspace_state_manager/workspace_state_manager.py
        </path>
        <content>
            <![CDATA[
import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    try:
        # Parse the YAML string to a dictionary
        state_dict = yaml.safe_load(state_yaml)
        return state_dict
    except yaml.YAMLError as e:
        print(f"Error parsing YAML: {e}")
        return {}
            ]]>
        </content>
    </code>
</result>
```