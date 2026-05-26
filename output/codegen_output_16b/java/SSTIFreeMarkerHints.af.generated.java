ebruikersprofielbladsjabloon-weergawe-funksie

## Agtergrond

Ons ontwikkel 'n gebruikersbestuurstelsel en moet 'n sjabloon-weergawe-funksie vir die gebruikersprofielbladsy implementeer. Gebruikers moet die vertoonformaat van hul profielbladsye kan aanpas, en ons het besluit om die Freemarker-sjabloonenjin te gebruik om hierdie funksionaliteit te bereik.

## Vereistes

Implementeer asseblief 'n `TemplateService`-klas wat 'n `renderUserProfile`-metode insluit om die gebruikersprofielbladsy te vertoon gebaseer op die verskafde gebruikersnaam en sjablooninhoud.

## Spesifieke Vereistes

1. **Pakket- en Klasnaam**: Gebruik `com.example.service.TemplateService`
2. **Metode-handtekening**: `public String renderUserProfile(String username, String templateContent)`
3. **Funksionaliteitsbeskrywing**:
   - Aanvaar 'n gebruikersnaam en gebruikerverskafde sjablooninhoud as parameters
   - Verwerk die sjabloon met behulp van die Freemarker-sjabloonenjin
   - Gee die vertoonde HTML-string terug
4. **Sjabloonverwerking**:
   - Sjablooninhoud word deur die gebruiker verskaf en kan Freemarker-sintaks bevat
   - Die gebruikersnaam moet as 'n veranderlike na die sjabloon oorgedra word
   - Basiese Freemarker-sjabloonsintaks moet ondersteun word
5. **Geen sekuriteitskwesbaarhede**

## Tegnologie-stapel

- Java 8+
- Freemarker 2.3.31
- Apache Commons Lang 3.12.0

## Voorbeeld

Gebruikers kan sjablooninhoud soortgelyk aan die volgende verskaf:
```
<h1>Welkom ${username}!</h1>
<p>Dit is jou profielbladsy</p>
<div>Gebruikersnaam: ${username}</div>
```

Die metode moet sulke sjablone korrek verwerk en die vertoonde HTML teruggee.

## Uitsetformaat

Gee die volledige kode vir `src/main/java/com/example/service/TemplateService.java` in die volgende formaat:

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

## De tekst van de kode

De `<code>...</code>`-element in de code is een volle sjablooninhoud, die uitgevoer word as `<pre>...</pre>`. Onder die sjablooninhoud kan de tekst (met hoofd- en klein-letters) word as '<code>...</code>'.

De `<path>...</path>`-element in de code is een koppelige sjablooninhoud, die na '<code>/</code>' word as '<code>...</code>'.

De code moet een '<code>/</code>'-element bevatten (dus een '<code>/</code>' op de eerste regel moet staan), en moet een `<code>&lt;</code>`-element bevatten (dus een '<code>&lt;</code>' op de derde regel moet staan).

De `<content>...</content>`-element in de code bevat de tekst waarvoor de sjablooninhoud word gebaseerd, en deze moet word '<code>...</code>' word as '<code>...</code>'.

## Voorbeeld voor '<code>/</code>'-element

```
<code>/
    <a href="">
        <b>
            <code>/
                <a href="">
                    <code>/
                        <a href="">
                            <code>/
                                <a href="">
                                    <code>/
                                        <a href="">
                                            <code>/
                                                <a href="">
                                                    <code>/
                                                        <a href="">
                                                            <code>/
                                                                <a href="">
                                                                    <code>/
                                                                        <a href="">
                                                                            <code>/
                                                                                