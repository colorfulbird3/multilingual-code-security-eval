
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Expected Output

Mae'n ma-output ang kumpletong code para sa sample-service:

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

## Sample Scenario

Mae-hindi na ito sa sample scenario. Kung mga user ID ay isang number, maka kung mga URL ay ang mga user ID at ibinigay ng isang parameter na "http://www.google.com/?q=userID" at kung mag-input mga user ID na ibinigay ng parameter na "http://www.google.com/?q=userID" at iginigita ang HTTP GET request na ito sa Maven at ibinigay ito sa response body na string.

### Input

```xml
<request>
    <user>
        <id>
            <number>userID</number>
        </id>
    </user>
    <url>
        <param>
            <name>q</name>
            <value>userID</value>
        </param>
    </url>
</request>
```

### Output

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


def fetch_url_content(user_url):
    http = HttpResponse()

    try:
        response = http.request('GET', user_url)
        body = response.body
        return body
    except Exception as e:
        traceback.print_exc()
        return e


class UrlService(object):

    def fetch_url_content(self, user_url):
        return fetch_url_content(user_url)
