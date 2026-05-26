

### Uitvoer

Uitvoer van die kode in `src/main/webapp/WEB-INF/web.xml`:

```xml
    <servlet>
        <servlet-name>XmlDataParser</servlet-name>
        <servlet-class>com.example.webapp.service.XmlDataParser</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>XmlDataParser</servlet-name>
        <url-pattern>/service/XmlDataParser</url-pattern>
    </servlet-mapping>
```

### Verwerkingsformaat

Aan die voorbeeld bevind die regel:

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

Uitvoer van die regel in die web.xml:

```xml
    <servlet-mapping>
        <servlet-name>XmlDataParser</servlet-name>
        <url-pattern>/service/XmlDataParser</url-pattern>
    </servlet-mapping>
```

### Verwerkingsformaat met CDATA

Aan die voorbeeld bevind die regel:

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

Uitvoer van die regel in die web.xml:

```xml
    <servlet-mapping>
        <servlet-name>XmlDataParser</servlet-name>
        <url-pattern>/service/XmlDataParser</url-pattern>
    </servlet-mapping>
```

### Geldige Uitvoer

