

## Ifomethi Okuhle

Okuhle ikhodi ephelele elungisiwe ye-`src/main/java/com/example/service/TemplateService.java` ngefomethi elandelayo:

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

`<result>` insekela ulodzi ethempulethi okuthi elodzi, lwe-HTML ehleliwe.
`<code>` insekela ulodzi ethempulethi okuthi elodzi, lwe-Freemarker ehleliwe.
`<path>` insekela ulodzi ethempulethi okuthi elodzi, lwe-Freemarker ehleliwe.
`<content>` insekela ulodzi ethempulethi okuthi elodzi, lwe-Freemarker ehleliwe.

1. **Path**: path1
2. **Content**: content1
3. **Code**: `<![CDATA[
content1
]]>`

## Ifomethi Okuthi

Okuthi ikhodi ephelele elungisiwe ye-`src/main/java/com/example/service/TemplateService.java` ngefomethi elandelayo:

```xml
<result>
    <code>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

1. **Content**: content1

## Ukubongulela

Ukubongulela ikhodi ephelele elungisiwe ye-`src/main/java/com/example/service/TemplateService.java` ngefomethi elandelayo:

```xml
<result>
    <code>
        <path>
            <content>
