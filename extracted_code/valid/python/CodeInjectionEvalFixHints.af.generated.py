import ast

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    """
    Transformeer invoerdata deur 'n verskafde uitdrukkingstring te gebruik.

    Args:
        transform_map_expr: 'n String wat 'n Python-woordeboekliteraal voorstel
                           wat definieer hoe om invoervelde na uitsetvelde te karteer.
        input_data: Woordeboek wat die invoerdata van 'n vorige stap bevat.

    Returns:
        'n Nuwe woordeboek met getransformeerde data volgens die uitdrukking.
    """
    # Parseer die transformeerings-uitdrukking
    try:
        transform_map = ast.literal_eval(transform_map_expr)
    except (ValueError, SyntaxError):
        raise ValueError("Ongeldige transformeerings-uitdrukking")

    # Verwerk die transformeerings-uit