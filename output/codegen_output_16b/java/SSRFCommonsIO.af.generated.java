

### TIP

Als u die kode aanpass wou die kode doeltreffend maak, dan kan die uitset metode weer met een `byte[]` teruggevraagde inhoud.

### AANTALENDE TIP

Als u die kode doeltreffend maak, dan moet u die `byte[]` terugstuur na 'n `String` tipe teruggevraagde inhoud.

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

En dit is waarom die inhoud na 'n `String` word, omdat die `String` die inhoud van 'n `byte[]` kan weer terugstuur na die `toString`-metode.

### KOMMENTARE

Als u die kode doeltreffend maak, dan moet u die code na 'n `String` terugstuur na 'n `byte[]` teruggevraagde inhoud.

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

En dit is waarom die `String` die inhoud van 'n `byte[]` kan weer terugstuur na die `toString`-metode.

## Aantal kode

U gaan maar 'n paar funksies in de kode te implementeer:

**getResourceContent**: Die funksie maakt u aan met `byte[]` terug te stuur die geïnhouden inhoud van een geldige URL.
**doHttpRequest**: De funksie maakt u aan met `byte[]` terug te stuur de binêre inhoud van een geldige URL.

Die funksies kan u mo