1
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Sample Output

Sample output for the sample input URL:

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


from lxml import etree
from pprint import pprint


def main():
    url = input()
    url = url.strip()
    if url.startswith("http://") is False:
        url = "http://" + url

    if url.endswith("/") is False:
        url += "/"

    tree = etree.parse(url)
    root = tree.getroot()

    result = {}
    result["code"] = {}

    result["code"]["path"] = root.get("path")
    result["code"]["content"] = etree.CDATA(root.text)

    print(etree.tostring(root, pretty_print=True))

    pprint(result)


if __name__ == "__main__":
    main()
