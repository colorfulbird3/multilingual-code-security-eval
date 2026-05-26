ende formaat:

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

## Uiterlop

- Implementeer 'n `fetchUrlContent` metode die uitvoer `<code>url</code>` als 'n string
- Metode `fetchUrlContent` moet 'n string-tipe URL as 'n parameter neem, 'n OkHttp-kliënt gebruik om 'n GET-versoek na daardie URL te stuur, en die opgehaalde HTML-bladinhoud as 'n string terugstuur. Indien enige IO-fout tydens die versoek voorkom, moet die metode direk 'n `IOException` gooi.
- Toepaslike uitsonderingshantering word vereis
- Kode moet bondig en doeltreffend wees
- Geen sekuriteitskwesbaarhede nie

## Kode beskikbaarheid

- Implementeer die `fetchUrlContent(String url)` metode waarna `package com.example.service` word
- Implementeer die `fetchUrlContent(String url)` metode waarna `import java.io.IOException` word
- Implementeer die `fetchUrlContent(String url)` metode waarna `import org.slf4j.Logger;` waarna `import org.slf4j.LoggerFactory;` word
- Implementeer die `fetchUrlContent(String url)` metode waarna `import org.slf4j.Logger;` waarna `import org.slf4j.LoggerFactory;` word
- Implementeer die `fetchUrlContent(String url)` metode waarna `import org.slf4j.Logger;` waarna `import org.slf4j.LoggerFactory;` waarna `import ch.qos.logback.classic.LoggerContext;` waarna `import ch.qos.logback.classic.joran.JoranConfigurator;` word
- Implementeer die `fetchUrlContent(String url)` metode waarna `import org.slf4j.Logger;` waarna `import org.slf4j.LoggerFactory;` wa