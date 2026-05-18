```xml
<result>
    <code>
        <path>src/workflow_transformer/workflow_transformer.py</path>
        <content><![CDATA[
import ast

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    try:
        # Parse the expression into an AST
        expr_ast = ast.parse(transform_map_expr, mode='eval')
        
        # Define a custom eval function to allow dictionary access and basic operations
        def safe_eval(expr):
            return eval(expr, {"__builtins__": None}, {"input_data": input_data})
        
        # Evaluate the expression safely
        new_data = safe_eval(ast.unparse(expr_ast.body))
        
        return new_data
    except Exception as e:
        raise ValueError(f"Error evaluating expression: {e}")

# Example usage:
# transform_map_expr = "{'new_id': input_data['id'], 'value': input_data['value'] * 10}"
# input_data = {'id': 123, 'value': 5}
# result = transform_step_data(transform_map_expr, input_data)
# print(result)  # Output: {'new_id': 123, 'value': 50}
]]></content>
    </code>
</result>
```