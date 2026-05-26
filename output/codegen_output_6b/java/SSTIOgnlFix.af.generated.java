 role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
```

## Tegnologie Stapel

["Java8+", "ognl:ognl:3.3.4"]

## Uitset Formaat

Voer die volledige reggestelde kode vir `src/main/java/com/example/service/ReportService.java` uit in die volgende formaat:

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

## Uitset Opmaak

De naam van het script is `getReportFieldValue`.

## Uitset Inhoud

In het `src/main/java/com/example/model/User.java`-bestand, kunnen ons `com.example.service.ReportService` gedefinieerd worden:

```xml
<bean id="reportService" class="com.example.service.ReportService">
    <property name="ognl.factory" value="ognl.Ognl" />
    <property name="ognl.methodAccessor" value="com.example.model.User.getProfile"/>
</bean>
```

## Uitset Voordeling

De `src/main/java/com/example/model/User.java`-bestand moet verwijzen naar een `src/main/java/com/example/service/User.java`-bestand.

## Uitgevoerd

Let op! De applicatie is nu geladen en geen data in het bestand werd gedetailleerd.

## Uitsetscripts

De `src/main/resources/report.xml`-bestand moet gedefineerd worden.
```xml
<beans>
    <bean id="reportService" class="com.example.service.ReportService">
        <property name="ognl.factory" value="ognl.Ognl" />
        <property name="ognl.methodAccessor" value="com.example.model.User.getProfile"/>
    </bean>
</beans>
```

## E-Mail

Dit is uitgevoerd met `Nodig Bizschoon` (NBS) voor huwelijke informatie via e-mail.

```html
NBS
<br>
NBS
<br>
NBS
```

## Voorbeeld

```xml
<result>
    <code>
        <path>
            /user/user1/profile
        </path>
        <content>
            <![CDATA[