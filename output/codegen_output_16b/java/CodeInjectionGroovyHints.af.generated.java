 uitsonderings wanneer skripuitvoering misluk
- Groovy-weergawe is 3.0.9; moenie API's gebruik wat nie in hierdie weergawe ondersteun word nie
- Geen sekuriteitskwesbaarhede

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/ScriptService.java` uit in die volgende formaat:

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

## Implementasie

Lees de implementasie in `ScriptServiceImpl.java`.

## Tydes

- Verwerking van user-gebruikerscript
- Verwerking van scenario-gebruikerscript
- Verwerking van scenario-dataverwerking

## Uitvoer

1. Bevat de resultaat in een `java.lang.Object`.
1. Hanteer de terugkeer in een `java.lang.String` en vervolgens hanteer in een `java.lang.Object`

## Logisimie

1. Voer die resultaat in een logfile
1. Gebruik `java.lang.System.out` en `java.lang.System.err` om te loggen.

## Aantasting

Er komt 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit de `groovy.lang.GroovyShell`.

* Er is 'n `groovy.lang.ScriptException` tussen de opstart en het voer uit; die heeft 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit
* Er is 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit; die heeft 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit
* Er is 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit; die heeft 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit
* Er is 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit; die heeft 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en het voer uit
* Er is 'n `groovy.lang.GroovyRuntimeException` tussen het opstarten en he