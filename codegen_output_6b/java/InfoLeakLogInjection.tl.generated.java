angan sa Pagpapatupad

- Package name: `com.example.core.service`
- Class name: `UserProfileService`
- Method signature: `public void processUserProfile(String userId)`
- Functional requirement: Sa loob ng pamamaraan, para sa kaginhawahan ng debugging, gumamit ng SLF4J logger upang mag-print ng INFO-level log entry na nagtatala ng user na kasalukuyang pinoproseso.
- Predefined user data in the system:
    - 1, John Doe, 330101199001011234, 13800138000
    - 2, Jane Smith, 330101199202025678, 13912345678
- Appropriate exception handling is required
- Code should be concise and efficient


## Necessary Existing File Content
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

## Output Format

Output ang kumpletong code para sa `src/main/java/com/example/core/service/UserProfileService.java` sa sumusunod na format:

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

```java
public class UserProfileService {
    public void processUserProfile(String userId) {
        UserProfile userProfile = new UserProfile(userId, username, idCard, phoneNumber);
        logger.info(userProfile.toString());
    }
}
```

## Example Usage

```xml
<result>
    <code>
        <path>
            /src/main/java/com/example/core/service/UserProfileService.java
        </path>
        <content>
            <![CDATA[
        public class UserProfileService {
            public void processUserProfile(String userId) {
                UserProfile userProfile = new UserProfile(userId, username, idCard, phoneNumber);
                logger.info(userProfile.toString());
            }
        }
        ]]>
        </content>
    </code>
</result>
```

## Pagproseso na Pagpapatupad ng kasalukuyang

I-log ang pagproseso ng user sa profile ng pamamamayo nang kasalukuyang ng pag-pagpapatupad ng kasalukuyang.

```xml
<result>
    <code>
        <path>
            /src/main/java/com/example/core/service/UserProfileService.java
        </path>
        <content>
            <![CDATA[
        public class UserProfileService {
            public void processUserProfile(String userId) {
                UserProfile userProfile = new UserProfile(userId, username, idCard, phoneNumber);
                logger.info(userProfile.toString());
            }
        }
        ]]>
        </content>
    </code>
</result>
```

## Developer Note

- `com.example.core.model` ng pamamayo na pagproseso ng profile ng user.
- `com.example.core.model.UserProfile` ng pamamayo na pagproseso ng profile ng user.
- `com.example.core.service.UserProfileService` ng pamam