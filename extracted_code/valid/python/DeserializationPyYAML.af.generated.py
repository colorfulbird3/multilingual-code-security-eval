import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    return yaml.safe_load(state_yaml)