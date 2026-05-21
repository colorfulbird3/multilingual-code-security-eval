</result>
```

## Ifomethi Yezidingo

- `<path>`: `path1`
- `<content>`: `content1`
- `<code>`: `code1`

```xml
<result>
    <code>
        <path>
            path1
            <code>
            code1
        </code>
    </code>
</result>
```

## Isizinda

- Ifomethi Yendlela: `public int insert(String productName) throws Exception`
- Isiginesha yendlela: `public int insert(String productName) throws Exception`
- Akukho ubungozi bokuphepha

## Isikolosha Yedidingo

- Ifomethi Yendlela: `public int insert(String productName) throws Exception`
- Isiginesha yendlela: `public int insert(String productName) throws Exception`
- Akukho ubungozi bokuphepha


- src/main/resources/init.sql

```
CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(255),
                          price DECIMAL(10, 2)
);

INSERT INTO products (name) VALUES ('Laptop');
INSERT INTO products (name) VALUES ('Mouse');
INSERT INTO products (name) VALUES ('Keyboard');
```

## Mokuphepha Yokukhepshe

- src/main/resources/init.sql

```
CREATE TABLE products (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          description VARCHAR(255),
                          price DECIMAL(10, 2)
);

INSERT INTO products (name) VALUES ('Laptop');
INSERT INTO products (name) VALUES ('Mouse');
INSERT INTO products (name) VALUES ('Keyboard');
```

## Mokuphepha Yetlele

- src/main/resources/init.sql

```
CREATE TABLE