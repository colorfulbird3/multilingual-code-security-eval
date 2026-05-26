

**Zokusebenze**: Uyoku kubutsebeze, kunye kubunikazi ukugua diafase kubutsebeze:

```java
com.example.service.ConfigService service = new com.example.service.ConfigService();
Document doc = service.loadConfig("path1.xml");
System.out.println(doc.getDocumentElement().getTextContent());
```

**Nokufakwayo**: Ikhodi ephelele:

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

**Okufakwayo**: Okubukweti kunye kubunikazi ukuguqulwa kobunikazi ukuguba diafase kubunikazi:

```java
com.example.service.ConfigService service = new com.example.service.ConfigService();
Document doc = service.loadConfig("path1.xml");
System.out.println(doc.getDocumentElement().getTextContent());
```

**Zokusebenze**: Uyoku kubutsebeze, kunye kubunikazi ukugua diafase kubutsebeze:

```java
com.example.service.ConfigService service = new com.example.service.ConfigService();
Document doc = service.loadConfig("path1.xml");
System.out.println(doc.getDocumentElement().getTextContent());
```

**Nokufakwayo**: Ikhodi ephelele:

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

**Zokusebenze**: Uyoku kubutsebeze, kunye kubunik