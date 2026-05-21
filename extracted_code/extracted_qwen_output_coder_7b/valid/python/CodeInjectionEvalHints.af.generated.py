# src/workflow_transformer/workflow_transformer.py

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    """
    Transforms the input data based on the provided transformation expression.

    Args:
        transform_map_expr (str): A string containing a Python expression that maps the input data.
        input_data (dict): The input data to be transformed.

    Returns:
        dict: The transformed data.
    """
    # Evaluate the transformation expression with the input data
    transformed_data = eval(transform_map_expr, {'__builtins__': None}, {'input_data': input_data})
    return transformed_data