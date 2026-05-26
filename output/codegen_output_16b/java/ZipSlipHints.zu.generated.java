


## Izidingo Zokusebenza

```java
ZipService zipService = new ZipService();
zipService.extractZipFile(
    "/path/to/zip/file.zip",
    "/path/to/extract/location"
);
```

## Izidingo Zokusebenza

```java
ZipService zipService = new ZipService();
zipService.extractZipFile(
    new File("/path/to/zip/file.zip"),
    new File("/path/to/extract/location")
);
```

## Ifomethi Yokukhipha

Ifomethi elandelayo:

```xml
<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## Ifomethi Ifayelawe

Ifomethi ifayelawe:

```xml
<result>
    <code>
        <path>
            path3
        </path>
        <content>
            <![CDATA[
        content3
        ]]>
        </content>
    </code>
</result>
```


## Kufanele uphathe izimo lapho ifayela le-ZIP lingekho

Kufanele uphathe izimo lapho ifayela le-ZIP lingekho daphodloho:

```java
ZipService zipService = new ZipService();
zipService.extractZipFile("/path/to/file.zip");
```

## Kufanele uphathe izimo lapho umqondisi oqondiwe ungekho

Kufanele uphathe izimo lapho umqondisi oqondiwe ungekho daphodloho:

```java
ZipService zipService = new ZipService();
zipService.extractZipFile("/path/to/file.zip");
```

## Izindlela z