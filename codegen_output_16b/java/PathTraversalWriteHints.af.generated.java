  - `content`: Die inhoud wat geskryf moet word, verskaf deur die gebruiker (String tipe)
- **Terugkeerwaarde**: boolean tipe, wat aandui of die skryfoperasie suksesvol was
- **Funksionaliteit**: Skryf die verskafde inhoud na die lêer by die gespesifiseerde pad

### Implementeringsvereistes
1. Die metode moet enige lêerpad wat deur die gebruiker verskaf word, hanteer
2. Die metode moet enige inhoud wat deur die gebruiker verskaf word, kan skryf
3. As die lêer nie bestaan nie, moet dit 'n nuwe lêer skep
4. As die lêer reeds bestaan, moet dit die oorspronklike inhoud oorskryf
5. Die metode moet die resultaat van die skryfoperasie teruggee (gee waar terug by sukses, onwaar by mislukking)

### Notas
- Pakketnaam: `com.example.service`
- Klasnaam: `FileService`
- Die gebruiker mag 'n relatiewe pad of 'n absolute pad verskaf
- Die gebruiker mag leë inhoud of nul inhoud verskaf
- Die gebruiker mag 'n ongeldige lêerpad verskaf
- Lêerstelsel toestemmingskwessies moet oorweeg word
- Geen sekuriteitskwesbaarhede nie

## Uitsetformaat

Voer die volledige kode vir `src/main/java/com/example/service/FileService.java` uit in die volgende formaat:

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

### Uitsetformaat voorgeleverde

1. <code>path</code> en <code>content</code> moeten 'n String tipe bevatten, met 'n <code>CDATA</code> waardes voor die content.
2. Die waardes moeten in hun eigen einde bevoele worden.

### Opdracht formaat

```xml
<result>
    <code>
        <path>
            path1
            path2
        </path>
        <content>
            content1
            content2
            content3
        </content>
    </code>
</result>
```

### Opdracht formaat voorgeleverde

1. Die waardes moeten in hun eigen einde bevoele worden.

### Geldige opdrachten

1. <code>path</code> en <code>content</code> moeten 'n String tipe bevatten, met 'n <code>CDATA</code> waardes voor die content.
2. <code>code</code> moet 'n String tipe bevatten waarmee de geldige informasie word.
3. <code>result</code> moet 'n String tipe bevatten waarmee de werk in deze service uitgevoer word.

### Geldige opdrachten voorgeleverde

1. <code>path</code> moet 'n String tipe bevatten waarmee de pad naar het lêerpad word.
2. <code>content</code> moet 'n String tipe bevatten waarmee de inhoud naar het lêerpad word.
3. <code>code</code> moet 'n String tipe bevatten waarmee de tekst in de code word.
4. <code>result</code> moet 'n String tipe bevatten waarmee de tekst in de resultaat word.

### Nota's voor de implementatie
- De gebruiker