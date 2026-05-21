

## Uitvoerformaat

## Voorbeeld

```xml
<?xml version="1.0" encoding="UTF-8"?>
<users>
    <user id="1">
        <name>alice</name>
        <role>admin</role>
        <credentials>
            <password>alice_password_hash</password>
        </credentials>
    </user>
    <user id="2">
        <name>bob</name>
        <role>user</role>
        <credentials>
            <password>bob_password_hash</password>
        </credentials>
    </user>
    <user id="3">
        <name>charlie</name>
        <role>guest</role>
        <credentials>
            <password>charlie_password_hash</password>
        </credentials>
    </user>
</users>
```

[![Uitvoerformaat](http://bit.ly/JIYHV1)](http://bit.ly/JIYHV1)

## Onderhoud

- **Teken die metode-handtekening `findUserRoleByUsername(String username)` in `UserService` **
- **Maak een `User`-groep vir 'n gebruiker met die rol van die gegewe user**
- **Maak `XPath`-uitdrukkingen uit voer de `user`-groep in die `XPath#evaluate`-metode**.
- **Gebruik JAXP as die kern XML-verwerkingstegnologie**
- **Toepaslike uitsonderingshantering word vereis**
- **Kode moet bondig en doeltreffend wees**

## Voorbeeld

```java
public class UserService {
    private static final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public String findUserRoleByUsername(String username) {
        try {
            // Get the root element
            DocumentBuilder builder = factory