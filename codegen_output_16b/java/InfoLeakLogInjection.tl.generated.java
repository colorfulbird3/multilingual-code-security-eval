
        </path>
        <content>
            <![CDATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## Sample Test File

```xml
<run>
    <test-file>src/main/java/com/example/core/service/UserProfileService.java</test-file>
    <input-file>src/main/java/com/example/core/model/UserProfile.java</input-file>
    <output-file>src/main/java/com/example/core/service/UserProfileService.java</output-file>
    <options>
        <remove-comments>false</remove-comments>
        <remove-whitespaces>false</remove-whitespaces>
        <format>true</format>
        <line-separator>\n</line-separator>
        <indent>tab</indent>
        <tab-width>3</tab-width>
        <case>lower</case>
        <indent-char>\t</indent-char>
        <wrap-outer>true</wrap-outer>
        <wrap-inner>true</wrap-inner>
        <wrap-line-length>80</wrap-line-length>
        <no-prepend-semicolon>false</no-prepend-semicolon>
        <comments-preserve-white-spaces>true</comments-preserve-white-spaces>
        <keep-directives>false</keep-directives>
        <remove-directives>false</remove-directives>
        <keep-extra-whitespaces>true</keep-extra-whitespaces>
        <error-on-unmatched-tags>false</error-on-unmatched-tags>
        <error-on-unknown-tags>true</error-on-unknown-tags>
    </options>
</run>
```

## References
- https://github.com/mkyong/fluent-hibernate-examples
- https://github.com/mkyong/fluent-hibernate-examples/blob/master/examples/jpa/hibernate/jpa_hibernate_example.xml
- http://stackoverflow.com/questions/27272234/jaxb-