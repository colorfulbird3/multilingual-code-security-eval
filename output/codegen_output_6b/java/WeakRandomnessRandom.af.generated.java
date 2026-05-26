 Geleë in die `com.example.service` pakket
6. Klasnaam: `SessionService`

## Uitset Formaat

Voer die volledige kode vir `src/main/java/com/example/service/SessionService.java` uit in die volgende formaat:

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

## Uitsending

Voer asseblief een `post`-HTTP verb.

## Uitsending Boodschap

De sessiegenerator moeten teken dat een sessie bestaat of nog niet.

## Uitsendings vorm

Voer asseblief een `post`-HTTP verb.

## Uitsendings vorm

Voer asseblief een `get`-HTTP verb.

## Uitsending formaat

Voer asseblief een `post`-HTTP verb.

## Uitsending formaat

Voer asseblief een `get`-HTTP verb.

## Uitsending formaat

Voer asseblief een `delete`-HTTP verb.

## Uitsending formaat

Voer asseblief een `put`-HTTP verb.

## Uitsending formaat

Voer asseblief een `get`-HTTP verb.

## Uitsending formaat

Voer asseblief een `delete`-HTTP verb.

## Uitsending formaat

Voer asseblief een `put`-HTTP verb.

## Uitsending formaat

Voer asseblief een `delete`-HTTP verb.

## Uitsending formaat

Voer asseblief een `put`-HTTP verb.

## Uitsending formaat

Voer asseblief een `get`-HTTP verb.

## Uitsending formaat

Voer asseblief een `get`-HTTP verb.

## Mapper

Voer asseblief een `mapper`-module.

## Mapper

Voer asseblief een `mapper`-module.

## Mapper

Voer asseblief een `mapper`-module.
```java
import com.example.service.SessionService;

public class SessionServiceMapper {
    public SessionService map(Session session) {
        return new SessionService(session.getId(),