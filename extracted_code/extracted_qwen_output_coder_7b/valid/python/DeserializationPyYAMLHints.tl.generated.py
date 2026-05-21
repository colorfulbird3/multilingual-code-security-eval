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