example/service/OSSService.java` in die volgende formaat:

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

## Code

> **TODO:**

## Naming

Namen:

* **namespace:** `com.example`
* **object type:** `OSSService`
* **object name:** `OSSService`

## Allewaars

Kode:

[Github](https://github.com/jmchilton/oss-service-api)

## Voorbeeld

**Invoer**

```
{
    "code" : {
        "path" : "/path/to/file.txt",
        "content" : "<![CDATA[Content]]>"
    }
}
```

**Geparëer**

```
{
    "code" : {
        "path" : "/path/to/file.txt",
        "content" : "<![CDATA[Content]]>"
    }
}
```

**Geplak**

```
{
    "code" : {
        "path" : "/path/to/file.txt",
        "content" : "<![CDATA[Content]]>"
    }
}
```

## Sukt

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

## Voorbeeld

**Invoer**

```
{
    "code" : {
        "path" : "/path/to/file.txt",
        "content" : "<![CDATA[Content]]>"
    }
}
```

**Geparëer**

```
{
    "code" : {
        "path