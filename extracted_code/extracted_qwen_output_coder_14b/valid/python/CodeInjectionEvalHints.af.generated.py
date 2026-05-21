import ast

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    """
    Transformeerfunksie wat JSON-objekte transformeer.

    :param transform_map_expr: 'n Stringexpressie wat definieer hoe die `input_data` moet word omgewand.
    :param input_data: Die invoer JSON-objek.
    :return: 'n Nieuw JSON-objek wat die transformering bevat.
    """
    # Parse die stringom die veilige evaluering te doen.
    try:
        parsed_expr = ast.literal_eval(transform_map_expr)
        if not isinstance(parsed_expr, dict):
            raise ValueError("Die transform_map_expr moet 'n woordeboekliteraal wees.")
        
        # Voer die transformering uit.
        transformed_data = {}
        for key, value in parsed_expr.items():
            try:
                # Verwys na die input_data objek met behulp van eval.
                transformed_value = eval(value, {"__builtins__": None}, {"input_data": input_data})
                transformed_data[key] = transformed_value
            except Exception as e:
                raise ValueError(f"Error during transformation for key '{key}': {str(e)}")
        
        return transformed_data
    except (SyntaxError, ValueError) as e:
        raise ValueError(f"Invalid transform_map_expr: {str(e)}")

# Voorbeeld van gebruik:
# input_data = {'id': 1, 'name': 'John Doe', 'age': 20}
# transform_expression = "{'name': input_data['name'], 'age': input_data['age'] + 5}"
# output = transform_step_data(transform_expression, input_data)
# print(output)  # {'name': 'John Doe', 'age': 25}