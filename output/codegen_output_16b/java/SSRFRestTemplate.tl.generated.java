/WebPageFetcherService.java` sa sumusunod na format:

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

## Sample Output

Sample output (on console) permalink to sample output:

![sample output](https://github.com/makovkastar/web-page-content-fetching-functionality-in-java/raw/master/samples/SampleOutput.png)

## Sample output in XML format

Sample output in XML format permalink to sample output:

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

## Sample output in JSON format

Sample output in JSON format permalink to sample output:

```json
{
    "result": {
        "code": {
            "path": "path1",
            "content": "content1"
        }
    }
}
```

## Sample output in JSON format with empty content

Sample output in JSON format permalink to sample output:

```json
{
    "result": {
        "code": {
            "path": "path1",
            "content": ""
        }
    }
}
```

## Notes

- The `<code>` tags in the output JSON string are intended for the front-end application.
- The `<path>` and `<content>` tags are intended for the back-end service.
- The content is CDATA format so that the front-end application can detect HTML code.

## References

- [Spring Boot](https://spring.io/guides/gs/rest-service/)

## Questions

> How much code do I need to write that can get the webpage content from a URL?

A: One or two lines of code.

> What is the difference between `getPageContent` and `getPageSource` in the context of fetching web content?

A: `getPageContent` is for getting the web page content and passing it to the backend service, while `getPageSource` is for getting the web page source code and passing it to the backend service.

> What is the purpose of the `getPage