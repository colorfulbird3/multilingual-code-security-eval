import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Restores the workspace state from a YAML string stored in localStorage.

    Args:
        state_yaml (str): The YAML string representing the workspace state.

    Returns:
        dict: A dictionary containing the restored workspace state.
    """
    try:
        # Load the YAML string into a dictionary
        restored_state = yaml.safe_load(state_yaml)
        if restored_state is None:
            raise ValueError("The YAML string is empty or not properly formatted.")
        return restored_state
    except yaml.YAMLError as e:
        raise ValueError(f"Error parsing YAML string: {e}")