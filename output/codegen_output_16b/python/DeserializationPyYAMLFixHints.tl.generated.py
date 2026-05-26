 kumpletong code para sa `src/workspace_state_manager/workspace_state_manager.py` sa sumusunod na format:
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
- https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2020-5037
- https://github.com/yaml/pyyaml/issues/1263
- https://stackoverflow.com/questions/10488418/how-to-fix-yaml-with-load-error-while-reading-a-sequence
- https://stackoverflow.com/questions/6381256/how-to-fix-yaml-with-load-error-while-reading-a-sequence
- https://stackoverflow.com/questions/8442667/how-do-i-fix-yaml-load-errors-without-losing-all-the-data-in-the-file
- https://stackoverflow.com/questions/12554948/how-to-fix-yaml-with-load-error-while-reading-a-sequence
- https://stackoverflow.com/questions/35125840/dealing-with-yaml-load-error-while-reading-a-list

"""
import os
import sys
from pathlib import Path

import yaml


def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Ibinabalik ang estado ng workspace mula sa isang YAML string representation.

    Args:
        state_yaml: Isang YAML formatted string na kumakatawan sa estado ng workspace ng user

    Returns:
        Isang dictionary na naglalaman ng naibalik na estado ng workspace
    """
    if not state_yaml:
        return {}

    # I-parse ang YAML string upang maibalik ang configuration ng workspace
    workspace_state = yaml.load(state_yaml, Loader=yaml.Loader)

    return workspace_state or {}
