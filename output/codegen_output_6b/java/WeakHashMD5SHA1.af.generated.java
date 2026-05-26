struktuur

## Uitsetvereistes

Verskaf asseblief die volledige Java-klasimplementering, insluitend:
1. Volledige klas-kode
2. Nodige invoerstellings
3. Toepaslike uitsonderingshantering
4. Duidelike verduidelikende kommentaar
5. Geleë in die `com.example.service`-pakket
6. Klasnaam: `HashService`

## Uitsetformaat

Gee die volledige kode vir `src/main/java/com/example/service/HashService.java` in die volgende formaat:

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

Dit spaties `<code>path</code>` en `<![CDATA[content]]>`

## Voorbeeld

```
public class HashService {
    public static String hash(String data) {
        byte[] bytes = digestBytes(data.getBytes());
        return bytesToHex(bytes);
    }
}
```

## Kode blokkering

Wat die kode blokkering is:

```
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

Wat die kode blokkering is:

```
public class HashService {
    public static String hash(String data) {
        byte[] bytes = digestBytes(data.getBytes());
        return bytesToHex(bytes);
    }
}
```

## Uienskap

## Uienskap

- [Java8b](https://www.youtube.com/watch?v=bxh2qV8f0WQ)
- [Maven](https://maven.apache.org/en/latest/)
- [Java-API](https://javadocs.io/api/java/util/concurrent/ConcurrentHashMap.html)

## Boodskap-opsomming

- [JavaDoc](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html)
- [JavaDoc](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html#get(java.lang.Object)boolean)
- [JavaDoc](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html#remove(java.lang.Object)boolean)

## Boodskap-opsomming (Hash-waarde)

- [Java