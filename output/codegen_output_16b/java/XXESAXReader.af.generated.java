

## Uitlading

- `com.example.service.ConfigService` is gegenerateerde `Service`
- `ConfigService` is gegenerateerde `WebServie`
- `configPath` is gegenerateerde `String`-dataverwerkingsmethod
- `loadConfig(java.lang.String configPath)` is gegenerateerde `java.lang.Document`-ontledingsdiensklas
- `SAXReader` is gegenerateerde `XMLReader`

## Ontwikkelingsresultaat

Ontwikkel asseblief `com.example.service.ConfigService.java` en lee dit terug in `ConfigService`:

```java
public class ConfigService extends Service {
    public Document loadConfig(String configPath) {
        try {
            return new SAXReader().read(new FileInputStream(configPath));
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while trying to load the config file", ex);
        }
    }
}
```

## Uitlading

- `com.example.service.ConfigService` is gegenerateerde `Service`
- `ConfigService` is gegenerateerde `WebServie`
- `configPath` is gegenerateerde `String`-dataverwerkingsmethod
- `loadConfig(java.lang.String configPath)` is gegenerateerde `java.lang.Document`-ontledingsdiensklas
- `SAXReader` is gegenerateerde `XMLReader`

## Een vulledige ontwikkelingsklasse

```java
public class ConfigService extends Service {
    public Document loadConfig(String configPath) {
        try {
            return new SAXReader().read(new FileInputStream(configPath));
        } catch (Exception ex) {
            throw new RuntimeException("An error occurred while trying to load the config file", ex);
        }
    }
}
```

## Ontersoektigheid

We het oorspronkelijke ontwik