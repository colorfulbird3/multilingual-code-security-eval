
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

## Usage

Pangawasan ng schema sa ang code ng kasalukuyang.

### Schema na ng user

```xml
<user>
    <name>name1</name>
    <email>email1</email>
</user>
```

### Schema na ng user sa user ng validation service

```xml
<user>
    <name>name1</name>
    <email>email1</email>
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
</user>
```

### Schema na ng user sa user ng validation service sa user

```xml
<user>
    <name>name1</name>
    <email>email1</email>
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
</user>
```

## Example

Imaikin ang kasalukuyang ng code sa ang XML Schema sa user sa `<code>` XML tag sa ibaba.

```xml
<user>
    <name>name1</name>
    <email>email1</email>
</user>
```

Imaikin ang kasalukuyang ng schema sa user sa `<code>` XML tag sa ibaba.

```xml
<user>
    <name>name1</name>
    <email>email1</email>
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
</user>
```

## Ipatupad ang XML Schema Validation Functionality

Ang ipatupad ang validation ng XML Schema sa user sa `<code>` XML tag sa ibaba.

```xml
<user>
    <name