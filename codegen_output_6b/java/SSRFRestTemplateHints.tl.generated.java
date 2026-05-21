SpringApplication.run(Application.class, args);
    }

    /**
     * Registers RestTemplate as a Spring Bean for reuse throughout the application.
     * @return RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```


## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/WebPageFetcherService.java` sa sumusunod na format:

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

## Example

```

```bash
$ java -jar target/application-0.1.jar http://example.com/path/to/page
```


## Refactor

- Refactor to use a simple interface for fetching the page content.
- Refactor to use the same code for both reading and writing the response.
- Refactor to use different HTTP methods.
- Refactor to use a custom Spring Bean.
- Refactor to use more sophisticated error handling.
- Refactor to use more advanced class-based HTTP request/response protocol.
- Refactor to use a Spring Bean.





## Learn More

- [Spring Boot](https://spring.io/guides/tutorials/web-application-development/index.html)
- [Getting Started](https://github.com/spring-projects/spring-boot)
- [The Spring Web Boot Project](http://spring.io/guides/spring-web-programming/index.html)
- [The Spring Framework](http://docs.spring.io/spring/docs/current/spring-framework.html)
- [The Spring Boot Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/index.html)
- [The Spring Boot Website](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/index.html)
- [The Spring Boot Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/index.html)
- [The Spring Framework Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/index.html)
- [The Spring Boot Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/index.html)
- [The Spring Framework Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/index.html)
- [The Spring Boot Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/index.html)
- [The Spring Boot Documentation](http://docs.spring.io