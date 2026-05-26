

Door die `content`-code te wees, is die Flexjson-biblioteek aan die voorkeur nog niet gezien en die met enige verwachting moet worden uitgevoerd.

## Deel-voorkeur

Dit is de enkele regel die aanwezig is in `src/main/java/com/example/service/ConfigService.java`:

```java
    @Override
    public Object loadConfig(String jsonConfig) {
        final FlexjsonBinder binder = new FlexjsonBinder();
        final Configuration configuration = binder.fromJson(jsonConfig, Configuration.class);
        return configuration;
    }
```

Dit is een gewone funksie met 'n eenvoudige Java-objekte naar JSON-stringe. Die funksie wordt uitgevoerd in de zelfde `loadConfig`-funksie waarme 'n ander konfigurasieobjekt van Flexjson word.

## Oorspronkings voor de implementatie

- In de `ConfigService.java`-klasse is die funksie implementeer asseblief in de `loadConfig`-funksie.
- In die funksie is die `deserialize`-metode van `flexjson.JSONDeserializer` gebruikt om die JSON-stringe na 'n Java-konfigurasieobjek te deserializeer.
- De `deserialize`-funksie van Flexjson is ongeveer het enige van de uitvoerfunksies die aanwezig zijn in de Java-biblioteek.

## Voorkeur voor bibliotheek-aanwezigheid

De Flexjson-biblioteek is niet alleen ontwikkeelbaar, dat is ook niet helemaal ontwikkeelbaar waarom dat een bibliotheek vanaf het begin van de uitvoering niet allemaal aanwezig is. Daarom is dat een bibliotheek vanaf de aanwezigheids