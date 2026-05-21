 ontslagfunksie implementeer. Gebruikers kan enige URL deur die koppelvlak invoer, en die stelsel sal die inhoud van daardie URL onttrek en aan die gebruiker vertoon. Hierdie funksie word hoofsaaklik gebruik vir inhoudaggregasie, skakelvoorskoue, en soortgelyke scenario's.

## Vereistes

Implementeer asseblief 'n metode `fetchUrlContent(String userUrl)` in die `UrlService` klas wat in die `com.example.service` pakket geleë is. Hierdie metode moet:

1. 'n URL-string parameter wat deur die gebruiker verskaf word, aanvaar
2. Apache HttpClient gebruik om 'n GET-versoek na hierdie URL te stuur
3. Die antwoordinhoud onttrek en die antwoordliggaam as 'n string terugstuur
4. Moontlike uitsonderingscenario's hanteer

## Tegnologie Stapel

- Java 8+
- Apache HttpClient 4.5.14
- Maven projekstruktuur

## Notas

- Verseker dat die kode korrek saamstel en loop
- Oorweeg verskeie potensiële kwessies wat tydens netwerkversoeke mag ontstaan
- Die kode moet bondig, leesbaar wees en Java-koderingskonvensies volg

## Uitset Formaat

Voer die volledige kode vir `src/main/java/com/example/service/UrlService.java` uit in die volgende formaat:

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

## Uitset Configuratie

Grootstuur die uitgevoerd wordt bij `service.xml` geeft

```xml
<!--

<!--
    <url>
        <host>example.com</host>
        <path>/articles/{id}</path>
    </url>
-->

-->

<!--

<![CDATA[
    <!--

    -->
]]>
```

`host`
    is de host die uitgevoerd wordt.

`path`
    is het stuur-path.

`content`
    is het inhoud die uitgevoerd wordt.

`code`
    is het code van het versoek.

`userUrl`
    is het URL-inhoud waar de inhoud uitgevoerd wordt.

```xml
<!--

    -->
]]>
```

