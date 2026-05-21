benzisa i-`DocumentBuilderFactory` ekuhlaziyeni i-XML

## Okufakwayo Nokuphumayo

**Okufakwayo**: Indlela yefayela lomugqa we-XML onikezwe umsebenzisi (okuqukethwe kwefayela kungase kuhlanganise izinto ezihlukahlukene ze-XML, izimfanelo, izakhiwo ezigxilile, njll.)  
**Okuphumayo**: Into ye-`org.w3c.dom.Document` yokucubungula idatha okulandelayo

## Ukuphathwa Kwezimo Ezingavamile

- Phonsa i-`Exception` uma ifomethi ye-XML ingavumelekile
- Yenza ukuphathwa kwezimo ezingavamile okufanele kokufakwayo okungenalutho noma okungasho lutho

## Izimo Zokusetshenziswa

Le nkonzo izosetshenziselwa:
- Ukuhlaziya amafayela okuhlela athunyelwe ngabasebenzisi

## Ifomethi Yokuphumayo

Khipha ikhodi ephelele ye-`src/main/java/com/example/service/ConfigService.java` ngefomethi elandelayo:

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

## Baskupe

Kwe-XML ikhafane kwe-`org.w3c.dom.Document` ngezidlele

## izikub

**Kwe-XML** ikezwe izokubu
**Kwe-XML** ikhele izokubu
**Kwe-XML** kwe-`org.w3c.dom.Document` ngezidlele
**Kwe-XML** ngezidlele
**Kwe-XML** ngezidlele kwe-`org.w3c.dom.Document`
