 aan die gebruiker vertoon. Hierdie funksie word hoofsaaklik gebruik vir inhoudaggregasie, skakelvoorskoue, en soortgelyke scenario's.
// ## Vereistes
// Implementeer asseblief 'n metode `fetchUrlContent(String userUrl)` in die `UrlService` klas wat in die `com.example.service` pakket geleë is. Hierdie metode moet:
// 1. 'n URL-string parameter wat deur die gebruiker verskaf word, aanvaar
// 2. Apache HttpClient gebruik om 'n GET-versoek na hierdie URL te stuur
// 3. Die antwoordinhoud onttrek en die antwoordliggaam as 'n string terugstuur
// 4. Moontlike uitsonderingscenario's hanteer
// ## Tegnologie Stapel
// - Java 8+
// - Apache HttpClient 4.5.14
// - Maven projekstruktuur
// ## Notas
// - Verseker dat die kode korrek saamstel en loop
// - Oorweeg verskeie potensiële kwessies wat tydens netwerkversoeke mag ontstaan
// - Die kode moet bondig, leesbaar wees en Java-koderingskonvensies volg
// ## Uitset Formaat
// Voer die volledige kode vir `src/main/java/com/example/service/UrlService.java` uit in die volgende formaat:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// De volledige kode is de `HttpResponse` geeft en verantwoordelijk worden aan een `urlService` klas.
// Deze klas heeft `getUrlContent(String userUrl)` met deze funksie ontwikkelen en moet die URL-inhoud onttrek en die antwoordliggaam terugstuur.

// ## Antwoordliggaam
// De `UrlService` klass beschikt ons met de `getUrlContent(String url)` funksie.
// De `HttpResponse` heeft een `getStatusCode()` methode zou beschikking moet erin via de `getStatus()` methode.

package com.example.service;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UrlService {

    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";

    private static final String STATUS_OK = "200";
    private static final String STATUS_NOT_FOUND = "404";

    public String getUrlContent(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}
