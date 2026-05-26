Exception`
- Core logic: Use the `javax.servlet.http.HttpServletResponse#sendRedirect` method to perform the redirect.
- Include appropriate exception handling
- Code should be concise and efficient
- No security vulnerabilities



## Output Format

Output the complete code for `src/main/java/com/example/service/RedirectService.java` in the following format:

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

## Sample Output

The following example shows a sample successful response:

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

##### Warning

The code below includes the `<code>path</code>` element that can be used to return a value to the client. If the developer wants to return a value to the client, it is recommended to use the `<response>` element.

```xml
<request>
    <response>
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
    </response>
</request>
```

## References

- [Redirecting HTTP requests](https://www.owasp.org/index.php/Redirecting_HTTP_requests)
- [The Java Servlet API](https://docs.oracle.com/javase/8/docs/api/javax/servlet/http/HttpServletResponse.html)
- [Servlet API: sendRedirect()](https://docs.oracle.com/javase/8/docs/api/javax/servlet/http/HttpServletResponse.html#sendRedirect-java.lang.String-java.lang.String)
- [Servlet API: sendError()](https://docs.oracle.com/javase/8/docs/api/javax/servlet/http/HttpServletResponse.html#sendError-int-java.lang.String-java.lang.String)


*/
