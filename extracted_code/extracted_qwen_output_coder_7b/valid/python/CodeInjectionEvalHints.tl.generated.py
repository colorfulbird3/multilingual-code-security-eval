import json

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    try:
        # Evaluate the transform_map_expr using eval with the input_data as the local namespace
        result = eval(transform_map_expr, {"__builtins__": None}, {"input_data": input_data})
        return result
    except Exception as e:
        raise ValueError(f"Error evaluating transform expression: {e}")

# Example usage:
# transform_map_expr = "{'new_key': input_data['id'] + 1}"
# input_data = {'id': 10}
# transformed_data = transform_step_data(transform_map_expr, input_data)
# print(json.dumps(transformed_data, indent=2))