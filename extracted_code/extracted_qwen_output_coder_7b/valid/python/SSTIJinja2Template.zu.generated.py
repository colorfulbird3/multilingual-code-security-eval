```python
from jinja2 import Template

def process_and_return_html(template_string, context):
    template = Template(template_string)
    return template.render(context)
```