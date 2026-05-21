 profile data model.
 * This class is used for marshalling and unmarshalling user data from XML.
 */
@XmlRootElement(name = "userProfile")
public class UserProfile {

    private String name;
    private String email;
    private long userId;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                '}';
    }
}
```

## Ifomethi Yokukhipha

Khipha ikhodi ephelele ye-`src/main/java/com/example/datamodel/service/DataProcessingService.java` ngefomethi elandelayo:

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

## Obusetshenziswe

- Lekosha
- Ndleleba ku-JAXB
- Kumingabeku ukuze yapu:
- Unmarshal user data from XML to `com.example.datamodel.model.UserProfile`
- Marshal `com.example.datamodel.model.UserProfile` to XML

# Sebenzisa

- Obusetshenzisiwe:

```

<!--
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
-->
```

## Zokusebenza

- I-JAXB futhi ku-JAXB
- Isizinda
- Izidingo Zokusebenza

```java
public void processUserProfile(java.lang.String xmlData) {
    JAXBContext context = JAXBContext.newInstance(com.example.datamodel.model.UserProfile.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    try {
        UserProfile userProfile = (UserProfile) unmarshaller.unmarshal(new StringReader(xmlData));
        System.out.println(userProfile);
    } catch (JAXBException e) {
        e.printStackTrace();
    }
}
```

## Ugwaprofheti

- Igama ku-JAXB ukuze
- Igama ku-JAXB futhi
- Ugwaprofheti

```java
<!--
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
-->
```