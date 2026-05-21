input_data: {"id": 1, "name": "John Doe", "age": 30}

transform_map_expr: "{key: value for key, value in input_data.items() if value > 20}"

## Isinagawang code:

1. Ang `eval` ay maaari ng Python expression sa pamamagawa sa ibayon, at maaari ito ang mga user ng isang Python expression na laluhin ang data. 

2. Ang `transform_map_expr` ayutana sa `input_data` naunod na hakbang sa workflow.

3. Ito ang `transform_step_data` function naigamit ng `eval` para magsimuro ang transformationahahang ito.

4. Itaas ng function, kailangin na maaarin ang mga user na maggamit ang `input_data` sa pangalan `input_data`.

## Mgaikot

```python
transform_step_data("{key: value for key, value in input_data.items() if value > 20}", {"id": 1, "name": "John Doe", "age": 30})
```

## Expected Output

```json
{
    "name": "John Doe",
    "age": 30
}
```

## Code

```python
# workflow_transformer.py

import ast
import copy

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    """
    Transforms input data using a provided expression string.

    Args:
        transform_map_expr: A string representing a Python dictionary literal that maps keys to values.
        input_data: Dictionary containing the input data from a previous step.

    Returns:
        A new dictionary with transformed data.
    """
    try:
        # Ensure the expression is safe by compiling it to an AST and checking its structure
        ast_tree = ast.parse(transform_map_expr[
def transform_step_data based on a given expression.

Args:
    transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
        """
        Transforms input data according to the transform map expression.
        
        transform_map_expr: A string that maps keys to values using expressions.
        input_data: Dictionary with input_data.

    Returns:
        A dictionary with transformed data.
    """
    try:
        # Use eval to apply the transformation map to the input data.
        result = eval(transform_map_expr safe by compiling it to an AST and checking its structure
    ast_tree = ast.parse(transform_map_expr)
    
    # Ensure the AST only contains safe operations
    except SyntaxError as e:
        print(f"Syntax error in expression: {e}")
        raise ValueError(f"Syntax error in expression: {e}")

    except Exception as e:
        print(f"An unexpected error occurred: {e}")
        raise ValueError(f"An unexpected error occurred: {e}")

    return result
```

Assistant:

Ito ang mga isyu sa code at ang kumpletong code>
    <path>
        src/workflow_transformer/workflow_transformer.py
        <content>
            <![CDATA[
                code1
            ]]>
        </content>
    </code>
</result>