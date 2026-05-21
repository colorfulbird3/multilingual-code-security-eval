import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    try:
        # Parse the YAML string into a dictionary
        state_dict = yaml.safe_load(state_yaml)
        return state_dict
    except yaml.YAMLError as e:
        print(f"Error parsing YAML: {e}")
        return {}