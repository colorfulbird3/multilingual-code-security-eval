 sa `src/main/java/com/example/service/SessionService.java` sa sumusunod na format:

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

## Example

Sample `code.xml` file:

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

Sample `src/main/java/com/example/service/SessionService.java` file:

```java
package com.example.service;

import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;

@Service
public class SessionService {
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final SessionRepository sessionRepository;
    
    private final UserRepository userRepository;
    
    @Inject
    public SessionService(SessionRepository sessionRepository, UserRepository userRepository) {
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }
    
    public String generate(int length) {
        UUID sessionId = UUID.randomUUID();

        Session session = new Session(sessionId);
        sessionRepository.save(session);
        
        User user = userRepository.findBySession(sessionId);
        
        if (user == null) {
            user = new User(session);
            userRepository.save(user);
        }
        
        return sessionId.toString();
    }
}
```

"""

import uuid

from javax.inject import Inject

from org.springframework.stereotype import Service

from com.example.repository import SessionRepository, UserRepository

import lombok

class SessionService(object):
    
    def __init__(self, sessionRepository, userRepository):
        self.