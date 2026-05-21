

## Uitvoerboodskap

Voer die 'n JSON-formaat geformateerde konfiguratie in `src/main/resources/test.json` in die volgende formaat uit:

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

## Opsie

Dit kan een eenvoudige geformatteerde konfiguratie in 'n JSON-formaat te gebruiken, wat dit de 'n werkvloei.

- Aanvang konfiguratie in dit gebruikers directory kon 'n werkvloei installeer word.
- Aanvang konfiguratie in die datahandler-buk.
- Werkklasse genotoon om te installeer werkvloei.
- WorkFlowService in die datahandler-buk.
- Werkklasse werkt op datahandler-buk.
- WorkFlowService gebruikt de Jodd JSON-biblioteek om de JSON-formaat te parseeren en uit te komende data.
- WorkFlowService gebruikt de `jodd.json.JsonParser` om de JSON-string te parseeren en het uit te komende data.
- WorkFlowService gebruikt het `com.example.datahandler.service.WorkFlowService` klasse om de werkvloei te installeer en werkt.
- De werkvloeweerst gebruikt de `jodd.json.JsonParser` om de Json-string te parseeren en het uit te komende data uit te voeren.
- De werkvloeweerst gebruikt het `com.example.datahandler.service.WorkFlowService` klasse om de werkvloei te installeer en werkt.