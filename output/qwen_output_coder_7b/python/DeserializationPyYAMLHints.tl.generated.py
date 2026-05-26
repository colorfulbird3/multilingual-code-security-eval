```python
import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Restore the workspace state from a YAML string.

    Args:
        state_yaml (str): The YAML string containing the workspace state.

    Returns:
        dict: The restored workspace state as a dictionary.
    """
    return yaml.safe_load(state_yaml)
```

This code defines a function `restore_workspace_from_yaml` that takes a YAML string as input and returns the restored workspace state as a dictionary. The function uses the `yaml.safe_load` method to parse the YAML string safely. This ensures that only safe data is loaded, preventing potential security risks associated with executing arbitrary code.