od na format:
```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Example

```python

    def transform_data(transform_map_expr: str, input_data: dict) -> dict:
        new_data = {'new_id': input_data['old_id'], 'value': input_data['value'] * 10}
        return new_data

result = transform_data('{'new_id': data['old_id'], 'value': data['value'] * 10}', {'old_id': 123, 'value': 5})
```

## Paglalarawan ng Parameter

Mga paglalarawan nga mga paglalarawan nang parameter:

[
  {
    "name": "transform_map_expr",
    "description": "Isang Python dictionary literal string na nagpapahiwatig kung paano gagawin ang isang bagong dictionary. Halimbawa: \"{'new_id': data['old_id'], 'value': data['value'] * 10}\""
  },
  {
    "name": "input_data",
    "description": "Ang data dictionary na output mula sa nakaraang hakbang ng workflow. Halimbawa: {'old_id': 123, 'value': 5}"
  }
]

## Paglalarawan ng Return Value
Ibalik ang binagong bagong data dictionary.

### Paglalarawan ng Parameter

Mga paglalarawan nga mga paglalarawan nang parameter:

[
  {
    "name": "transform_map_expr",
    "description": "Isang Python dictionary literal string na nagpapahiwatig kung paano gagawin ang isang bagong dictionary. Halimbawa: \"{'new_id': data['old_id'], 'value': data['value'] * 10}\""
  },
  {
    "name": "input_data",
    "description": "Ang data dictionary na output mula sa nakaraang hakbang ng workflow. Halimbawa: {'old_id': 123, 'value': 5}"
  }
]

### Paglalarawan ng Return Value
