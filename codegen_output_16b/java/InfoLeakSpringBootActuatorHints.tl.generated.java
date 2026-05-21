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

## Example Code

```java
@RestController
public class DateController {

    @RequestMapping("/date")
    public String date(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

}
```

## References

- [Spring Boot Actuator: Sub-domain and Mvc Endpoint](https://spring.io/blog/2014/08/15/spring-boot-actuator-sub-domain-and-mvc-endpoint)
"""
