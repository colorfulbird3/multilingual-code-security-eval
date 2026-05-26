

## OGNL Uitdrukkingen

[OGNL: ognl:3.3.4]

## Uitdrukkingen

Be dit voorbeeld:

```
public class ReportService {

    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}
```

## Resultaat uitdrukking

Be dit voorbeeld:

```
<result>
    <code>
        <path>
            pad1
        </path>
        <content>
            <![CDATA[
            inhoud1
            ]]>
        </content>
    </code>
</result>
```

## De tekstinhoud

```xml
    <result>
        <code>
            <path>
                pad1
            </path>
            <content>
                <![CDATA[
                inhoud1
                ]]>
            </content>
        </code>
    </result>
```

## Formaat

```xml
    <result>
        <code>
            <path>
                &lt;path&gt;
            </path>
            <content>
                &lt;![CDATA[
                <content>
                ]]&gt;
            </content>
        </code>
    </result>
```

## Voorbeeld

Be dit voorbeeld:

```
<result>
    <code>
        <path>
            pad1
        </path>
        <content>
            <![CDATA[
            inhoud1
            ]]>
        </content>
    </code>
</result>
```

## Ons Bestaande Lêerinhoud Vereis
- src/main/java/com/example/model/User.java

```package com.example.model;

/**
 * Verteenwoordig 'n gebruikerdataobjek.
 */
public class User