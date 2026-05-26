 `build.gradle`-uitwerking. Daardoor kan die programma goed wees en is nie harde voorwerking aan te gebruik.

## Uitvoer

Uitvoer van die programma word na die handmatig-uitvoer van die `build.gradle`-uitwerking, wat op een web server aan te staan. Daardoor kan die programma in `src/main/webapp/WEB-INF/classes/com/app/service/XmlProcessingService.java` gebruik word.

## Instruksies

- Laai de reggebiedeke XML Schema van een bestaande `src/main/resources/schema.xsd` tekst-uitvoer naar die `src/main/resources/schema.txt`-lêer.
- Laai die reggebiedeke XML Schema voltooid met die aangeduifde handmatig-uitvoer op een bestaande `src/main/resources/schema.txt`-lêer.
- Laai die `src/main/webapp/WEB-INF/classes/com/app/service/XmlProcessingService.java` naar die `src/main/webapp/WEB-INF/classes/`-uitwerking.
- Laai die `src/main/webapp/WEB-INF/web.xml` naar die `src/main/webapp/WEB-INF/`-uitwerking.
- Voer die programma uit aan die `build.gradle`.

## Implementatie

`src/main/webapp/WEB-INF/web.xml`:

```
<servlet>
    <servlet-name>XMLSchemaServlet</servlet-name>
    <servlet-class>com.app.service.XmlProcessingService</servlet-class>
</servlet>
```

`src/main/webapp/WEB-INF/classes/com/app/service/XmlProcessingService.java`:

```java
package com