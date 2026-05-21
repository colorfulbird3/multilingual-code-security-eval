import yaml


def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Herstel werkspasie-toestand van 'n YAML-string voorstelling.

    Args:
        state_yaml: 'n YAML-geformateerde string wat die gebruiker se werkspasie-toestand voorstel

    Returns:
        'n Woordeboek wat die herstelde werkspasie-toestand bevat
    """
    if not state_yaml:
        return {}

    # Ontleed die YAML-string om die werkspasie-konfigurasie te herstel
    workspace_state = yaml.safe_load(state_yaml)

    return workspace_state or {}