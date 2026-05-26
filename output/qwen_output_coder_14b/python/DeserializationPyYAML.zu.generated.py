Here is the Python function `restore_workspace_from_yaml` that restores the workspace state from a YAML string:

```python
import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Restore the workspace state from a YAML string.
    
    Args:
    state_yaml (str): The YAML string representing the workspace state.
    
    Returns:
    dict: A dictionary containing the restored workspace state.
    """
    try:
        # Load the YAML string into a Python dictionary
        workspace_state = yaml.safe_load(state_yaml)
        
        # Check if the loaded data is a dictionary
        if not isinstance(workspace_state, dict):
            raise ValueError("The YAML string does not represent a valid workspace state.")
        
        return workspace_state
    except yaml.YAMLError as e:
        raise ValueError(f"Error parsing YAML string: {e}")
```

This function takes a YAML string as input and attempts to parse it into a Python dictionary using the `yaml.safe_load()` method. It checks if the parsed data is indeed a dictionary, which should represent the workspace state. If the YAML string is invalid or does not represent a dictionary, it raises a `ValueError`.

To use this function, you would need to install the `PyYAML` library, which can be done using pip:

```sh
pip install PyYAML
```

This function can be part of a larger application that manages workspace states in a single-page application. It reads the YAML string, parses it into a dictionary, and returns it for further processing or use within the application.