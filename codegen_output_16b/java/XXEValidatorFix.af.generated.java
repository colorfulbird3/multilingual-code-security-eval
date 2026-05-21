formaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/ConfigService.java` uit in die volgende formaat:

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

## Voorbeelden

### Jaxp

Eerste code:

```java
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
return db.parse(path);
```

### Jaxb

Eerste code:

```java
return JaxbUtil.unmarshall(path, clazz);
```

### Dokument

Eerste code:

```java
return DokumentUtil.getDocument(path);
```

### Sax

Eerste code:

```java
return SaxUtil.getDocument(path, clazz);
```

## Opdrachten

- Aan die reggestelde code is nie vereist dat die kode die lêer eers valideert en dat de lêer in een `Document`-objek ontleed is. Dit is ein verdadekleurkleurig voorbeeld waarom het `result`-element in de reggestelde kode hieronder en in de document-object van dit `result`-element verwerkt word.
- Eerste code is nie funksional en het moet in `ConfigService.java` veranderd word.
- Die veranderd kode moet ook verversen.
- Voer de kode uit in de `src/main/java/com/example/service/ConfigService.java` en zeg `ConfigService.java` in dit `src/main/java/com/example/service/ConfigService.java` en die reggestelde code verwerkt in de document-object.
- Zodra die reggestelde code die op dit moment is aanwezig is dat die funksionaliteit de veranderde kode beschikbaar is.

De voorbeelden zijn:

De kode bevat een regel met code voor het gebruik van de `DocumentBuilderFactory` en `DocumentBuilder`. Zodra de kode in de `ConfigService.java` aanwezig is