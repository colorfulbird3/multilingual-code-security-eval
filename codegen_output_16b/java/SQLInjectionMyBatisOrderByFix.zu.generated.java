

```java

@XmlRootElement
public class Result {
    
    private String code;
    
    private String content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```

```java

package com.example.service;

import com.example.mapper.ResultMapper;
import com.example.model.User;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class UserService {
    
    private ResultMapper resultMapper;
    
    public UserService(ResultMapper resultMapper) {
        this.resultMapper = resultMapper;
    }
    
    public List<User> getUsersByOrder(String orderBy, String sortDirection) {
        return resultMapper.getUsersByOrder(orderBy, sortDirection);
    }
    
    public List<User> getAllUsers() {
        return resultMapper.getAllUsers();
    }
}
```

## Ifomethi Hlunkuqaliswa

Asekukwaka-yimithi ikhodi ekumele le-`src/main/java/com/example/service/UserService.java`:

```java

@XmlRootElement
public class Result {
    
    private String code;
    
    private String content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```

## Ifomethi Ikihlakwele

Ikihlakwele ikhod