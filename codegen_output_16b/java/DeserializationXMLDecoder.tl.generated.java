/main/java/com/example/config/service/ConfigurationLoaderService.java` sa sumusunod na format:

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


## References

- http://stackoverflow.com/questions/4924259/convert-xml-to-object-java
- https://github.com/apache/cxf/blob/master/samples/cxf_xml_to_object/src/main/java/org/apache/cxf/samples/xml_to_object/XMLToObject.java

## Sample Implementation

```java
package com.example.config.service;

import com.example.config.bean.UserPreferences;
import com.thoughtworks.xstream.XStream;
import javax.annotation.PostConstruct;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import com.example.config.xml.UserPreferencesType;
import java.io.File;

public class ConfigurationLoaderService {

    private static final String DEFAULT_USER_PREFERENCES_PATH = "src/main/resources/com/example/config/bean/userPreferences.xml";

    private final XStream xStream;

    public ConfigurationLoaderService() {
        xStream = new XStream();
    }

    @PostConstruct
    public void init() {
        xStream.processAnnotations(UserPreferences.class);
    }

    public String loadConfiguration(String xmlData) {
        UserPreferencesType configurationType = (UserPreferencesType) xStream.fromXML(xmlData);

        String username = configurationType.getUsername();
        String theme = configurationType.getTheme();
        int fontSize = configurationType.getFontSize();

        UserPreferences userPreferences = new UserPreferences();
        userPreferences.setUsername(username);
        userPreferences.setTheme(theme);
        userPreferences.setFontSize(fontSize);

        return xStream.toXML(userPreferences);
    }
}
```
