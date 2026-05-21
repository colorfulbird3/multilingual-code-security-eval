

## Ifomethi Yokukhipha

Khipha ikhodi ephelele elungisiwe ye-`web.xml` noma ukufuza:

```xml
<servlet>
        <servlet-name>FileService</servlet-name>
        <servlet-class>com.example.service.FileService</servlet-class>
</servlet>
```

## Kipha ukufuza

```xml
<servlet-mapping>
    <servlet-name>FileService</servlet-name>
    <url-pattern>/file/*</url-pattern>
</servlet-mapping>
```

## Kipha kipha

```xml
<servlet>
    <servlet-name>FileService</servlet-name>
    <servlet-class>com.example.service.FileService</servlet-class>
    <init-param>
        <param-name>path</param-name>
        <param-value>/tmp/upload/</param-value>
    </init-param>
</servlet>
```
