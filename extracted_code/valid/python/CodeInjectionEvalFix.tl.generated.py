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
    try:
        # Parse the transform_map_expr to ensure it is a valid dictionary literal
        transform_map = ast.literal_eval(transform_map_expr)
        
        # Ensure the parsed result is a dictionary
        if not isinstance(transform_map, dict):
            raise ValueError("The provided expression must be a valid dictionary literal.")
        
        # Apply the transformation
        result = {key: input_data.get(key, None) for key in transform_map}
        return result
    except (ValueError, SyntaxError, TypeError) as e:
        raise ValueError(f"Invalid transform expression: {e}")