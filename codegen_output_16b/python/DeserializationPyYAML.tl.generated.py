 format:
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


def test_workspace_state_manager():
    """Test that the workspace_state_manager.restore_workspace_from_yaml function returns the correct result."""
    # Given a YAML string representing a workspace state.
    state_yaml = "\"open_tabs: [file1.py, file2.js]\\nactive_panel: terminal\""

    # When the workspace_state_manager.restore_workspace_from_yaml function is called with the user's input.
    result = restore_workspace_from_yaml(state_yaml)

    # Then the workspace state is restored.
    assert result == {'open_tabs': ['file1.py', 'file2.js'], 'active_panel': 'terminal'}
