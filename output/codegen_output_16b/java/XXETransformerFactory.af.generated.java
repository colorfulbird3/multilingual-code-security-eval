

## Voorbeeld

```xml
<config>
    <path>
        path1
    </path>
    <content>
        <![CDATA[
        content1
        ]]>
    </content>
</config>
```

## Bedingings

1. `ConfigService` moet `java.io.File`-objek afbeelden wat die aangevraagde configuraasie is. 

  - Voer `configPath` met `new java.io.File(configPath)` op.
  - Voer `configPath` met `new java.io.File(configPath, "configPath")` op.
  - Voer `configPath` met `new java.io.File(configPath, "configPath", "configPath")` op.

2. Gebruik `com.example.service.ConfigService` komies, komt het `com.example.service.ConfigService`-objek terug waarom die komies:
  - De `ConfigService`-class het `PathService`-klas aanmaak.
  - Die komies voegt `com.example.service.PathService`-klas toe aan die `ConfigService`-class.
  - De `ConfigService`-class het `ContentService`-klas aanmaak.
  - Die `ContentService`-komies voegt `com.example.service.ContentService`-klas toe aan de `ConfigService`-class.
  - De `ConfigService`-class aanmaken.

# Gebruik

Door de afbeeldende komies is dat:

    - `TransformerFactory` wordt aangemaakt. 
    - `Transformer` wordt gebruikt om die transformasie uit te voer. 
    - Die resultaat is teruggeleenerd naar XML.

## Materiele verwerkingsbeheer

De identiteitstransformasie werkt volgens:

1. Het XML-konfigurasielaai-diensk