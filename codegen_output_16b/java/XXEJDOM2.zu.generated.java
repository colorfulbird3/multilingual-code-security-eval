

## Ifomethi Tshihlwebele

Tshihlwebele ifomethi ukiphezise ikiphezisa:

```xml
<?xml version="1.0" encoding="utf-8"?>
<message>
  <header>
    <group>
      <name>group1</name>
    </group>
    <host>
      <name>host1</name>
    </host>
  </header>
</message>
```

## Ikhodi Ufumfannele

Ifomethi ukufannele yebilele:

```xml
<message>
  <header>
    <group>
      <name>group1</name>
    </group>
    <host>
      <name>host1</name>
    </host>
    <host>
      <name>host2</name>
    </host>
  </header>
  <body>
    <hello>world</hello>
  </body>
</message>
```

## Ikhodi Ufumfannele Zokuqalisa

Ifomethi ukufannele zokuqalisa yebilele:

```java
String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
             "<message>\n" +
             "  <header>\n" +
             "    <group>\n" +
             "      <name>group1</name>\n" +
             "    </group>\n" +
             "    <host>\n" +
             "      <name>host1</name>\n" +
             "    </host>\n" +
             "    <host>\n" +
             "      <name>host2</name>\n" +
             "    </host>\n" +
             "  </header>\n" +
             "  <body>\n" +
             "    <hello>world</hello>\n" +
             "  </body>\n" +
             "</message>";
