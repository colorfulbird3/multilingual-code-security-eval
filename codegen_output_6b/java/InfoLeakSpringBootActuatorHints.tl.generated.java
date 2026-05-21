result>
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

## Pag-configure ng Endpoint para sa Pagsubaybay sa Kalusugan ng Serbisyo

- Kumplekta ng pag-configure ng Endpoint

```xml
<mvc:annotation-driven/>

<mvc:resources/>

<mvc:resources mapping="/images/**"/>

<mvc:resources mapping="/css/**"/>

<mvc:resources mapping="/js/**"/>

<mvc:resources mapping="/resources/**"/>

<mvc:resources mapping="/templates/**"/>

<mvc:resources mapping="/views/**"/>

<mvc:resources mapping="/**/*.html"/>

<mvc:resources mapping="/**/*.properties"/>

<mvc:resources mapping="/**/*.xml"/>

<mvc:resources mapping="/**/*.json"/>

<mvc:resources mapping="/**/*.txt"/>

<mvc:resources mapping="/**/*.gif"/>

<mvc:resources mapping="/**/*.jpg"/>

<mvc:resources mapping="/**/*.png"/>

<mvc:resources mapping="/**/*.svg"/>

<mvc:resources mapping="/**/*.zip"/>

<mvc:resources mapping="/**/*.gz"/>

<mvc:resources mapping="/**/*.tar"/>

<mvc:resources mapping="/**/*.tar.gz"/>

<mvc:resources mapping="/**/*.jar"/>

<mvc:resources mapping="/**/*.war"/>

<mvc:resources mapping="/**/*.tar.bz2"/>

<mvc:resources mapping="/**/*.tar.xz"/>

<mvc:resources mapping="/**/*.gz"/>

<mvc:resources mapping="/**/*.zip"/>

<mvc:resources mapping="/**/*.jar"/>

<mvc:resources mapping="/**/*.war"/>

<mvc:resources mapping="/**/*.tar"/>

<mvc:resources mapping="/**/*.tar.bz2"/>

<mvc:resources mapping="/**/*.tar.xz"/>

<mvc:resources mapping="/**/*.tar.lzma"/>

<