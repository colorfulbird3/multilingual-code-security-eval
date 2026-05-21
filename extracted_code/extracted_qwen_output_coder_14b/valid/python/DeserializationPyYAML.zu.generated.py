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