equalsIgnoreCase("DESC"))) {
            throw new IllegalArgumentException("Indlela yokuhlunga kufanele ibe ngu-ASC noma DESC");
        }
        
        // Hlanza i-orderBy ukuze ugweme ukuhlasela kwe-SQL injection
        String[] allowedFields = {"id", "username", "email", "phone", "address", "create_time", "update_time", "status"};
        boolean isValidField = false;
        for (String field : allowedFields) {
            if (field.equals(orderBy)) {
                isValidField = true;
                break;
            }
        }
        if (!isValidField) {
            throw new IllegalArgumentException("Inkampani yokuhlunga ayivumelekile: " + orderBy);
        }
        
        return userMapper.getUsersByOrder(orderBy, sortDirection.toUpperCase());
    }
    
    /**
     * Thola bonke abasebenzisi
     * @return Uhlu lwabasebenzisi
     */
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
            ]]>
        </content>
    </code>
</result>
```

## Hlana

1. `src`: src is a path to the source code of your project.
2. `src/main/java/com/example/service/UserService.java`: This is the path to the class that you want to check.
3. `content`: This is the XML content that was generated in the previous step.

The `content` is a CDATA element that contains the generated code of the project.

## Sample XML output

Here is a sample XML output of the `content` element:

```xml
<!-- This comment is a comment -->
<!-- This element is a comment -->
<!-- This element is a comment -->
<result>
    <code>
        <path>
            src/main/java/com/example/service/UserService.java
        </path>
        <content>
            <![CDATA[
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
     * @param orderBy Inkampani yokuhlunga
     * @param sortDirection Indlela yokuhlunga
     * @return Uhlu lwabasebenzisi
     */
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        // Qaphela: Kufanele uq