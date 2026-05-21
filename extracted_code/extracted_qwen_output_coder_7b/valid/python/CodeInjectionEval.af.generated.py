import ast

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    # Parse the expression safely using ast.literal_eval
    parsed_expr = ast.literal_eval(transform_map_expr)
    
    # Evaluate the expression with the input_data dictionary
    transformed_data = eval(parsed_expr, {"__builtins__": None}, {"input_data": input_data})
    
    return transformed_data