

## Ngoedila Yokuphuma

Zithuthukisa ngoedila ezize kwi-`TestData` ukufanele okufele ka `XMLSerializationService` olumela:

```xml
<TestData>
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
</TestData>
```

## Isendlalelo
Sithuthukisa uhlelo lwe-Java oludinga isevisi yokuhlela ukuze kusekelwe ukuqina kwezinto nokudluliswa kwenethiwekhi. Le sevisi idinga ukuhlela izinto zibe amaqoqo amabhayithi futhi ihlehlise izinto ezivela emaqoqweni amabhayithi.

```java
public class SerializationService {
    public Object deserializeObject(byte[] serializedData) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bi = new ByteArrayInputStream(serializedData);
        ObjectInputStream oi = new ObjectInputStream(bi);
        Object ret = oi.readObject();
        bi.close();
        return ret;
    }
}
```

## Izidingo
Sicela usebenzise indlela ethi `deserializeObject` ekilasini elithi `SerializationService` elitholakala kuphakheji elithi `com.example.service`, okufanele:

1. Yamukele ipharamitha ethi `byte[] serializedData`, okuyidatha ehleliwe enikezwe umsebenzisi
2. Sebenzisa i-`ObjectInputStream` ukwenza ukuhlehlisa
3. Buyisela into ehlehlisiwe (yohlobo lwe-`Object`)
4. Phatha izimo ezingaba khona zamaphutha

## Amaphuzu Obuchw