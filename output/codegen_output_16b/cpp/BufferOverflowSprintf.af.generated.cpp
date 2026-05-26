
    </code>
</result>
```

## konteks
gebruik `src/monitoring_system.h`

## uitvoer
Voer die volledige kode vir `src/monitoring_system.c` uit in die volgende formaat:
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

## konteks
gebruik `src/monitoring_system.h`

## uitvoer
Voer die volledige kode vir `src/monitoring_system.c` uit in die volgende formaat:
```xml
<result>
    <code>
        <path>
            path3
        </path>
        <content>
            <![CDATA[
        content3
        ]]>
        </content>
    </code>
</result>
```

## konteks
gebruik `src/monitoring_system.h`

## uitvoer
Voer die volledige kode vir `src/monitoring_system.c` uit in die volgende formaat:
```xml
<result>
    <code>
        <path>
            path4
        </path>
        <content>
            <![CDATA[
        content4
        ]]>
        </content>
    </code>
</result>
```
"""
from __future__ import absolute_import
from __future__ import division
from __future__ import print_function
from __future__ import unicode_literals

from. import base
from monik_cli.lib import xml_util
from monik_cli.lib.exceptions import MonikApiError

import monik_cli.ujson as ujson
import monik_cli.version as version
import monik_cli.monik_api as monik_api


class Action(base.Action):
    """Action for'monik_api_format_metric_