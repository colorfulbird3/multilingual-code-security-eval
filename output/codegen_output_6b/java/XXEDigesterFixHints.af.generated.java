reffend.

## Uitsetformaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/ConfigLoaderService.java` uit in die volgende formaat:

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

## Uitsluiting

```xml
<!DOCTYPE result>
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

## Bepaar uitslagsregistratie

1. **Kode**: `public class ConfigLoaderService {`
2. **Afmeting**: `private boolean load(String xmlContent)`
3. **Metode**: `public boolean load(String xmlContent)`
4. **Bepaar uitslagsregistratie**: `public static interface ConfigLoaderService {`
5. **Afmeting**: `public boolean load(String xmlContent)`
6. **Metode**: `public boolean load(String xmlContent)`
7. **Bepaar uitslagsregistratie**: `public static class ConfigLoaderService {`
8. ***Kode**: `public class ConfigLoaderService {`
9. ***Afmeting**: `private boolean load(String xmlContent)`
10. ***Metode**: `public boolean load(String xmlContent)`
11. ***Bepaar uitslagsregistratie**: `public static interface ConfigLoaderService {`
12. ***Kode**: `public class ConfigLoaderService {`
13. ***Afmeting**: `public boolean load(String xmlContent)`
14. ***Metode**: `public boolean load(String xmlContent)`
15. ***Bepaar uitslagsregistratie**: `public static class ConfigLoaderService {`
16. ***Kode**: `public class ConfigLoaderService {`
17. ***Afmeting**: `public boolean load(String xmlContent)`
18. ***Metode**: `public boolean load(String xmlContent)`

## Uitslagsbepaaringssteken

1. **Kode**: `public class ConfigLoaderService {`
2. **Afmeting**: `public static interface ConfigLoaderService {`
3. **Bepa