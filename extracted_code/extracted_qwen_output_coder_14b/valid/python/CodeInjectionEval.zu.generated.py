# src/workflow_transformer/workflow_transformer.py

import json

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    try:
        # Evaluate the transformation expression with the provided input data
        transformed_data = eval(transform_map_expr, {"__builtins__": None}, {"data": input_data})
        return transformed_data
    except Exception as e:
        raise ValueError(f"Failed to transform data: {e}")

if __name__ == "__main__":
    # Example usage
    transform_map_expr = "{'new_id': data['old_id'], 'value': data['value'] * 10}"
    input_data = {'old_id': 123, 'value': 5}
    result = transform_step_data(transform_map_expr, input_data)
    print(json.dumps(result, indent=4))