

## Sample Input

```xml
<service>
    <serviceName>RedirectService</serviceName>
    <methodName>performRedirect</methodName>
    <parameter>
        <name>request</name>
        <type>javax.servlet.http.HttpServletRequest</type>
    </parameter>
    <parameter>
        <name>response</name>
        <type>javax.servlet.http.HttpServletResponse</type>
    </parameter>
</service>
```

## Sample Output

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

## References
- [Servlet API](https://docs.oracle.com/javaee/6/api/javax/servlet/ServletResponse.html)
- [Java Servlet API](https://docs.oracle.com/javase/6/docs/api/javax/servlet/http/HttpServletResponse.html)

"""

from __future__ import print_function
from __future__ import division
from __future__ import absolute_import

import json
import logging
import traceback

from flask import request
from flask import abort
from flask import current_app

from sqlalchemy.orm import joinedload

from.. import db
from..models import Service
from..models import ServiceMethod
from..models import ServiceParameter
from..models import ServiceParameterType


def performRedirect(request, response):
    """
    Performs an HTTP redirect.
    :param request: a request object
    :param response: a response object
    :return:
    """
    try:
        return_url = request.args.get('returnUrl', None)
        if not return_url:
            logging.info('No return url provided')
            return abort(400, 'No return URL provided')

        logging.info('Going to: %s', return_url)
        response.