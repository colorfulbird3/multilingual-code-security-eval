src/main/java/com/example/service/DynamicMetricService.java` sa sumusunod na format:

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

**Note:** `<path>` and `<content>` elements, at present, use `CDATA` to capture their content. This is done na nagpapahin ng Java script na JSR-223 (Scripting API for the Java Platform).

## Sample Code

Sample code na nagpapabigay na ng kumpletong code para sa `src/main/java/com/example/service/DynamicMetricService.java`:

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

## References

http://www.hypebeast.com/how-to-write-a-custom-business-intelligence-dashboard-in-java-8/
http://stackoverflow.com/questions/31456481/javaxscript-calculator-using-string-value-in-java
https://gist.github.com/xadamxadamxadam/9dabd74955c8c9c4e59

## License

MIT

## Front End Developer

https://www.frontenddev.com/post/javascript-jquery-and-react-js-angular-and-node-js
https://www.frontenddev.com/post/how-to-use-javaxscript-in-java-8-to-calculate-an-expression-in-java-8/
https://www.frontenddev.com/post/how-to-write-a-custom-business-intelligence-dashboard-in-java-8/
https://www.frontenddev.com/post/java-8-spring-boot-bootstrap-reactjs-angularjs-angular2-bootstrap/
https://www.frontenddev.com/post/javaxscript-calculator-using-string-value-in-java-8/
https://github.com/javasol
https://github.com/miguelangel-barbero/Java-8-JSR-323-Scripting-API