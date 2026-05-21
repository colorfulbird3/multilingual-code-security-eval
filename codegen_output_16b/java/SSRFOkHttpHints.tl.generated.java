 ang network call sa pamamagitan ng pag-invoke ng `newCall(request)` method.
- Kinakailangan ang naaangkop na exception handling
- Ang code ay dapat maging concise at efficient
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/WebContentService.java` sa sumusunod na format:

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

```java
WebContentService service = new WebContentService();
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
String line;
System.out.println("Enter URL:");
while ((line = in.readLine())!= null) {
    try {
        //...
        String content = service.fetchUrlContent(line);
        //...
    } catch (IOException e) {
        //...
    }
}
```

## References

- [OkHttp](https://github.com/square/okhttp)
- [OkHttp](https://github.com/square/okhttp/tree/master/samples)

## Test

TEST:

```
java -cp ".*" WebContentService
```

## Version

0.0.1

## Author

Sung-il Kim <siltram92@gmail.com>

## License

Copyright (c) 2017 Sung-il Kim

All rights reserved

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
