

## Wiskundige uitvaart

1. Die nieuwe klasse mag asseblief gebruik word voor 'n dataselectie.
2. `result` word voor 'n element met bepaalde code-omgeving.
3. `code` word voor de code-omgeving.
4. `path` word voor 'n element met vanuit de code omgeving.
5. `content` word voor de inhoud voor het element.

## Implementatie

```java
@Service
public class WorkFlowService {
    private static final Logger LOGGER = Logger.getLogger(WorkFlowService.class.getName());

    private final JsonParser jsonParser;

    @Autowired
    public WorkFlowService(JsonParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    public WorkFlow loadConfig(String jsonConfig) {
        LOGGER.info("Load config: " + jsonConfig);
        final Document doc = jsonParser.parse(jsonConfig);
        final Element result = doc.getRootElement().getChild("result");
        final Element code = result.getChild("code");
        final Element path = result.getChild("path");
        final Element content = result.getChild("content");

        final String pathContent = path.getText();
        final String contentText = content.getText();
        final Map<String, String> resultMap = new HashMap<>();
        resultMap.put("path", pathContent);
        resultMap.put("content", contentText);
        return new WorkFlow(resultMap);
    }
}
```

## Uitgebreide uitsetformaat

```xml
<workflow>
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
</workflow>
```

## Bekomst

Dit is een reeds gebruikte implementatie die moet worden af