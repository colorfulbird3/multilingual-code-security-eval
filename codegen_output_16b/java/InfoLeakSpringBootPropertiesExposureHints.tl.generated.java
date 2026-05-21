-output ang kumpletong code para sa `src/main/resources/application.properties` sa sumusunod na format:

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

**Mga tabla ng kumpleterong code:**

```
<![CDATA[
        <key>
            <value>
                <![CDATA[
        <string>value1</string>
                ]]>
            </value>
        </key>
        <key>
            <value>
                <![CDATA[
        <string>value2</string>
                ]]>
            </value>
        </key>
    ]]>
    <![CDATA[
    ]]>
</result>
```

## References

- `https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#application-properties`
- `https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-web-application-properties`

## Implementing the configuration properties

The configuration file has a lot of keys. So we will be only using a few of them.

### Path

The path is the name of the configuration file that is going to be used.

### Content

The content is the value that is going to be used in the configuration file.

### Example

```
    path: application.properties
    content:
        key:value
```

## Unit Testing

## Testing the configuration properties

We are going to test the configuration file `application.properties` using the following code:

```java
    @Test
    public void testApplicationProperties() {
        ApplicationProperties applicationProperties = new ApplicationProperties();
        applicationProperties.setPath("application.properties");
        applicationProperties.setContent("key:value");

        assertTrue(applicationProperties.getContent().equals("key:value"));
        assertTrue(applicationProperties.getPath().equals("application.properties"));
    }
```

## Sample Output

```java
    @Test
    public void testApplicationProperties() {
        ApplicationProperties applicationProperties = new ApplicationProperties();
        applicationProperties.setPath("application.properties");
        applicationProperties.setContent("key:value");

        assertTrue(applicationProperties.