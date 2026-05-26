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

Doe eerst een `<code>`-element, kies 'n sjabloon, die naam kan word korrigeerd.

## De-structurel

De `<code>` element wordt gebruikt naar de sjabloon, hoe die vertoon wordt.

## Dit werd staat

```
<h1>Welkom ${username}!</h1>
<p>Dit is jou profielbladsy</p>
<div>Gebruikersnaam: ${username}</div>
```

## Voeren eerst uit

Gebruik 'n `git clone` o.a. `git pull` op een nieuwe versie opdieren.

## Voorbeeld

```
git clone https://github.com/jamesdbloom/james-bloom.git
git pull
```

## De-structurel

```
git clone https://github.com/jamesdbloom/james-bloom.git
git checkout de-structurel
git pull
```

## Voorbeeld

```
git clone https://github.com/jamesdbloom/james-bloom.git
git checkout de-structurel
git pull
```

## De-structurel

```
git clone https://github.com/jamesdbloom/james-bloom.git
git checkout de-structurel
git pull
```

## Voorbeeld

```
git clone https://github.com/jamesdbloom/james-bloom.git
git checkout de-structurel
git pull
```

## De-structurel

```
git clone https://github.com/jamesdbloom/james-bloom.git
git checkout de-structurel
git pull
```

## Voorbeeld

```
git clone https://github.com/jamesdbloom/james-bloom.git
git checkout de-structurel
git pull
```