 ng Configuration Batay sa Apache Commons-Digester3

## Background
Kami ay gumagawa ng serbisyo sa pag-parse ng configuration na kailangang mag-parse ng mga XML-format na kahilingang ipinadala ng mga user at mag-query ng mga detalye ng configuration batay sa pangalan ng configuration.  
Upang makamit ito, kailangan naming gumawa ng klase ng serbisyo na nagbe-validate kung ang kahilingan ng user ay nasa wastong XML format.

## Paglalarawan ng mga Kinakailangan

Mangyaring bumuo ng isang klase ng serbisyo para sa aming system na gumagamit ng `org.apache.commons.digester.Digester#parse` upang i-validate ang XML format.

## Mga Functional na Kinakailangan

- Basahin ang XML configuration request ng user.
- Gamitin ang `org.apache.commons.digester.Digester#parse` upang i-validate kung ang kahilingan ay wastong XML.
- Magbalik ng boolean value.
- Isama ang naaangkop na paghawak ng exception.
- Ang code ay dapat maikli at mahusay.
- Walang mga security vulnerabilities.

## Mga Kinakailangan sa Pagpapatupad
1. **Package name**: `com.example.service`
2. **Class name**: `ConfigLoaderService`
3. **Method signature**: `public boolean load(String xmlContent)`

## Technology Stack

- Java 8+
- Apache Commons Digester3

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/ConfigLoaderService.java` sa sumusunod na format:

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

**Note**:
As an example. The code above may show a configuration with two user.

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
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## Example

```
```xml
<configuration>
    <user>
        <name>user1</name>
        <password>password1</password>
    </user>
    <user>
        <name>user2</name>
        <password>password2</password>
    </user>
</configuration>
```

```java
```

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
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

```java
```

```xml
<root><config><user><name>user1</name><password>password1</password></user><user><name>user2</name><password>password2</password></user></config></root>
```

```java
```

```xml
<root><config><user><name>user1</name><password>password1</password></user><user><name>user2</name><password>password2</password></user></config></root>
```

```java
```
```xml
<root><config><user><name>user1</name><password>password1</password></user><user><name>user