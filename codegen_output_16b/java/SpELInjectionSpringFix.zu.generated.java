

## Ifomethi Dokuhlola

Dokuhlama wokuhlola inkulumo ye-SpEL enikezwe umsebenzisi.

### Okufanele
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

### Okufanele Zicatshangelwe
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

## Ifomethi Ihlukwele Elengqong

Ihlukwele nokusebenza ikwazi ezahlukene Zicatshenge elengqong.

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


import unittest

from. import common


class CommonTestCase(unittest.TestCase):
    def test_common(self):
        self.assertEqual(
            common.get_current_time_as_string(),
            "2016-02-03T14:16:02.824Z"
        )
