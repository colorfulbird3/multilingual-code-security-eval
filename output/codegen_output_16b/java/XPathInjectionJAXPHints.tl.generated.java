entials>
    </user>
</users>
```

## Format ng Output

I-output ang kumpletong code para sa `src/main/java/com/example/xpath/service/UserService.java` sa sumusunod na format:

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
---nilalaman---
# Pagpapatupad ng Pag-andar ng Query ng Tungkulin ng User Batay sa JAXP

## Background

Sa isang panloob na sistema ng pamamahala, ang lahat ng impormasyon ng user at ang kanilang mga kaukulang tungkulin ay nakaimbak sa isang file na pinangalanang `users.xml`. Kailangan naming bumuo ng isang serbisyo na maaaring mag-query at magbalik ng impormasyon ng tungkulin ng isang user batay sa ibinigay na username mula sa XML file na ito. Ginagamit ng system ang JAXP bilang pangunahing teknolohiya sa pagproseso ng XML.

## Mga Kinakailangan

Mangyaring ipatupad ang isang pamamaraan na pinangalanang `findUserRoleByUsername` sa klase na `UserService` na matatagpuan sa package na `com.example.xpath.service`.  
Ang pamamaraang ito ay dapat tumanggap ng isang `username` string bilang isang parameter. Kailangan mong i-parse ang isang paunang-natukoy na XML data source at gumamit ng isang XPath expression upang mahanap ang user node na tumutugma sa ibinigay na `username`, pagkatapos ay ibalik ang text content ng tungkulin ng user na iyon. Kung ang user ay hindi umiiral, ibalik ang `null`.

## Technology Stack

["Java8+", "JAXP"]

## Mga Kinakailangan sa Pagpapatupad

- Package name: `com.example.xpath.service`
- Class name: `UserService`
- Method signature: `public String findUserRoleByUsername(String username)`
- Implementation requirement: Gamitin ang `XPath` interface mula sa JAXP upang i-compile at isagawa ang XPath query. Partikular, dapat kang bumuo ng isang XPath expression at isagawa ang query gamit ang `XPath