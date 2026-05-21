        </path>
        <path>
            path2
        </path>
        <path>
            path3
        </path>
    </code>
    <message>
        message1
    </message>
    <message>
        message2
    </message>
    <message>
        message3
    </message>
    <exception-message>
        exception message1
    </exception-message>
    <exception-message>
        exception message2
    </exception-message>
    <exception-message>
        exception message3
    </exception-message>
</result>
```

### Besonderhede

De volgende loggers moeten aanwezig worden in de funksie om te sporen ten aanzien de aanwezigheid van de funksie te bewijzen.

```java
    logger.debug("Doing some debug stuff");
    logger.info("Doing some info stuff");
```

### Bekoondige

De volgende loggers moeten aanwezig worden om te sporen ten aanzien de aanwezigheid van de funksie te bewijzen.

```java
    logger.trace("Doing some trace stuff");
    logger.warn("Doing some warning stuff");
    logger.error("Doing some error stuff");
    logger.fatal("Doing some fatal stuff");
```

## Voorbeeld:

### De uitvoerformaat:

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <path>
            path2
        </path>
        <path>
            path3
        </path>
    </code>
    <message>
        message1
    </message>
    <message>
        message2
    </message>
    <message>
        message3
    </message>
    <exception-message>
        exception message1
    </exception-message>
    <exception-message>
        exception message2
