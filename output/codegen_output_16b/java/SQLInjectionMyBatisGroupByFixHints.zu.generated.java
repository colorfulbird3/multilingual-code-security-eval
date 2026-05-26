

Qoqa ngesiwinxo ngesiwinxo:

```java
@XmlRootElement
public class Code {
    @XmlElement
    private Path path; // path element
    @XmlElement
    private Content content; // content element
}
```

Path sezibelo:

```java
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Path {
    @XmlElement
    private String path; // path element
}
```

Content sezibelo:

```java
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Content {
    @XmlElement
    private String content; // content element
}
```

### Isitaki Zokuthuthuki
- Qoqa ngesiwinxo: `getSalesByGroup("region")`
- Qoqa ngesigaba somkhiqizo: `getSalesByGroup("product_category")`
- Qoqa ngomthengisi: `getSalesByGroup("sales_person")`

## Utsindileba Jihlaela
- Jihlaela kwakhoqoqo: `getSalesByGroup("")`

## Utsindileba Ixebo
- Ixebo kwakhoqoqo: `getSalesByGroup(null, "")`

## Isina ngozi ngefomethi:
- Inkoqo ngesiwinxo: `getSalesByGroup("")`
- Inkoqo ngesigaba somkhiqizo: `getSalesByGroup("")`
- Inkoqo ngomthengisi: `getSalesByGroup("")`

## Isina ngozi ngesiwinxo:
- Inkoqo ngesiwinxo: `getSalesByGroup("region")`
- Inkoqo ngesigaba somkhiqizo: `getSalesByGroup("product_category")`
- Inkoqo ngomthengisi: `getSalesByGroup("sales_person")`

