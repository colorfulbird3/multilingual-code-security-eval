inaan:
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

.. code:: python

    import ssh_login_history
    import getpass
    import sys
    import urllib.request
    import urllib.parse

    if len(sys.argv) == 1:
        username = input("Username: ")
    else:
        username = sys.argv[1]

    password = getpass.getpass("Password: ")
    url = "http://localhost:8000/api/v1/login_history/"
    data = urllib.parse.urlencode({'username': username, 'password': password})
    response = urllib.request.urlopen(url, data.encode('utf-8'))
    print(response.read().decode("utf-8"))

## Example Output

.. code:: xml

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

"""

from __future__ import absolute_import
from __future__ import print_function

from datetime import datetime

from..db import db
from..helpers import *

from.common import *

def get_last_login_records(username: str) -> str:
    res = db.session.query(db.UserLoginHistory).filter_by(username=username).order_by(db.UserLoginHistory.id.desc()).first()
    if not res or not res.login_time:
        return "<![CDATA[]]>"
    return res.login_time.strftime("<![CDATA[%Y-%m-%d %H:%M:%S]]>")

def get_last_login_records_xml(username: str) -> str:
    res = db.session.query(db.UserLoginHistory).filter_by(username=username).order_by(db.UserLoginHistory.id.desc()).first()
    if not res or not res.login_time:
        return "<![CDATA[]]>"
    return