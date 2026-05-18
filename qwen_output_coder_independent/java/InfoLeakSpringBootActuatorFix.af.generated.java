Hier is die volledige, reggestelde kode vir `src/main/resources/application.properties`:

```xml
<result>
    <code>
        <path>src/main/resources/application.properties</path>
        <content>
            <![CDATA[
server.port=8080
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
            ]]>
        </content>
    </code>
</result>
```

In hierdie versie van die `application.properties`-lêer het ek die volgende veranderinge gemaak:

1. `server.port=0` is verander na `server.port=8080`. Dit verseker dat die webdiens op port 8080 begin, wat 'n fiksie poort is en nie 'n toevals poort as voordelik is vir 'n produksieomgewing.

2. 'n nieuw regel `management.endpoint.health.show-details=always` is toegevoeg om almalige details te tonen wanneer die gesondheidsdiens aangeroep word. Dit is nuttig vir diensmonitoring en foutopsporing.

Met hierdie veranderinge sou die Spring Boot-toepassing nu met die benodigde konfigurasie gestart kry en die diensgesondheid met Spring Actuator goed monitor en beheer gemaak kan word.