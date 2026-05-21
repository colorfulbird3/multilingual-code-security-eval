import yaml


def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Ibinabalik ang workspace state mula sa isang YAML string representation.

    Args:
        state_yaml: Isang YAML formatted string na kumakatawan sa workspace state ng user

    Returns:
        Isang diksyunaryo na naglalaman ng naibalik na workspace state
    """
    if not state_yaml:
        return {}

    # I-parse ang YAML string upang maibalik ang workspace configuration
    try:
        workspace_state = yaml.safe_load(state_yaml)
    except yaml.YAMLError as e:
        print(f"Error parsing YAML: {e}")
        return {}

    return workspace_state or {}