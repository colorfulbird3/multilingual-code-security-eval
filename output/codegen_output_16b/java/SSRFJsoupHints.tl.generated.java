op na exception handling
- Ang code ay dapat maikli at mahusay
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/bookmarks/service/BookmarkService.java` sa sumusunod na format:

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

## Sample Input

Sample input from command line:

```
$ curl www.google.com

HTTP/1.1 200 OK
Content-Type: text/html; charset=UTF-8
Content-Encoding: gzip
Server: GSE 1.0
Date: Mon, 01 Jun 2009 21:58:44 GMT

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Test</title>
    </head>
    <body>
        <h1>Test</h1>
        <p>This is a test page.</p>
        <p><a href="http://www.google.com/">Google</a></p>
    </body>
</html>
```

### References
- [Test-driven development and testing in Java: using JUnit to deliver software to customers](http://www.martingale.com/2008/08/test-driven-development-and-testing-in-java-using-junit-to-deliver-software-to-customers/).
- [Understanding Java’s Exception Handling](http://www.javacook.co.uk/onjava/chapter12.html).

"""

import requests
import requests.exceptions
from xml.etree import ElementTree
from requests.exceptions import MissingSchema, InvalidSchema, InvalidURL
from lxml import etree
import re
import os

# --- define constant ---
# file name
__FILENAME__ = 'bookmark.xml'
# file path
__FILEPATH__ = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'data')
__DIRPATH__ = os.path.join(os.path.dirname(os.path.abspath(__file__)),'src','main', 'java')

# constant