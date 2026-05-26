

## Opmerkingen

- Alle code en de lêer in hieronder moet bygevoeg word, want het is niet mogelijk om de lêer in de JAR-pakket te gebruiken.
- De Spring Boot bibliotheek is gebaseerd op Spring Boot 1.3.5.

## Uitvoering

<pre>
$ mvn exec:java -Dexec.mainClass=com.example.service.WebPageFetcherService \
    -Dexec.args="http://www.example.com"
</pre>
"""