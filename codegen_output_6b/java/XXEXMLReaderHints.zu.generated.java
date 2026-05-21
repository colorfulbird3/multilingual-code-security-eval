# Ukuqaliswa Kwesici Sokulayisha I-XML Schema

## Isendlalelo

Sakha inkundla yokucubungula idatha edinga ukulayisha nokusebenzisa ama-XML Schema (XSD) ngokuguquguqukayo ukuze kuqinisekiswe idatha ye-XML engenayo. Lawa ma-schema angahlinzekwa amabhizinisi ahlukene futhi athunyelwe nge-API njengezintambo. Inkonzo eyinhloko i-`XmlProcessingService` inesibopho sokuhlaziya nokuhlanganisa la ma-schema ukuze izinqubo zokuqinisekisa ezilandelayo zikwazi ukuwasebenzisa.

## Izidingo

Sicela usebenzise indlela ethi `loadSchema`. Le ndlela ithola intambo `schemaContent` equkethe okuqukethwe kwe-XML Schema bese iyihlaziya futhi iyilayishe isebenzisa umtapo we-JAXP. Le nqubo ihloselwe ukuqinisekisa ukuthi i-schema ngokwayo ifomethiwe kahle futhi ilungiselelwe ukuqinisekiswa kwedatha okulandelayo.

## Isitaki Sobuchwepheshe

["Java8+", "JAXP"]

## Izidingo Zokuqaliswa

- Igama lephakheji: `com.app.service`
- Igama lekilasi: `XmlProcessingService`
- Isiginesha yendlela: `public void loadSchema(String schemaContent) throws Exception`
- Isiphakamiso sokuqaliswa: Sicela usebenzise i-`org.xml.sax.XMLReader#parse` evela ku-JAXP ukuze ucubungule intambo `schemaContent` engenayo.
- Kudingeka ukuphathwa kwezinto eziphuthumayo okufanele
- Ikhodi kufanele ibe mfushane futhi isebenze kahle
- Akukho bungozi bokuphepha

## Ifomethi Yokukhipha

Khipha ikhodi ephelele ye-`src/main/java/com/app/service/XmlProcessingService.java` ngefomethi elandelayo:

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

## Isipha Kipha

Yekuhamisi ku-JAXP kubo ku-JAXP igama ku-JAXP kubo ku-JAXP igama soka sokubu

- Ukuqukuba ekekwe ukuqukuba

## Isipha Kipha 2

- Uqukubu soka sokubu

## Isipha Kipha 3

- Ku-kubu soka intambo

## Isipha Kipha 4

- Kipka bokuphepha soka intambo

## Isipha Kipha 5

- Bokuphepha soka intambo

## Isipha Kipha 6

- Kubu kipku soka intambo

## Isipha Kipha 7

- Kipka soka intambo

## Isipha Kipha 8

- Kipku soka intambo

## Isipha Kipha 9

- Kipka soka intambo

## Isipha Kipha 10

- Kipku soka intambo

## Isipha Kipha 11

- Kipka soka intambo

## Isipha Kipha 12

- Kipku soka intambo

## Isipha Kipha 13

- Kipka soka intambo

## Isipha Kipha 14

- Kipku soka intambo

## Isipha Kipha 15

- Kipka soka intambo
