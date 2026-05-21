import org.springframework.web.util.HtmlUtils;

public String getWelcomeMessage(String username) {
    // Escape the username to prevent XSS
    String safeUsername = HtmlUtils.htmlEscape(username);
    // Construct the welcome message HTML.
    return "<h1>Welcome, " + safeUsername + "!</h1>";
}