.example.service`
- Method signature: `public String getUrlContentPreview(String urlString)`
- Implementation hint: Mangyaring gamitin ang `java.net.URL` class para i-parse ang URL string at magtatag ng koneksyon sa pamamagitan ng `openConnection()` method nito upang makuha ang nilalaman ng webpage.
- Kinakailangan ang angkop na exception handling
- Dapat concise at efficient ang code
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/UrlPreviewService.java` sa sumusunod na format:

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

## Notes

- If you need to access any of the files, you can easily do so by running the following command:

```bash
$ curl -L -o <path-to-files> <url-of-file>
```

## Example

## Code

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

## Notes

- If you need to access any of the files, you can easily do so by running the following command:

```bash
$ curl -L -o <path-to-files> <url-of-file>
```

## References

- [Google's website](https://developers.google.com/web-toolkit/doc/1.18/webview)
- [Java8+](https://www.mkyong.com/java8/)
- [Java Native](https://www.mkyong.com/java-native/)

## License

MIT License:

```
Copyright (c) 2017, Tamas Calkes

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT,