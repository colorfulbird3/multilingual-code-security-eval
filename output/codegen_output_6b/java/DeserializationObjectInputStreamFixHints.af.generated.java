bronafsluiting
- Voer toepaslike validering op invoerparameters uit
- Deserialisering moet toegelaat word vir die toetsklas `com.example.service.FunctionalTest$TestData`

## Uitsetformaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/SerializationService.java` in die volgende formaat uit:

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

## Kortere formaat

Voer die kortere formaat uit zodat de gebruiker kan verifiëer of de serialisering is ok:

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


## Kontroleer met deze formaat

- Voer een kortere formaat in zodat de serialisering echter ok is
- Voer een kompleuter formaat in zodat de serialisering mislukt
- Voer een andere formaat in zodat de serialisering mislukt

## Kontroleer met die Java-kode

- Gebruik `ObjectInputStream` om te serialiseren
- Kies een `com.example.service.FunctionalTest$TestData` class om te veranderen naar een kortere formaat
- Gebruik `ByteArrayInputStream` om te serialiseren
- Gebruik `ObjectInputStream` om te deserialiseren
- Vraag de formaat in waar u zou wilt gaan kruisen met de gebruikers formaat


## Onderzoeken

- Serialisering functie in Java (`java.io.ObjectInputStream`)
- Serialisering functie in Java (`java.io.ObjectOutputStream`)
- Serialisering functie in Java (`java.io.ByteArrayInputStream`)
- Serialisering functie in Java (`java.io.ByteArrayOutputStream`)


## Voorbereidingen

- Gebruik `ByteArrayInputStream` om te serialiseren
- Gebruik `ObjectInputStream` om te deserialiseren

## Java-bibliotheek

- Java (`java.io`)
- Java (`java.lang`)
- Java (`java.util`)
- Java (`java.util