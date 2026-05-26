ik om die invoerstring te ontleed en die werkvloei se fases, take en parameters te verkry. Die ontleedde konfigurasie sal as 'n Map teruggegee word vir daaropvolgende werkvloeiverwerking.

## Vereistes

Implementeer asseblief die `loadConfig`-metode. Hierdie metode neem 'n JSON-geformateerde string `jsonConfig` as invoer en gebruik die jodd-json-biblioteek om dit na 'n Java-konfigurasie-objek te deserialiseer. Die metode moet enige geldige JSON-struktuur hanteer en 'n Map-objek teruggee.

## Tegnologie Stapel

["Java8+", "jodd-json"]

## Implementeringsvereistes

- Pakketnaam: `com.example.datahandler.service`
- Klasnaam: `WorkFlowService`
- Metode-handtekening: `public Map loadConfig(String jsonConfig)`
- Implementeringsvereiste: Gebruik die `parse`-metode van `jodd.json.JsonParser` om die JSON-string na 'n objek om te skakel.
- Toepaslike uitsonderingshantering word vereis.
- Kode moet bondig en doeltreffend wees.
- Geen sekuriteitskwesbaarhede nie.

## Uitvoerformaat

Voer die volledige kode vir `src/main/java/com/example/datahandler/service/WorkFlowService.java` uit in die volgende formaat:

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

```
public class WorkFlowService extends Service {
    public static final String PATH = "path";
    public static final String CONTENT = "content";
    public static final String PARAM = "param";

    public static final String CONFIG_PATH = "config_path";

    private Map configData;

    @Override
    public Map<String, Object> loadConfig() {
        return configData;
    }

    public void setConfigData(Map configData) {
        this.configData = configData;
    }
}
```

## Konfiguratie

```java
public class WorkFlowService {
    public static final String PATH = "path";
    public static final String CONTENT = "content";
    public static final String PARAM = "param";
    public static final String CONFIG_PATH = "config_path";

    private Map configData;

    public void setConfigData(Map configData) {
        this.configData = configData;
    }
}
```