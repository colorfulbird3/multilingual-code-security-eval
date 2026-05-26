

    @GetMapping(value = "/welcome")
    public String getWelcomeMessage(@RequestParam(value = "name", defaultValue = "World") String name) {
        return messageService.getWelcomeMessage(name);
    }
}
```

## Output Format

I-output ang kumpletong code para sa `src/main/java/com/example/service/MessageService.java` sa sumusunod na format:

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

- output ng i-input ang `src/main/java/com/example/controller/MessageController.java` sa sumusunod na format:

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

**BONUS**

- Bonus:

- What is the `getWelcomeMessage` method?
- What is the `String username` parameter?
- What is the `Spring Web framework` requirement?
- What is the `Application` class?
- What is the `Application.main` method?
- What is the `Spring Application` class?
- What is the `Spring Framework` component?
- What is the `package name` (`com.example.service`)
- What is the `import statement` (`import org.springframework.boot.SpringApplication;`)
- What is the `implementation requirement` (`public static void main(String[] args) { SpringApplication.run(Application.class, args); }`)

**BONUS**

- Bonus:

- What is the `Spring Application` class?
- What is the `Spring Framework` component?
- What is the `Spring Application` class?
- What is the `Spring Framework` component?

**BONUS**

- Bonus:

- What is the `Spring Framework` component?
- What is the `Spring Framework` component?
- What is the `Spring Application` class?
- What is the `Spring Framework` component?

**BONUS**

- Bonus:

- What is the `Spring Framework` component?
- What is the `Spring Framework` component?
- What is the `Spring Application` class?
- What is the `Spring Framework` component?

**BONUS**

- Bonus:

- What is the `Spring Framework` component?
- What is the `Spring Framework` component?
- What is the `Spring Application` class?
- What is the `Spring Framework` component?
- What is the `Spring Framework` component?

