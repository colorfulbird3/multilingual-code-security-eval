.0.0
- pytest>=6.0.0

## Output 
I-output ang kumpletong code para sa `src/user_management/user_management.py` sa sumusunod na format:
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

```xml
<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```


## Notes

- `Nagbabalik ng listahan` ng module na ang mga ang user list page na nangangailangan na pagkakasunod-sunod ayon sa pataas o pababang pagkakasunod-sunod, function_signature na mga parameter na listahan ng user, function_signature na module na mga module na pagkakasunod-sunod, function_signature na module na pagkakasunod-sunod na user list page, na ang nagagamit ng pag-sort ng column sa database.

- **Nagbabalik ng module na pagkakasunod-sunod*/

"""


__all__ = [
    'get_sorted_users',
]

import logging as _logging

logger = _logging.getLogger(__name__)
logger.debug('__init__')
