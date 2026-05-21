
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Input Format

* **Schema content:** `path1`
* **Data:** `content1`

## Sample Dataset

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

## Unit Test

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
"""

from __future__ import unicode_literals

import os
import sys
import unittest

from docx_tables.table import Row

from dmlib.utils.exceptions import XmlProcessingServiceException
from dmlib.utils.process import Process
from dmlib.utils.process import ProcessResult
from dmlib.utils.process import ProcessTask

from dmlib.utils.text import Markdown

from dmlib.utils.utils import read

from dmlib.api.dto import Schema
from dmlib.api.dto import SchemaField
from dmlib.api.dto import SchemaFieldType
from dmlib.api.dto import SchemaFieldValueType


class XmlProcessingServiceTestCase(unittest.TestCase):
    def setUp(self):
        pass

    def test_load_schema_1(self):
        schema_content = read('tests/schema_test.xml')
        schema = Schema()
        schema.name = 'test'
        schema.fields = [
            SchemaField(name='testField1', type=SchemaFieldType.NUMBER),
            SchemaField(name='testField2', type=SchemaFieldType.STRING),
            SchemaField(name='testField3', type=SchemaFieldType.DATE),
        ]
        schema.fields[0].