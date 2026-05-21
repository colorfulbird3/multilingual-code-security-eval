

## Ontvangen van de resultaat

Voorbeeld:
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

### Uitdrukking

```ognl
ognl.Ognl.getValue(ognl.OgnlRuntime.DEFAULT_CONFIG, dataRoot, expression);
```

### Kontroleer

<pre>
<?xml version="1.0" encoding="UTF-8"?>
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
</pre>

## Updatetabel

Implementeer asseblief `ReportService.getReportFieldValue(String expression, Object dataRoot) throws ognl.OgnlException`

"""

import os
import sys
from jinja2 import Environment,FileSystemLoader


class ReportGenerator:
    def __init__(self, template_dir, output_dir, version):
        self.template_dir = template_dir
        self.output_dir = output_dir
        self.version = version

    def render(self, input_path, output_path):
        # generate the jinja2 environment
        jinja_env = Environment(loader=FileSystemLoader(self.template_dir))

        # create the output directory if it does not exist
        if not os.path.isdir(self.output_dir):
            os.makedirs(self.output_dir)

        # open the template file
        template_file = os.path.join(self.template_dir, input_path)
        with open(template_file) as f:
            template = jinja_env.from_string(f.read())

        # render the template
        output_file = os.path.join(self.output_dir