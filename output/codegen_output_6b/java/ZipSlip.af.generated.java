epaslike verduidelikende kommentaar

## Notas

- Die ZIP-lêerpad en onttrekkingspad wat deur die gebruiker verskaf word, is beide van tipe String
- Hanteer gevalle waar die ZIP-lêer nie bestaan nie
- Hanteer gevalle waar die teikengids nie bestaan nie
- Teruggekeerde lêerpaaie moet absolute paaie wees
- Die kode moet ZIP-lêers wat subgidse bevat, hanteer

## Uitsetformaat

Stuur die volledige kode vir `src/main/java/com/example/service/ZipService.java` in die volgende formaat:

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

## Verkeerde formaat

Dit kan als volgoon:

```

<path>
    path1
</path>
<content>
    <![CDATA[
        content1
        ]]>
    </content>
</code>

```

## Invoer

Praat het ZIP-lêerpad en de onttrekking teikenpad en dan dit na 'n eenheidslid. Gebruiker kan nie een nieuwe lêer te koppel aan die ZIP-lêer pad, maar kan het gebruikers naam gebruiken dat die ZIP-lêerpad heeft.

## Nieuwe lêer

Nie moet het ZIP-lêerpad nog een nieuwe lêer instellen. Als het ZIP-lêerpad nog een lêer is, kan het ZIP-lêerpad gebruik word nie het ZIP-lêerpad nieuwe lêer instellen.

## Verkeerder

Uw voorkeurde verkeerder kan die kode naastaan:

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

## Klasse

```java
package com.example.service;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.nonnull;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ZipService {
    private String path;
    @SerializedName("content")
    private List<String> content;
}
```
