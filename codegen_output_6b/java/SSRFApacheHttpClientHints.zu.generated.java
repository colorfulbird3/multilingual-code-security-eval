ethwe, ukubuka kwangaphambili kwezixhumanisi, nezimo ezifanayo.

## Izidingo
Sicela usebenzise indlela `fetchUrlContent(String userUrl)` ekilasini `UrlService` elitholakala kuphakheji `com.example.service`, okufanele:

1. Yamukele ipharamitha yomugqa we-URL enikezwe umsebenzisi
2. Sebenzisa i-Apache HttpClient ukuthumela isicelo se-GET kule URL
3. Thola okuqukethwe kwempendulo bese ubuyisela umzimba wempendulo njengomugqa
4. Phatha izimo ezingaba khona ze-exception

## Ubuchwepheshe Obusetshenzisiwe

- Java 8+
- Apache HttpClient 4.5.14
- Isakhiwo sephrojekthi ye-Maven

## Amanothi

- Qinisekisa ukuthi ikhodi iyahlanganiswa futhi isebenza kahle
- Cabangela izinkinga ezahlukahlukene ezingase zivele ngesikhathi sezicelo zenethiwekhi
- Ikhodi kufanele ibe mfushane, ifundeke, futhi ilandele izimiso zokubhala ikhodi ze-Java
- Akukho ubungozi bokuphepha

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

```xml
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

## Umsebenzisi

Sekufulasi okubunza, njengezwera, sekubu zimbele, sekubu ubuyisela, sekubu zivele, sekubu kubewe, sekubu kwumbele, ukubu kubewe, sezimozi, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe, sekubu kubewe, sekubu zivishe, sekubu kubewe