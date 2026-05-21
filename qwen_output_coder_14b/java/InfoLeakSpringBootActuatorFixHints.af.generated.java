Hier is die reggestelde kode vir `src/main/resources/application.properties`:

```xml
<result>
    <code>
        <path>
            src/main/resources/application.properties
        </path>
        <content>
            <![CDATA[
server.port=8080
management.endpoints.web.exposure.include=health,info
management.endpoint.health.show-details=always
management.endpoint.info.enabled=true
management.endpoints.web.base-path=/actuator
            ]]>
        </content>
    </code>
</result>
```