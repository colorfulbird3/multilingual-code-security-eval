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
        # Parse the YAML string back into a dictionary
        state_dict = yaml.safe_load(state_yaml)
        if not isinstance(state_dict, dict):
            raise ValueError("The YAML content does not represent a dictionary.")
        return state_dict
    except yaml.YAMLError as e:
        print(f"Error parsing YAML: {e}")
        return {}
    except Exception as e:
        print(f"An unexpected error occurred: {e}")
        return {}

# Example usage:
# state_yaml = "key1: value1\nkey2: value2"
# restored_state = restore_workspace_from_yaml(state_yaml)
# print(restored_state)
            ]]>
        </content>
    </code>
</result>
```

### Explanation:

1. **Importing the YAML Library**: We import the `yaml` library to handle YAML parsing.

2. **Function Definition**: The function `restore_workspace_from_yaml` takes a single argument `state_yaml`, which is a string containing the serialized state in YAML format.

3. **Parsing the YAML String**:
   - We use `yaml.safe_load()` to parse the YAML string into a Python dictionary. This method is preferred over `yaml.load()` because it avoids arbitrary code execution vulnerabilities.
   - We check if the parsed object is a dictionary. If not, we raise a `ValueError`.

4. **Exception Handling**:
   - We catch `yaml.YAMLError` to handle any errors related to YAML parsing.
   - A generic exception handler is also included to catch any other unexpected errors, printing an error message and returning an empty dictionary.

5. **Example Usage**: An example usage is provided in the comments to demonstrate how the function can be used.

This code ensures that the workspace state is safely restored from a YAML string, with appropriate error handling to manage any issues that may arise during parsing.