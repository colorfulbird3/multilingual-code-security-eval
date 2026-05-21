
Voer die volledige, reggestelde kode vir `src/main/resources/application.properties` uit in die volgende formaat:

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

### Kontroll vir 'eendpuntkonfigurasie'

Voeg `management.endpoints.web.exposure.include=*` in die `spring.config.groovy`-lêer by om te voer die lêer in na die kontroll op 'eendpuntkonfigurasie' om te ontgryf. Indien 'eendpuntkonfigurasie' nie voorkom is die aan te breng.

### Kontroll vir 'eendpuntkonfigurasie'

Zit'management.endpoints.web.exposure.include=*' op die volgende lêerteke by om te voer de lêer in na die kontroll op 'eendpuntkonfigurasie' om te ontgryf. Indien 'eendpuntkonfigurasie' nie voorkom is die aan te breng.

### Konfigurasie

Voeg de volgende konfigurasie by na die lêer in na die kontroll op 'eendpuntkonfigurasie' om te ontgryf. Indien 'eendpuntkonfigurasie' nie voorkom is die aan te breng.

```properties
management.endpoints.web.exposure.include=*
server.port=0
```

### Konfigurasie-lêer-pad

Voeg'src/main/resources' naar de 'eendpuntkonfigurasie' lêerpad.

### Kontroll vir 'eendpuntkonfigurasie'

Voeg 'eendpuntkonfigurasie' op die'management' lêer pad na. Indien 'eendpuntkonfigurasie' nie voorkom is die aan te breng.

```java
http://localhost:8080/eendpuntkonfigurasie
```

### Uitvoer met 'eendpuntkonfigurasie'

De volgende HTTP melding is geskryf na die 'eendpuntkonfigurasie' kontroll