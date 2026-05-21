 ngefomethi elandelayo:

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

## Isikufakwayo Yokuphumayo

Okuqukethwe kwe-XML okupohulisa:

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

## Okupohulisa

Okupohulisa ezihlukahlukene ku- `org.w3c.dom.Document` ezokufakwayo ne-XML:

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

## Isikufakwayo Nokuphumayo

Phonsa i-`Exception` uma ifomethi ezingavamile:

```java
org.w3c.dom.Document loadConfig(java.lang.String configPath)
    throws Exception
```

## Ifomethi Yokuphumayo

Phona lwezimhwele ezingavamile:

```java
public class ConfigService extends BaseService
    implements Service
{
    public void loadConfig(String configPath)
        throws Exception
    {
        Document configDoc = loadConfig(configPath);
        String content = configDoc.selectSingleNode("/result/code/content").getText();
        System.out.println(content);
    }
}
```

## Okupohulisa

Lokuhlaji okupohulisa ukufaka kwe-XML, ezokufakwayo ne-XML:

```java
/*
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
