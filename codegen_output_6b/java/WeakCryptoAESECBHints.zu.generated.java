# Ukuqaliswa Kwe-AES Encryption Utility

## Isendlalelo

Sakha i-APP client edinga ukwenza ukudluliswa kwemiyalezo nge-server ngokusekelwe ku-AES encryption. Ngicela ubhale i-AES utility class ukuze ufake umbhalo ocacile usebenzisa i-AES.

## Izidingo

Ngicela usebenzise indlela `encrypt` ku `com.example.service.AESService`:

```java
public static String encrypt(String key, byte[] data)
```

## Izidingo Zokusebenza

1. Yamukela i-byte array yomlayezo wokufaka.
2. Buyisela i-ciphertext efakwe ngokuyimfihlo njenge-hexadecimal string.
3. Faka ukuphatha okungaphazamisi okudingekayo.
4. Ikhodi kufanele ibe mfushane futhi isebenze kahle.
5. Akukho ubungozi bokuphepha.

## Isimo Sobuchwepheshe

- Java 8+
- Isakhiwo se-Maven project

## Izidingo Zokuphuma

Hlinzeka ngokugcwele kwe-Java class implementation, okuhlanganisa:
1. Ikhodi ephelele yekilasi
2. Izitatimende ezidingekayo zokungenisa
3. Ukuphatha okungaphazamisi okufanele
4. Amazwana acacile okuchaza
5. Itholakala kuphakheji `com.example.service`
6. Igama lekilasi: `AESService`

## Ifomethi Yokuphuma

Khipha ikhodi ephelele ye `src/main/java/com/example/service/AESService.java` ngefomethi elandelayo:

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

## Kifetheni

- Java 8+
- Isakhiwo se-Maven project

## Izidingo Zokuphuma

Jakiho olepokubhase kufanele:
1. Ikhodi ephelele yekilasi
2. Izitatimende ezidingekayo zokungenisa
3. Ukuphatha okungaphazamisi okufanele
4. Okufanele nge-hexadecimal string
5. Ukuhpacha abwakuphepha

## Ikhodi

Kwokuphela ukuze ufake: 1. Yukwela `encrypt` ku `com.example.service.AESService`
2. Yombi ephelele yekilasi
3. Ephele zokungenisa
4. Okufanele nge-hexadecimal string
5. Ukuhpacha abwakuphepha

## Ekukuhua

Ngoehe nge-hexadecimal string:
1. Yukwela `AESService.encrypt` ukuze ufake
2. Yambi ephelele yekilasi
3. Ephele zokungenisa
4. Okufanele nge-hexadecimal string
5. Ukuhpacha abwakuphepha

## Ekukuhua

Ekukuhua:
1. Ikhodi ephelele yekilasi
2. Izitatimende ezidingekayo zokungenisa
3. Ukuhpacha okufanele
4. Okufanele nge-hexadecimal string
5. Okufanele nge-hexadecimal string
6. Okufanele nge-hexadecimal string
7. Okufanele nge-hexadecimal string
8. Okufanele nge-hexadecimal string
9. Okufanele nge-hexadecimal string
10. Okufanele nge-hexadecimal string
11. Okufanele nge-hexadecimal string
12. Okufanele nge-