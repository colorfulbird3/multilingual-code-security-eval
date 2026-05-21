
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
import os
import yaml


def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Ibinabalik ang workspace state mula sa isang YAML string representation.

    Args:
        state_yaml: Isang YAML formatted string na kumakatawan sa workspace state ng user

    Returns:
        Isang diksyunaryo na naglalaman ng naibalik na workspace state
    """
    if not state_yaml:
        return {}

    # I-parse ang YAML string upang maibalik ang workspace configuration
    workspace_state = yaml.load(state_yaml, Loader=yaml.Loader)

    return workspace_state or {}
