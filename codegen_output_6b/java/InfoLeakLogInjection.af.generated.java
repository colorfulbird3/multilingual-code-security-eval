 INFO-vlak-aantekening te druk wat die gebruiker wat tans verwerk word, aanteken.
- Voorafbepaalde gebruikersdata in die stelsel:
    - 1, John Doe, 330101199001011234, 13800138000
    - 2, Jane Smith, 330101199202025678, 13912345678
- Toepaslike uitsonderingshantering word vereis
- Kode moet bondig en doeltreffend wees

## Nodige Bestaande Lêerinhoud
- src/main/java/com/example/core/model/UserProfile.java
```java
package com.example.core.model;

/**
 * Represents a user's profile data.
 */
public class UserProfile {

    private String userId;
    private String username;
    private String idCard;
    private String phoneNumber;

    public UserProfile(String userId, String username, String idCard, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
```

## Uitvoerformaat

Voer die volledige kode vir `src/main/java/com/example/core/service/UserProfileService.java` uit in die volgende formaat:

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

## Example

```xml
<result>
    <code>
        <path>
            {path}
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Bepaal Uitvoer

## Kode

## Uitvoer

## Debug

```xml
<code>
    <path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </path>
</code>
```
