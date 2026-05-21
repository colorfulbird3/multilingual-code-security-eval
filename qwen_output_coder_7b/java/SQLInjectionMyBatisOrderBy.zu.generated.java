The provided XML snippet contains the source code of a Java class named `UserService` located in the package `com.example.service`. This class interacts with a database using a `UserMapper` to perform operations related to users. Below is a detailed breakdown of the class and its methods:

### Class Overview
- **Package**: `com.example.service`
- **Class Name**: `UserService`
- **Description**: The class provides methods to interact with user data, including retrieving users sorted by various fields.

### Dependencies
- **UserMapper**: An interface or class that provides methods to interact with the database.
- **User**: A model class representing a user.

### Methods

#### 1. `getUsersByOrder(String orderBy, String sortDirection)`
- **Purpose**: Retrieves a list of users sorted by a specified field and direction.
- **Parameters**:
  - `orderBy`: The field by which to order the results (e.g., "id", "username").
  - `sortDirection`: The direction of sorting ("ASC" for ascending, "DESC" for descending).
- **Returns**: A list of `User` objects.
- **Security Considerations**:
  - The method checks if the `orderBy` parameter is valid and not empty.
  - It ensures that the `sortDirection` parameter is either "ASC" or "DESC".
  - It validates the `orderBy` field against a whitelist of allowed fields to prevent SQL injection.

#### 2. `getAllUsers()`
- **Purpose**: Retrieves all users from the database.
- **Returns**: A list of `User` objects.

### Code Snippet
Here is the complete code snippet for reference:

```java
package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Isikole Sezinsizakalo Zomsebenzisi
 */
public class UserService {
    
    private UserMapper userMapper;
    
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    
    /**
     * Buza uhlu lwabasebenzisi ngokusekelwe enkambeni yokuhlunga nendawo yokuhlunga enikezwe umsebenzisi
     * Kusetshenziswa i-MyBatis dynamic SQL ukusebenzisa umsebenzi wokuhlunga we-ORDER BY
     * 
     * @param