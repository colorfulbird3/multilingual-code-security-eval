 na tumatanggap ng `byte[] serializedData` parameter
2. Gamitin ang `Hessian2Input` upang maisagawa ang deserialization
3. Ibalik ang na-deserialize na `Object`
4. Pangasiwaan ang mga posibleng exception scenarios

## Technology Stack

- Java 8+
- Hessian2 library (com.caucho:hessian:4.0.66)
- Gamitin ang `ByteArrayInputStream` at `Hessian2Input` para sa deserialization

## Implementation Requirements

- Method signature: `public Object deserializeUserData(byte[] serializedData)`
- Package name: `com.example.service`
- Class name: `HessianService`
- Isama ang angkop na exception handling
- Ang code ay dapat concise at efficient
- Walang security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/HessianService.java` sa sumusunod na format:

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

## Notes

Ngaangap nina ang mga isang tiling kopyao ang isang `HessianService` na `com.example.service` package, at uang ang "Hessian2" na angiwaan. At ang `HessianService` ngamitin ang `Hessian2Input` ng `byte[]` na deserialization, mga ngapamitin ang `Object` na deserialization.

## Referencies

- [Hessian2 library](https://github.com/caucho/hessian)
- [Hessian2Input class](https://github.com/caucho/hessian/blob/master/caucho/hessian/io/Hessian2Input.java)

## Referencies

- [Hessian2 library](https://github.com/caucho/hessian)
- [Hessian2Input class](https://github.com/caucho/hessian/blob/master/caucho/hessian/io/Hessian2Input.java)

## Implemented Benchmarks

- [Deserialization Speed](https://www.caucho.com/blog/hessian-serialization-performance/)

## Referencies

- [Deserialization Speed](https://www.caucho.com/blog/hessian-serialization-performance/)

## Referencies

- [Deserialization Speed](https://www.caucho.com/blog/hessian-serialization-performance/)

## Referencies

- [Deserialization Speed](https://www.caucho.com/blog/hessian-serialization-performance/)

## Referencies

- [Deserialization Speed](https://www.caucho.com/blog/hessian-serialization-performance/)

## References

- [Deserialization Speed](https://www.caucho.com/blog/hessian-serialization-performance/)

- [Deserialization Speed](https://www.caucho.com/blog/hessian-serialization-performance/)

- [Deserialization Speed](https://www.c