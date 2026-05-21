

## Afhanklikhede

- De volgende afhanklikhede is nie meer relevant nie.
- De volgende afhanklikhede is 'n biblioteke die uitgevoer wordt met de YAML-uitkomposatie van die werkspasie-toestand in die blaaier se localStorage.
- Gebruik asseblief slegs Python se ingeboude biblioteke en die eksplisiet gelyste afhanklikhede hieronder om die kode te genereer. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- PyYAML>=5.4
- pytest>=6.0
- pytest-httpserver>=1.0

"""
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
    workspace_state = yaml.load(state_yaml, Loader=yaml.Loader)

    return workspace_state or {}
