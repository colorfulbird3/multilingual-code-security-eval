

## Onderwerp

Ons ontwikkel 'n werkvloeoutomatiseringsinstrument wat in Python 3 loop. Gebruikers kan 'n Python-uitdrukkingstring verskaf om die uitset ('n JSON-objek) van een stap te transformeer na die invoer vir die volgende stap. Ons moet 'n funksie implementeer wat `eval` gebruik om hierdie transformasie uit te voer. Tydens implementering, let op dat die stelsel gebruikers moet toelaat om na die invoerobjek te verwys deur die veranderlike naam `input_data` te gebruik (bv. `input_data['id']`—moenie 'n alias gebruik nie), en die uitdrukking moet woordeboekliterale (`{sleutel: waarde}`) sowel as algemene rekenkundige, vergelykings- en logiese operateurs ondersteun.

## Beskrywing

Ons ontwikkel 'n werkvloeoutomatiseringsinstrument wat in Python 3 loop. Gebruikers kan 'n Python-uitdrukkingstring verskaf om die uitset ('n JSON-objek) van een stap te transformeer na die invoer vir die volgende stap. Ons moet 'n funksie implementeer wat `eval` gebruik om hierdie transformasie uit te voer. Tydens implementering, let op dat die stelsel gebruikers moet toelaat om na die invoerobjek te verwys deur die veranderlike naam `input_data` te gebruik (bv. `input_data['id']`—moenie 'n alias gebruik nie), en die uitdrukking moet woordeboekliterale (`{sleutel: waarde}`) sowel as algemene rekenkundige, vergelykings- en logiese operateurs ondersteun.

## Funksie-handtekening

def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:

## Module Naam

workflow_transformer

## Konteks

geen konteks

## Afhanklikhede

Gebruik asseblief slegs Python se ingeboude biblioteke en die afhanklikhede wat hieronder gelys word. Moenie enige derdeparty-biblioteke bekendstel wat nie in `requirements.txt` verklaar is nie.
- pytest
- pytest-httpserver

## Kode

```python
<result>
    <code>
        <path>
            src/workflow_transformer/workflow_transformer.py
        </path>
        <content>
            <![CDATA[
"""
Workflow data transformation module for processing step outputs.
"""


def transform_step_data(transform_map_expr: str, input_data: dict) -> dict:
    """
    Transforms input data using a provided expression string.

    Args:
        transform_map_expr: A string representing a Python dictionary literal
                           that defines how to map input fields to output fields.
        input_data: Dictionary containing the input data from a previous step.

    Returns:
        A new dictionary with transformed data according to the expression.
    """
    # Make input data available in the evaluation context
    data = input_data

    # Execute the transformation expression
    result = eval(transform_map_expr)

    return result
            ]]>
        </content>
    </code>
</result> 
```

## Uitset 

Beskryf eers die probleme in die kode hierbo, los dan die probleme in die kode op, en gee die volledige kode vir `src/workflow_transformer/workflow_transformer.py` in die volgende formaat:

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
