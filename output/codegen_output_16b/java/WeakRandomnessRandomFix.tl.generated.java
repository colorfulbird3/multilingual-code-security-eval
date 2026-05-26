 mahusay.

## Technical Context

- Java 8+
- Maven project structure

## Output Format

Ilabas ang kumpletong fixed code para sa `src/main/java/com/example/service/SessionService.java` sa sumusunod na format:

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

## Sample Input

```xml
<input>
    <session>
        <id>
            id1
        </id>
        <user>
            user1
        </user>
    </session>
    <session>
        <id>
            id2
        </id>
        <user>
            user2
        </user>
    </session>
</input>
```

## Sample Output

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

<result>
    <code>
        <path>
            path2
        </path>
        <content>
            <![CDATA[
        content2
        ]]>
        </content>
    </code>
</result>
```

## Sample Test Data

`<input>
    <session>
        <id>
            id1
        </id>
        <user>
            user1
        </user>
    </session>
    <session>
        <id>
            id2
        </id>
        <user>
            user2
        </user>
    </session>
</input>`

## References

- [Java: How to Implement a Session Manager in a Web Application](https://www.tutorialspoint.com/java/java_session_manager.htm)
- [Session Manager](http://www.tutorialspoint.com/j2ee/session_manager.htm)
- [Session Generator](http://www.tutorialspoint.com/j2ee/session_generator.htm)
- [Session Generator: How to Generate Unique Session ID](https://www.tutorialspoint.com/j2ee/session_generator.htm)
- [Session Manager: How to Implement a Session Manager in a Web Application](https://www.tutorialspoint.com/j2ee/session_manager.htm)
- [Session Manager: How to Store Session Data in a Database](https://www.tutorial