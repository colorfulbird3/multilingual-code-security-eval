 Yamukele ipharamitha yomugqa we-URL enikezwe umsebenzisi
2. Isebenzise i-Apache HttpClient ukuthumela isicelo se-GET kule URL
3. Ithole impendulo yokuqukethwe bese ibuyisela umzimba wempendulo njengomugqa
4. Iphathe izimo ezingaba khona zamaphutha

## Ubuchwepheshe Obusetshenzisiwe

- Java 8+
- Apache HttpClient 4.5.14
- Isakhiwo sephrojekthi ye-Maven

## Amanothi

- Qinisekisa ukuthi ikhodi iyahlanganiswa futhi isebenza kahle
- Cabangela izinkinga ezahlukahlukene ezingase zivele ngesikhathi sezicelo zenethiwekhi
- Ikhodi kufanele ibe mfushane, ifundeke kalula, futhi ilandele izimiso zokubhala ikhodi ze-Java

## Ifomethi Yokukhipha

Khipha ikhodi ephelele ye-`src/main/java/com/example/service/UrlService.java` ngefomethi elandelayo:

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

## Ukuqukethwe

Ukuqalise okuqukethwe ki-URL wena njengomugqa, ukuthumela i-Apache HttpClient kumle se-GET. Selinga ukuthi `HttpGet` ezinga ukuthumela `EntityUtils.toString(HttpEntity.getContent())`.

## Ukuthumelayo

Selinga ukuthumelayo kumle wenye-Apache HttpClient, ukuthumela `EntityUtils.toString(HttpEntity.getContent())`.

## I-URL

Isikuhlela njenga ukuthumela i-URL `/index.html`.

## Ikuhlele

Ikuhlele njenga ukuthumela i-URL `/index.html?param1=value1&param2=value2`.

## Ekukhiphashe

Ikuhlele njenga ukuthumela ekukhiphashe `/index.html?param1=value1&param2=value2`.

## Isikuhlele

Isikuhlele njenga ukuthumela i-URL `/index.html?param1=value1&param2=value2` wenye ekukhiphashe `param1=value1&param2=value2`.

## Umzima

Ikuhlele njenga ukuthumela i-URL `/index.html?param1=value1&param2=value2` wenye ekukhiphashe `param1=value1&param2=value2`, ukubuka umzima ezi kuqukethwe.

## Ukuhlele

Ikuhlele njenga ukuthumela i-URL `/index.html?param1=value1&param2=value2` wenye ekukhiphashe `param1=value1&param2=value2`, ukubuka umzima ezi kuqukethwe.

## Ekukhiphashe

Ikuhlele njeng