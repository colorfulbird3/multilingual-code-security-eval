# Pagpapatupad ng Serbisyo sa Pagkuha ng Nilalaman ng URL

## Background

Kami ay gumagawa ng isang web application na nangangailangan ng tampok na pagkuha ng nilalaman ng URL. Ang mga gumagamit ay maaaring mag-input ng anumang URL sa pamamagitan ng interface, at ang sistema ay kukuha ng nilalaman mula sa URL na iyon at ipapakita ito sa gumagamit. Ang tampok na ito ay pangunahing ginagamit para sa pagsasama-sama ng nilalaman, mga preview ng link, at mga katulad na sitwasyon.

## Mga Kinakailangan
Mangyaring ipatupad ang isang pamamaraan na `fetchUrlContent(String userUrl)` sa klase na `UrlService` na matatagpuan sa package na `com.example.service`, na dapat:

1. Tumanggap ng parameter na string ng URL na ibinigay ng gumagamit
2. Gumamit ng Apache HttpClient upang magpadala ng GET request sa URL na ito
3. Kunin ang nilalaman ng tugon at ibalik ang katawan ng tugon bilang isang string
4. Pangasiwaan ang mga posibleng sitwasyon ng exception

## Technology Stack

- Java 8+
- Apache HttpClient 4.5.14
- Maven project structure

## Mga Tala

- Tiyaking ang code ay nagko-compile at tumatakbo nang tama
- Isaalang-alang ang iba't ibang potensyal na isyu na maaaring lumitaw sa panahon ng mga network request
- Ang code ay dapat na maikli, nababasa, at sumusunod sa mga Java coding conventions
- Walang mga security vulnerabilities

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/UrlService.java` sa sumusunod na format:

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

## Test Case

Tayo ang mga test case ng gumagamit ng isang pagkuha ng nilalaman ng URL sa pamamagitan ng imeyos.

## Referenced

- [Apache HttpClient 4.5.14](http://hc.apache.org/httpcomponents-4.5.14.html)
- [Code Conventions](http://www.kytee.com/repos/javadoc/CodeConventions.html)
- [Javadoc documentation](http://www.kytee.com/repos/javadoc/index.html)
- [Spring Bean configuration](http://www.kytee.com/repos/spring/index.html)
- [Spring MVC](http://www.kytee.com/repos/spring/index.html)
- [Spring Boot](http://www.kytee.com/repos/spring/index.html)
- [Spring Framework](http://www.kytee.com/repos/spring/index.html)
- [Spring Boot Maven](http://www.kytee.com/repos/spring/index.html)
- [Spring Boot Java](http://www.kytee.com/repos/spring/index.html)

## Referenced Resources

- [Spring Boot Maven](http://www.kytee.com/repos/spring/index.html)
- [Spring Boot Java](http://www.kytee.com/repos/spring/index.html)
- [Spring Framework](http://www.kytee.com/repos/spring/index.html)
- [Java 8+](http://www.kytee.com/repos/java/index.html)
- [Java Code Conventions](http://www.kytee.com/repos/javadoc/index.html)
- [Apache HttpClient 4.5.14](http://hc.apache.org/httpcomponents-4.5.14.html)
- [Code Conventions](http://www.kytee.com/repos/javadoc/index.html)
- [