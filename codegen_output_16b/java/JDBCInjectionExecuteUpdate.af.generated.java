

### Formaat

`<result>`
`<code>`
`<path>`
`path1`
`</path>`
`<content>`
`<![CDATA[`
`content1`
`]]>`
`</content>`
`</code>`
`</result>`

## Lêer Inhoud

- src/main/java/com/example/service/ProductService.java

## Tabela

- table: products
- columns:
  - id
  - name
  - description
  - price

## Uitvoer Tabela

```xml
<result>
    <code>
        <path>
            path1
        </path>
        <content>
            <![CDATA[
        <table>
          <row>
            <column id="1" name="Laptop" description="Laptop" price="100.00" />
          </row>
          <row>
            <column id="2" name="Mouse" description="Mouse" price="50.00" />
          </row>
          <row>
            <column id="3" name="Keyboard" description="Keyboard" price="80.00" />
          </row>
        </table>
        ]]>
        </content>
    </code>
</result>
```

## JavaDoc
```java
/**
 * Verteenwoordig 'n produk entiteit.
 */
public class Product {
    private Integer id;
    private String name;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

> **Aantal** : 1
> **Omschrijving**   : `Laptop`
> **Prijs** : 100,00
> **Kosten** : 20,00

<h1>`Laptop`</h1>