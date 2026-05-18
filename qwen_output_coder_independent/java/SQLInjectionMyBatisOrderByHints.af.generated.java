The provided XML code snippet represents a Java class named `UserService` located in the package `com.example.service`. This class interacts with a database using a `UserMapper` interface to perform operations related to users. Below is a detailed breakdown of the class and its methods:

### Class Overview

- **Package**: `com.example.service`
- **Class Name**: `UserService`
- **Description**: A service class that handles user-related operations.

### Dependencies

- **UserMapper**: An interface used to interact with the database.
- **User**: A model class representing a user.

### Methods

1. **Constructor**
   ```java
   public UserService(UserMapper userMapper) {
       this.userMapper = userMapper;
   }
   ```
   - Initializes the `UserService` with an instance of `UserMapper`.

2. **getUsersByOrder**
   ```java
   public List<User> getUsersByOrder(String orderBy, String sortDirection) {
       // Validate input parameters
       if (orderBy == null || orderBy.trim().isEmpty()) {
           throw new IllegalArgumentException("Sort field cannot be empty");
       }
       if (sortDirection == null || sortDirection.trim().isEmpty()) {
           throw new IllegalArgumentException("Sort direction cannot be empty");
       }

       // Validate sort direction
       String direction = sortDirection.trim().toUpperCase();
       if (!"ASC".equals(direction) && !"DESC".equals(direction)) {
           throw new IllegalArgumentException("Invalid sort direction: " + sortDirection + ". Only ASC or DESC is supported");
       }

       // Validate sort field against allowed fields
       String validOrderBy = validateOrderByField(orderBy.trim());

       return userMapper.getUsersByOrder(validOrderBy, direction);
   }
   ```
   - Retrieves users sorted by a specified field and direction.
   - Validates the input parameters (`orderBy` and `sortDirection`).
   - Converts the sort direction to uppercase and validates it.
   - Validates the sort field against a list of allowed fields.
   - Calls the `getUsersByOrder` method of `UserMapper` to fetch the users.

3. **validateOrderByField**
   ```java
   private String validateOrderByField(String orderBy) {
       // List of allowed fields
       String[] allowedFields = {"id", "username", "email", "phone", "address", "create_time", "update_time", "status"};

       for (String field : allowedFields) {
           if (field.equalsIgnoreCase(orderBy)) {
               return field;
           }
       }

       throw new IllegalArgumentException("