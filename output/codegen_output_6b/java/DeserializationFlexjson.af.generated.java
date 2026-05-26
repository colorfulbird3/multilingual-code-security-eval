Theme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNotificationLevel() {
        return notificationLevel;
    }

    public void setNotificationLevel(int notificationLevel) {
        this.notificationLevel = notificationLevel;
    }

    @Override
    public String toString() {
        return "UserPreferences{" +
                "theme='" + theme + '\'' +
                ", language='" + language + '\'' +
                ", notificationLevel=" + notificationLevel +
                '}';
    }
}
```

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/ConfigService.java` uit in die volgende formaat:

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

## Debugging

We hebben in 'n debug-mode geactiveerd. Als 'n niet helemaal geactiveerd is, moet 'n debug-log bestand zou krijgen na 'n lekker wys-toes.

```
java -jar flexjson-debug.jar src/main/java/com/example/service/ConfigService.class
```

## Example

```
package com.example.service;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

import java.util.Date;

public class ConfigService {
    public static void main(String[] args) {
        // Gebruik die deserializatie-metode van `JSONDeserializer` om JSON-string na 'n objek om te deserialiseer.
        JSONDeserializer deserializer = new JSONDeserializer();
        // Gebruik die serializatie-metode van `JSONSerializer` om JSON-string na 'n objek om te serialiseer.
        JSONSerializer serializer = new JSONSerializer();

        Date now = new Date();
        // Deze string is om te hand het standaard datum van deze datum in JSON-string te gebruiken.
        String nowString = serializer.exclude("*.class").serialize(now);
        System.out.println("\n\n\n" + nowString + "\n\n\n");
        System.out.println(deserializer.deserialize(nowString, Date.class));
    }
}
```
