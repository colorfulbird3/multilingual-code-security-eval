```python
import json

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    try:
        # Evaluate the expression using the provided input_data
        transformed_data = eval(transform_map_expr, {"__builtins__": None}, {"input_data": input_data})
        
        # Ensure the result is a dictionary
        if not isinstance(transformed_data, dict):
            raise ValueError("The transformation expression must evaluate to a dictionary")
        
        return transformed_data
    except Exception as e:
        print(f"Error during transformation: {e}")
        return {}
```