

## Insetformaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/ConfigService.java` uit in de volgende formaat:

```xml
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
```

## Gebruik

Voer de volgende JavaScript-implementering in `src/main/webapp/js/services.js`:

```js
var configService = new ConfigService();
```

## Resultaat

Gee 'n resultaat terug van `ConfigService.loadConfig` als:

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

"""

from lxml import etree

from.config_service import ConfigService

__all__ = ["ConfigService"]
