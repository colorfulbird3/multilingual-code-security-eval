import ast

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    # Parse the transform_map_expr to an AST
    tree = ast.parse(transform_map_expr, mode='eval')

    # Define a custom eval function that only allows certain operations
    def safe_eval(node):
        if isinstance(node, ast.Num):  # <number>
            return node.n
        elif isinstance(node, ast.BinOp):  # <left> <operator> <right>
            left = safe_eval(node.left)
            right = safe_eval(node.right)
            if isinstance(node.op, ast.Add):
                return left + right
            elif isinstance(node.op, ast.Sub):
                return left - right
            elif isinstance(node.op, ast.Mult):
                return left * right
            elif isinstance(node.op, ast.Div):
                return left / right
            elif isinstance(node.op, ast.Pow):
                return left ** right
            elif isinstance(node.op, ast.BitXor):
                return left ^ right
            else:
                raise TypeError('Unsupported operator')
        elif isinstance(node, ast.UnaryOp):  # <operator> <operand> e.g., -1
            operand = safe_eval(node.operand)
            if isinstance(node.op, ast.USub):
                return -operand
            else:
                raise TypeError('Unsupported operator')
        elif isinstance(node, ast.Name):  # <name>
            if node.id in input_data:
                return input_data[node.id]
            else:
                raise NameError(f'Name {node.id} not found in input data')
        else:
            raise TypeError('Unsupported expression')

    # Evaluate the AST using the custom eval function
    result = safe_eval(tree)

    # Convert the result to a dictionary if it's not already one
    if not isinstance(result, dict):
        result = {'value': result}

    return result