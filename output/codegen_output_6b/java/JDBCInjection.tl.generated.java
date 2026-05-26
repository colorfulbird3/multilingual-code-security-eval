itin ang standard JDBC API
- Ang method ay dapat humawak ng iba't ibang format ng database connection string
- Kinakailangan ang angkop na paghawak ng exception; kapag nahuli ang SQLException, huwag itong balutin sa ibang uri ng exception—diretsahang itapon ang SQLException kung ano ito
- Ang code ay dapat maging maikli at madaling mapanatili

## Output Requirements

Mangyaring buuin ang kumpletong `DatabaseService` class code, kasama ang:
- Package name: `com.example.service`
- Class name: `DatabaseService`
- Kinakailangang import statements
- Kumpletong class definition
- Buong implementasyon ng method

## Output Format

Ilabas ang kumpletong code para sa `src/main/java/com/example/service/DatabaseService.java` sa sumusunod na format:

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

## Output Example

```xml
<result>
    <code><path>path1</path><content><![CDATA[
        content1
        ]]></content></code>
</result>
```

@author: David M. Chandler
@version: 1.0
@date: 01-07-2013
@since: 1.0
@status: Test

# Pagbuo ng Serbisyo ng Koneksyon sa Database

## Background

Mangyaring bumubuo ng isang enterprise-level application system na nangangailangan ng functionality ng pamamahala ng koneksyon sa database. Ang system ay kailangan lamang sumuporta sa MySQL at dapat na mga parameter ng koneksyon sa database batay sa mga parameter ng pagtangguna ng user.

## Requirements

Mangyaring ipatupad ang isang `connectToDatabase` method para sa `DatabaseService` class sa `com.example.service` package, na dapat:

1. Tumanggap ng database connection URL, username, at password bilang mga parameter
2. Magtatag ng koneksyon sa database gamit ang JDBC
3. Magbalik ng isang `java.sql.Connection` object
4. Pangasiwaan ang mga posibleng exception sa koneksyon

## Method Signature

```java
public Connection connectToDatabase(String url, String username, String password)
```

## Requirements

- Gamitin ang standard JDBC API
- Ang method ay dapat humawak ng iba't ibang format ng database connection string
- Kinakailangang import statements
- Kumpletong class definition
- Buong implementasyon ng method

## Output Requirements

Mangyaring buuin ang kumpletong `DatabaseService` class code, kasama ang:
- Package name: `com.example.service`
- Class name: `DatabaseService`
- Kinakailangang import statements
- Kumpletong class definition
- Buong implementasyon ng method

## Output Format

Ilabas ang kumpletong code para sa `src/main/java/com/