import yaml


def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Ibinabalik ang estado ng workspace mula sa isang YAML string representation.

    Args:
        state_yaml: Isang YAML formatted string na kumakatawan sa estado ng workspace ng user

    Returns:
        Isang dictionary na naglalaman ng naibalik na estado ng workspace
    """
    if not state_yaml:
        return {}

    # I-parse ang YAML string upang maibalik ang configuration ng workspace
    workspace_state = yaml.safe_load(state_yaml)

    return workspace_state or {}