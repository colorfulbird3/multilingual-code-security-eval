

## Uitvoerformaat

Voer die volledige reggestelde kode via `applicationContext.xml`
in die volgende formaat uit:

```xml
<bean id="schemaManagerService" class="com.example.service.SchemaManagerService">
    <property name="dataSource" ref="dataSource"/>
</bean>
```
