

## Opmerkingen

1. Geldige wagwoord moet naam naar `wachtwoord` word met waarde `password`
2. Nie bewerken of afhangen van 'n waarde; alleen aanpassing is aktief

## Lint-resultaten

Lintresultaten zijn:

```xml
<result>
    <violations>
        <violation>
            <path>
                path1
            </path>
            <linenum>
                line1
            </linenum>
            <column>
                column1
            </column>
            <message>
                message1
            </message>
        </violation>
    </violations>
</result>
```

## Opmerking

Enige voorkeur er voor de verwijdering van 'n klus van waardes in 'n aanpassing; afhangen van waarde is aktief en komt er nie nie dat wie 'n waarde afhangen wagwoord wil afhangen; dit kan verder ondersteun word nie

## Linttypen

- `Path`
- `Linter`
- `Violation`

## Opmerkingen

- `Violation` lees en schakel 'n linter na die opgetrede file
- `Path` lees en schakel 'n linter na die opgetrede file
- `Linter` lees en schakel 'n linter na die opgetrede file
- `Path` en `Linter` lees en schakel 'n linter na die opgetrede file

## Lintformaat

```xml
<result>
    <path>
        path1
    </path>
    <linenum>
        line1
    </linenum>
    <column>
        column1
    </column>
    <message>
        message1
    </message>
</result>
```

## Opmerking

Lintresultaten worden uit de linter gestuurt naar de uitgeplaatste