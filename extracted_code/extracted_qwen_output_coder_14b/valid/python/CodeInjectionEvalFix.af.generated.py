import json

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    """
    Transforms input data using a provided transformation map expression.

    Args:
        transform_map_expr: A string representation of a Python dictionary that maps input keys to output keys and values.
    """
    # Evaluering vanrader om die transformasie uit te voer uitvoer, gebruik 'n try/except-blok om foutte handeling te voer, en maak van die evaluering van te kontroleer.

    try:
        # Voer die 'n volge stap in die evaluering om die `eval` te maak die trans_map_expr uit transformasie te doen.
        result = eval(transform_map_expr, {"__builtins__": {}, "input_data": input_data})

    except Exception as e:
        raise ValueError(f"Error during transformation: {e}")

    return result