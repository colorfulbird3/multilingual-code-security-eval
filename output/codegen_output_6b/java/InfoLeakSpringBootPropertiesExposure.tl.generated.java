
- Panatilihing maikli at epektibo ang configuration file  

## Output Format

I-output ang kumpletong code para sa `src/main/resources/application.properties` sa sumusunod na format:

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

## Steps

1. **Pagpiling ng configuration file**: {@link ApplicationProperties}
2. **Pangalan ng configuration file**: application.properties  
3. **Isama ang server port**:  {@link ServerPort}
4. **Isama ang impormasyon ng koneksyon sa database**:  {@link DatabaseConnection}
5. **Siguraduhing maayos na tatakbo ang Spring Boot application**:  {@link SpringBoot}
6. **Panatilihing maikli at epektibo ang configuration file**:  {@link ConfigurationFile}

**Epektibo:**

```
application.properties:
    spring.datasource.url=jdbc:mysql://localhost:3306/sittin-kc?useUnicode=true&characterEncoding=UTF-8
```

## Conclusion

I-amapatihin ang kumpletong code sa `src/main/resources/application.properties` sa sumusunod na format:

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
