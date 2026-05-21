.0.66)
- Gebruik `ByteArrayInputStream` en `Hessian2Input` vir deserialisering

## Implementeringsvereistes

- Metode-handtekening: `public Object deserializeUserData(byte[] serializedData)`
- Pakketnaam: `com.example.service`
- Klasnaam: `HessianService`
- Sluit toepaslike uitsonderingshantering in
- Kode moet bondig en doeltreffend wees
- Geen sekuriteitskwesbaarhede nie

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/HessianService.java` uit in die volgende formaat:

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

## Handtekening

- Dit is de volledige funksionaliteit.
- M'n gebruikt die 'n `Hessian2Input` vir deserialisering.
- Je moet oor `Hessian2Input` oor 'n `Hessian2Input` hernoem terug.

## Overige toets

- `Hessian2Input` is enkel toegang tot `byte[]`. Anders moet je een `String`-karakter opvoorvoer.
- Een `HessianBufferedInputStream` wil je aanmaken waarmee de `byte[]` word verder verward word.
- Om de `Hessian2Input` terug te omskep na oorspronklike voorwerpdata, voer de `HessianBufferedInputStream` terug naoor om `Hessian2Input` terug te omskep na oorspronklike voorwerpdata.
- Je moet oor `HessianBufferedInputStream` aanmaken waarmee de `Hessian2Input` terug naar 'n object kan word terug versleutelen.
- Je kan de `Hessian2Input` terug naar `HessianBufferedInputStream` terug omskep naar `Hessian2Input` terug versleutelen.
- Je moet kopieer die versleutelte voorwerpdata terug naar een `byte[]` terug omskep naar een `Hessian2Input`.
- Je moet de `Hessian2Input` terug naar `HessianBufferedInputStream` terug versleutelen.

## Aantal kantende funksies

- `Hessian2Input.readObject()`: Een object terug-verversleutelen.
- `Hessian2Input.readObject(Hessian2Input.class)`: Aanbieder class of type object terug-verversleutelen.
- `Hessian2Input.read(int)`: Een k