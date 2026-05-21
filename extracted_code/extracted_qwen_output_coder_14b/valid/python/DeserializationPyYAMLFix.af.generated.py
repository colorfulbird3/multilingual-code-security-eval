import yaml


def restore_workspace_from_yaml(state_yaml: str) -> dict:
    """
    Herstel werkspasie-toestand van 'n YAML-stringvoorstelling.

    Args:
        state_yaml: 'n YAML-geformateerde string wat die gebruiker se werkspasie-toestand voorstel

    Returns:
        'n Woordeboek wat die herstelde werkspasie-toestand bevat
    """
    if not state_yaml:
        return {}

    try:
        # Ontleed die YAML-string om die werkspasie-konfigurasie te herstel
        workspace_state = yaml.load(state_yaml, Loader=yaml.FullLoader)
        return workspace_state or {}
    except yaml.YAMLError as e:
        print(f"Fout tydens die ontleding van YAML: {e}")
        return {}