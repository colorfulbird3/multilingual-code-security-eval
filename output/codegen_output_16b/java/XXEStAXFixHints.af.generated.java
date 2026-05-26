

## Uitvoeropdracht

Da deze funksionaliteit niet aanwezig is, maar die de regel voor het bepalen van de kwesbaarheid nog regelmatig de regels van XML-kode uit te sluiten, lees deze hieronder in uw code:

```xml
    <!--  XML code here -->
    <result>
        <code>
            <path>
                <![CDATA[
              path1
            ]]>
            </path>
            <content>
                <![CDATA[
              content1
            ]]>
            </content>
        </code>
    </result>
    <!--  XML code here -->
```

## Aantal regels

Deze funksionaliteit verwerkt nog **nog geen** XML-skema. De regel is altijd volledig geteleken door de content zijn CDATA-etiket. Die regel is volledig waardoor de kwesbaarheid niet correct wordt ingevoerd.

## Lekprobleem

Het lokale schema hebt een lek probleem. Dit is de regel waarop de lek probleem aanwezig is:

```xml
    <result>
        <code>
            <path>
                <![CDATA[
              path1
            ]]>
            </path>
            <content>
                <![CDATA[
              content1
            ]]>
            </content>
        </code>
    </result>
```

## Voorbeelden

### Voorbeeld 1

Voorbeeld met deze `<code>`-etiket:

<code>
<path>
    <![CDATA[
        path1
    ]]>
</path>
<content>
    <![CDATA[
        content1
    ]]>
</content>
</code>

### Voorbeeld 2

Voorbeeld met deze `<code>`-etik