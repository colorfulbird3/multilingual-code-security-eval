Ngingakho, ngingachaza ukuphinda ikhodi yePython ephindayo. Ikusetyenziswa kuyabonakala isebenziso sokugcina umsebenzi wokuqalisa noma kungafuneka ukucacisa ikhodi ekhombisa umphumela (into ye-JSON) esuka esinyathelo esilandelayo. Lokhu kumele ithi kungafuneka ukuthi abasebenzisi bangahlinzeka ngentambo yesisho se-Python ukuze baguqule umphumela esuka esinyathelo esilandelayo. Kukhombisa ukuthi uhlelo kumele luvumele abasebenzisi ukuthi babhekise entweni yokufaka besebenzisa igama eliguquguqukayo `input_data` (isibonelo, `input_data['id']`; ungasebenzisi amagama afanayo), futhi isisho kumele sisekele izincazelo zesichazamazwi (`{key: value}`) kanye nama-arithmetic avamile, ukuqhathanisa, kanye nama-operator anengqondo.

```python
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
```

Ngokusebenzisa ukhombisa kwePython, kumele umsebenzi omsebenzisetshenziswa kufuneka ukubonakala isebenziso sokugcina umsebenzi wokuqalisa noma kungafuneka ukucacisa ikhodi ekhombisa umphumela (into ye-JSON) esuka esinyathelo esilandelayo. Lokhu kumele ithi kungafuneka ukuthi abasebenzisi bangahlinzeka ngentambo yesisho se-Python ukuze baguqule umphumela esuka esinyathelo esilandelayo. Kukhombisa ukuthi uhlelo kumele luvumele abasebenzisi ukuthi babhekise entweni yokufaka besebenzisa igama eliguquguqukayo `input_data` (isibonelo, `input_data['id']`; ungasebenzisi amagama afanayo), futhi isisho kumele sisekele izincazelo zesichazamazwi (`{key: value}`) kanye nama-arithmetic avamile, ukuqhathanisa, kanye nama-operator anengqondo.