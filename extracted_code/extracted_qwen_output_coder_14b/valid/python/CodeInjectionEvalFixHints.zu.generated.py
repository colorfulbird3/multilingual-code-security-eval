"""
Workflow data transformation module for processing step outputs.
"""

import json

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
    # Evaluate the expression to get the mapping dictionary
    try:
        transform_map = json.loads(transform_map_expr)
    except json.JSONDecodeError as e:
        raise ValueError(f"Invalid JSON expression: {e}")

    # Transform the input data according to the mapping
    transformed_data = {}
    for key, value in transform_map.items():
        if isinstance(value, str):
            # If the value is a string, it should be a key in the input data
            transformed_data[key] = input_data.get(value, None)
        else:
            # Otherwise, use the value directly
            transformed_data[key] = value

    return transformed_data