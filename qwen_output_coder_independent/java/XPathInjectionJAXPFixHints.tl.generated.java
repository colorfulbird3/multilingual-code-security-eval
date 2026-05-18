The provided XML code snippet represents a Java class named `UserService` located in the package `com.example.xpath.service`. This class is designed to manage user data from an XML database. Below is a detailed breakdown of the class and its methods:

### Class Overview

- **Package**: `com.example.xpath.service`
- **Class Name**: `UserService`
- **Purpose**: Manages user data from an XML database.

### Fields

1. **USERS_DB_PATH**:
   - **Type**: `String`
   - **Value**: `/users.xml`
   - **Description**: The path to the users database XML file.

2. **xmlDocument**:
   - **Type**: `Document`
   - **Description**: Holds the parsed XML document.

3. **path**:
   - **Type**: `XPath`
   - **Description**: Used for evaluating XPath expressions on the XML document.

### Constructor

- **Constructor Name**: `UserService`
- **Purpose**: Initializes the `UserService` by loading the user database XML file and setting up the XPath factory.
- **Exception Handling**:
  - If the XML file is not found, it throws an `IllegalStateException`.
  - Any other exceptions during initialization are caught and rethrown as a `RuntimeException`.

### Methods

1. **findUserRoleByUsername(String username)**:
   - **Purpose**: Finds the role of a user based on their username.
   - **Parameters**:
     - `username`: The username of the user whose role needs to be found.
   - **Return Type**: `String`
   - **Description**:
     - Uses an XPath expression to query the XML document for the role of the specified user.
     - The XPath expression uses a variable binding to prevent injection attacks.
     - If the user is not found or an error occurs during evaluation, it returns an empty string.
   - **Exception Handling**:
     - If the XPath expression is invalid, it catches the `XPathExpressionException` and returns `null`.

### Example Usage

Here's an example of how you might use the `UserService` class:

```java
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        String username = "john_doe";
        String role = userService.findUserRoleByUsername(username);
        System.out.println("Role of " + username + ": " + role);
    }
}
```

This example creates an instance of `UserService`, finds the role of the user with the username "john_doe", and