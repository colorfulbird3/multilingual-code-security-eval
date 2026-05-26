Thank you for sharing the information about the security vulnerability related to Cross-Site Scripting (XSS) and the example provided. It's important to address such vulnerabilities to ensure the security of web applications.

In the given Java code, the `MessageService` class constructs an HTML welcome message using the username directly from the request parameter. This can lead to XSS if an attacker provides a malicious script as the username.

To mitigate this risk, you should sanitize or encode the input before including it in the HTML output. Here's an updated version of the `getWelcomeMessage` method that uses HTML escaping to prevent XSS:

```java
import org.springframework.web.util.HtmlUtils;

public String getWelcomeMessage(String username) {
    // Escape the username to prevent XSS
    String safeUsername = HtmlUtils.htmlEscape(username);
    // Construct the welcome message HTML.
    return "<h1>Welcome, " + safeUsername + "!</h1>";
}
```

By using `HtmlUtils.htmlEscape`, any special HTML characters in the username will be converted to their corresponding HTML entities, making it safe to include in the HTML output.

This is a simple yet effective way to protect against XSS attacks. Always ensure to validate and sanitize user inputs whenever they are used in constructing HTML or other types of output in web applications.