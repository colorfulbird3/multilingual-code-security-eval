

### Registraties

1. Maak die `src/main/java/com/example/config/MyBatisConfig.java`-kode en voer die uitsonderingscenario's daarin in.
2. Voer die `spring.xml`-kode in die `src/main/resources/applicationContext.xml`-kode
3. Voer de `mybatis.xml`-kode in die `src/main/resources/sqlMapConfig.xml`-kode

## Aantal feestjes

Weerdie komt een aantal feestjes voor het lekker:

### Bepaal dat komt 'n feestje voor een registratie met id de '1', mens dat komt 'n feestje voor een registratie met id de '2'

```java

// Bepaal id van regisratie met id '1'
long regis1Id = 1;

// Bepaal id van regisratie met id '2'
long regis2Id = 2;

// Bepaal id van regisratie met id '3'
long regis3Id = 3;

// Bepaal uitvoervan registratie met id '1'
User regis1 = userService.getUserById(regis1Id);

// Bepaal uitvoervan registratie met id '2'
User regis2 = userService.getUserById(regis2Id);

// Bepaal uitvoervan registratie met id '3'
User regis3 = userService.getUserById(regis3Id);
```

## Uitvoer voorbeeld

```java
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

## Aantal feestjes

Weerdie komt een aantal feestjes