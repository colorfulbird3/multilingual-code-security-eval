

Ek wil hier de volgende reggestelde kode en die uit te sturen.

```java
package com.example.core.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DateController {

    @RequestMapping("/date")
    public String date() {
        return "date " + new Date();
    }
}
```

## Uitvoer

Ek wil hier de volledige reggestelde kode en die uit te sturen.

```java
import com.example.core.controller.DateController;

public class Main {
    public static void main(String[] args) {
        new DateController().date();
    }
}
```

## Output

Er zal een response voor de request gegenereerd worden. 

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
            date 2015-09-01 15:22:25
            ]]>
        </content>
    </code>
</result>
```

## Uitvoer

Hier is de uitvoer uit van die kode:

```java
public class DateController {
    @RequestMapping("/date")
    public String date() {
        return "date " + new Date();
    }
}
```

## Uitvoer voor bestaande lêer

Voeg de volgende reggestelde kode uit voor die bestaande lêer in die volgende formaat:

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
</result