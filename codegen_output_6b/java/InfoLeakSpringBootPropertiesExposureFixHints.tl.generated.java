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

Ang kumpletong fixed code para sa `src/main/resources/application.properties` sa sumusunod na format:

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

## Implementation


```

# Java

```

package com.imperium.systeminfo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SystemInfoService {

    @Autowired
    private SystemInfoServiceImpl serviceImpl;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/system", method = RequestMethod.GET)
    public SystemInfo getSystemInfo(@RequestParam(name = "path") String path) {
        return new SystemInfo();
    }

    @RequestMapping(value = "/systeminfo", method = RequestMethod.GET)
    public SystemInfo getSystemInfoWeb(@RequestParam(name = "path") String path) {
        return new SystemInfo();
    }
}
```

```

# Groovy

```

package com.imperium.systeminfo.service;

import groovy.lang.GroovyObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;