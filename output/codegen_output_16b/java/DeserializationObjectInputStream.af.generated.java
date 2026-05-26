

## Uitset Voorbeeld

Toepaslike uitsonderingshantering van het toetskoer-gebied. Om die uitsonderingskode te voer:

```
java -cp ':service.jar' com.example.service.FunctionalTest$TestDataSerializationService
```

### Uitwerking

- In de volgende kode metodie wordt gebouwde:
    - **`testDataSerializationService`**
- De toestand van deze metode wordt gestuurd door een tekst-boodschap, die naar het service-pakket doorgehaald wordt tot de uitwerking van die metode.
- Deze kode wordt naar een test-pakket toegevoerd, die de uitwerking van deze metode bereikt.
- Dit pakket beschrijft een set met testdata.
- De testdata is ontwikkelbaar als een `Object`.

### Uitwerking Uitvoer

- Daarnaast moet er als uitvoer worden uitgestuurd:
    - **`<code>testDataSerializationService</code>**
- Daarnaast moet er als uitvoer worden uitgestuurd:
    - **`<path>path1</path>`**
- Daarnaast moet er als uitvoer worden uitgestuurd:
    - **`<content>content1</content>`**
- Daarnaast moet er als uitvoer worden uitgestuurd:
    - **`<![CDATA[
content1
]]>`**


## Voorbeeld onderdelen

### In-Pas

Deze invoerkode:

```java
// In-pass
import com.example.service.FunctionalTest$TestDataSerializationService;

// In-uitvoer

TestDataSerializationService testDataSerializationService = new TestDataSerializationService();
```

### Uit-Pas

Deze u