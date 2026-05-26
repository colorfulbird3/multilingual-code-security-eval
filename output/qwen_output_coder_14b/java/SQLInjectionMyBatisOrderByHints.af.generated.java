The provided XML snippet contains Java code for a `UserService` class within the package `com.example.service`. This class interacts with a `UserMapper` to retrieve and manipulate user data. Here's a breakdown of the key components and functionalities:

### Key Components

1. **Class Definition**:
   - The class `UserService` is defined to handle business logic related to users.

2. **Dependencies**:
   - It depends on `UserMapper` for database operations.
   - It uses `User` model objects to represent user data.

3. **Constructor**:
   - The constructor initializes the `UserMapper` instance.

4. **Methods**:
   - `getUsersByOrder(String orderBy, String sortDirection)`: Retrieves a list of users sorted based on the specified field and direction. It includes validation for the input parameters to prevent SQL injection.
   - `validateOrderByField(String orderBy)`: Validates the order-by field against a list of allowed fields to ensure security.
   - `getAllUsers()`: Retrieves all users from the database.

### Detailed Method Descriptions

#### `getUsersByOrder(String orderBy, String sortDirection)`
- **Purpose**: Fetches a list of users sorted by a specified field and direction.
- **Parameters**:
  - `orderBy`: The field by which to sort the users (e.g., "id", "username").
  - `sortDirection`: The direction of sorting ("ASC" for ascending, "DESC" for descending).
- **Validation**:
  - Checks if `orderBy` or `sortDirection` is null or empty.
  - Validates the `sortDirection` to be either "ASC" or "DESC".
  - Validates the `orderBy` field against a predefined list of allowed fields to prevent SQL injection.
- **Implementation**:
  - Uses the `userMapper` to fetch the sorted list of users.

#### `validateOrderByField(String orderBy)`
- **Purpose**: Ensures that the provided order-by field is valid and safe to use in SQL queries.
- **Parameters**:
  - `orderBy`: The field to validate.
- **Implementation**:
  - Compares the `orderBy` field against a list of allowed fields.
  - Throws an `IllegalArgumentException` if the field is not valid.

#### `getAllUsers()`
- **Purpose**: Fetches all users from the database.
- **Implementation**:
  - Calls the `getAllUsers` method of `userMapper`.

### Security Considerations
- The method `getUsersByOrder` includes validation for both the `orderBy` field and the `sortDirection` to prevent SQL injection attacks. This is crucial for ensuring the security of the application.

### Conclusion
The `UserService` class is well-structured to handle user-related business logic, including sorting and retrieving user data securely. It leverages dependency injection for the `UserMapper` and includes validation checks to protect against potential security vulnerabilities.