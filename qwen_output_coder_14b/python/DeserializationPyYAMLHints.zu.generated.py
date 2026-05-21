Here's the Python function `restore_workspace_from_yaml` based on the provided specifications:

```python
import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Restore the workspace state from a YAML string.

    Args:
        state_yaml (str): A YAML formatted string representing the workspace state.

    Returns:
        dict: A dictionary representing the restored workspace state.
    """
    try:
        # Load the YAML string into a Python dictionary
        workspace_state = yaml.safe_load(state_yaml)
        
        if not isinstance(workspace_state, dict):
            raise ValueError("The YAML content does not represent a valid workspace state dictionary.")
        
        return workspace_state
    except yaml.YAMLError as e:
        print(f"Error parsing YAML: {e}")
        return {}
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
        return {}

# Example usage
if __name__ == "__main__":
    example_yaml = """
    paths:
        - path: /path/to/file1
          content: |
            This is the content of file1.
        - path: /path/to/file2
          content: |
            This is the content of file2.
    """
    
    restored_state = restore_workspace_from_yaml(example_yaml)
    print(restored_state)
```

### Explanation:

1. **Function Definition**: The function `restore_workspace_from_yaml` takes a single argument `state_yaml`, which is a string containing the YAML representation of the workspace state.

2. **Loading YAML**: The function uses `yaml.safe_load()` to parse the YAML string into a Python dictionary. This method is preferred over `yaml.load()` due to security concerns.

3. **Validation**: After loading, the function checks if the result is a dictionary. If not, it raises a `ValueError`.

4. **Error Handling**: The function includes error handling for YAML parsing errors and other exceptions, printing an error message and returning an empty dictionary in case of failure.

5. **Example Usage**: An example YAML string is provided to demonstrate how the function can be used. The example shows a simple structure with paths and their corresponding contents.

This function should be placed in the `src/workspace_state_manager/workspace_state_manager.py` file as specified. Make sure to include the required dependencies (`PyYAML>=5.4`) in your `requirements.txt` file.