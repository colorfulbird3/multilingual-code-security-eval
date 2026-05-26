uitvoering misluk
- Groovy weergawe is 3.0.9; moenie API's gebruik wat nie in hierdie weergawe ondersteun word nie.

## Uitsetformaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/ScriptService.java` uit in die volgende formaat:

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

## Onderbreek

- Als `groovy.lang.Script` klas word de kode nie gedeeld
- Als `groovy.lang.GroovyShell` klass word de kode nie gedeeld
- Enkele `groovy.lang.Script` klasses word nie te gedeeld waardoor het onderbreek word van het hele domein.
- Als `groovy.lang.GroovyShell` klass word nie te gedeeld waardoor het onderbreek word van het hele domein.
- Als `groovy.lang.Script` klass word het te gedeeld waardoor het onderbreek word van het domein.
- Als `groovy.lang.GroovyShell` klass word het te gedeeld waardoor het onderbreek word van het domein.
- Als `groovy.lang.Script` klass word te gedeeld waardoor het onderbreek word van het domein.
- Als `groovy.lang.GroovyShell` klass word te gedeeld waardoor het onderbreek word van het domein.
