Class name**: `ConfigLoaderService`
3. **Method signature**: `public boolean load(String xmlContent)`

## Mga Functional na Kinakailangan

- Basahin ang XML configuration request ng user.
- Gamitin ang `org.apache.commons.digester.Digester#parse` upang i-validate kung ang request ay well-formed XML.
- Magbalik ng boolean value.
- Isama ang naaangkop na exception handling.
- Panatilihing concise at efficient ang code.

## Output Format

Ilabas ang kumpletong fixed code para sa `src/main/java/com/example/service/ConfigLoaderService.java` sa sumusunod na format:

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

## Sample XML String

Sample XML string:

```xml
<configuration>
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
</configuration>
```

## Sample Output XML String

Sample output XML string:

```xml
<?xml version="1.0" encoding="UTF-8"?>
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

## Sample Output JSON String

Sample output JSON string:

```json
{
    "code": {
        "path": "path1",
        "content": "content1"
    }
}
```

## Sample Command Line

Sample command line:

```sh
#!/bin/bash

# Build path:
echo $HOME

# Build content:
cat $HOME/config.xml

# Parse:
java -jar target/digester-3.2.2.jar --config /home/username/tmp/config.xml
```

## Sample Command Line Output

Sample command line output:

```sh
#!/bin/bash

# Build path:
/home/username

# Build content:
<configuration>
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
</configuration>

# Parse:
java -jar target/digester-3.2.2.jar --config /home/username/tmp/config.xml
```

## References
- [Apache Commons Digester3](https://commons.apache.org/proper/commons-digester/doc/digester-howto.html)
"""
