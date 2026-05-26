The provided Java code snippet demonstrates a service class named `TemplateService` that uses the FreeMarker templating engine to generate HTML content dynamically based on user input. This approach allows for flexible and customizable content generation, which is particularly useful in web applications where user-specific data needs to be displayed in a structured format.

### Key Features of the Code:

1. **FreeMarker Configuration**: The `Configuration` object is set up to load templates from the classpath, using UTF-8 encoding. This setup is essential for rendering templates correctly.

2. **Rendering Method**: The `renderUserProfile` method takes two parameters: `username` and `templateContent`. It checks if these parameters are not blank and throws an exception if they are. This ensures that the method receives valid input.

3. **Template Processing**: The method creates a `Template` object using the provided `templateContent`. It then populates a data model with the `username` and processes the template with this model, writing the output to a `StringWriter`.

4. **Exception Handling**: The method includes try-catch blocks to handle potential `IOException` and `TemplateException` exceptions, converting them into more generic `RuntimeExceptions` with descriptive messages.

### Usage Example:

If a user provides a template like:

```html
<h1>Welcome, ${username}!</h1>
<p>This is your profile page.</p>
<div>Your username is: ${username}</div>
```

The `renderUserProfile` method will replace `${username}` with the actual username value, resulting in personalized HTML content.

### Dependencies:

To run this code, you need the following dependencies:

- Java 8 or later
- FreeMarker 2.3.31
- Apache Commons Lang 3.12.0

### Deployment:

To deploy this service, ensure that the `TemplateService` class is placed in the correct package (`com.example.service`) and that all dependencies are included in your project's build path.

This approach provides a robust solution for generating dynamic content in Java applications, leveraging the power of templating engines to separate business logic from presentation.