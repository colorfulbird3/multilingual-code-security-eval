import yaml

def restore_workspace_from_yaml(state_yaml: str) -> dict:
    return yaml.load(state_yaml, Loader=yaml.FullLoader)