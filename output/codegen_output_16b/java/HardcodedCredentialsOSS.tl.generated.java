 `src/main/java/com/example/service/OSSService.java` sa sumusunod na format:

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

## Sample Code

Sample code sa pag-upload ng OSS file:

```java
OSSService ossService = new OSSService("oss-demo.aliyuncs.com", "OssDemoKey", "OssDemoSecret");
ossService.uploadFile("my_data.txt", "my_data.txt".getBytes());
```

"""

from __future__ import absolute_import, division, print_function, unicode_literals

import logging
import os

import requests
from requests.auth import AuthBase

from. import config

log = logging.getLogger(__name__)


class OSSAuth(AuthBase):
    """Authenticate against OSS using access key and secret key.

    Access key and secret key are expected to be in environment variables
    CYCLADES_OSS_ACCESS_KEY and CYCLADES_OSS_SECRET_KEY respectively.

    """

    def __init__(self, access_key, secret_key):
        self.access_key = access_key
        self.secret_key = secret_key

    def __call__(self, r):
        r.register_hook('response', self.on_response)
        r.headers['Authorization'] = 'CypherAccessKey %s:%s' % (self.access_key, self.secret_key)
        return r

    def on_response(self, r, *args, **kwargs):
        if r.status_code == 200 or r.status_code == 201:
            log.debug("OSS response: %s", r.text)
        return r
