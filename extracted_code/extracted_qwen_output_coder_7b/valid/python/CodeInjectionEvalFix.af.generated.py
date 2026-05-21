"""
Workflow data transformation module for processing step outputs.
"""

import ast

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    """
    Transforms input data using a provided expression string.

    Args:
        transform_map_expr: A string representing a Python dictionary literal
                           that defines how to map input fields to output fields.
        input_data: Dictionary containing the input data from a previous step.

    Returns:
        A new dictionary with transformed data according to the expression.
    """
    # Parse the transform_map_expr safely
    try:
        transform_map = ast.literal_eval(transform_map_expr)
    except (ValueError, SyntaxError):
        raise ValueError("Invalid transform_map_expr")

    # Initialize the result dictionary
    result = {}

    # Iterate over the transform_map and apply it to the input_data
    for key, value in transform_map.items():
        if isinstance(value, str) and value.startswith('input_data'):
            # Extract the field name from the string
            field_name = value.split('.')[1]
            if field_name in input_data:
                result[key] = input_data[field_name]
            else:
                raise KeyError(f