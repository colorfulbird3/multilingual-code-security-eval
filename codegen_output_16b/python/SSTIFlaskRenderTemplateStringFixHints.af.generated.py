

## Uitvoer: Ons twee profile banners

Ons maak twee profile banners:

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

<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## Uitvoer: Ons een profile banners voor onsself

Ons maak ons een profile banners voor onsself:

```xml
<result>
    <code>
        <path>
            path3
        </path>
        <content>
            <![CDATA[
        content3
        ]]>
        </content>
    </code>
</result>
```

## Handtekening

Dit is ons eerste handtekening. De handtekening is gerouteerde (doe nie op de eerste manier). De handtekening maak die binnenskryting tussen de code en de content word met de 'kode' naam.

<!--
    <result>
        <code>
            <path>
                path1
            </path>
            <content>
                <![CDATA[
                content1
                ]]>
                <!-- De handtekening -->
                <!-- De handtekening -->
            </content>
        </code>
    </result>
-->

## Aantekening

De aantekening is wat ons doe wat hieronder. De aantekening maakt de binningskryting tussen de code en de content word met de 'code' naam.

## Afhanklikheid

De afhanklikheid is dat de code niet deel is van de aantekening. De code word berekend tussen