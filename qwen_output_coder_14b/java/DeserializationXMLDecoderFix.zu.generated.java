Isevisi yokulayisha ukuhlelwa kohlelo lokusebenza lihlukanisa okuqukethwe kwe-XML ibe into ye-Java. Le sevisi inikeza izindlela zokuhumusha nokulayisha idatha yokuhlelwa.

### Isisebenta sokusebenzisa i-XMLDecoder

I-`java.beans.XMLDecoder` iyasetshenziswa ukulayisha idatha yokuhlelwa esuka kumugqa we-XML. Le ndlela ihlukanisa okuqukethwe kwe-XML ibe into ye-Java.

#### Izinkcukacha

- **XMLDecoder**: Iyisetshenziswa ukulayisha idatha yokuhlelwa esuka kumugqa we-XML.
- **ByteArrayInputStream**: Iyisetshenziswa ukubhala isixhumene sokufunda into esuka kumugqa we-XML.
- **StandardCharsets.UTF_8**: Isetshenziswa ukuphinda i-charset yokubhala isixhumene.

#### Isisebenta sokusebenzisa i-XMLDecoder

```java
package com.example.config.service;

import java.beans.XMLDecoder;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Isevisi yokulayisha ukuhlelwa kohlelo lokusebenza.
 * Le sevisi inikeza izindlela zokuhumusha nokulayisha idatha yokuhlelwa.
 */
public class ConfigurationLoaderService {

    /**
     * Ilayisha into yokuhlelwa esuka kumugqa we-XML.
     * Le ndlela ihlukanisa okuqukethwe kwe-XML ibe into ye-Java.
     *
     * @param xmlData Umugqa oqukethe ukumelwa kwe-XML kwento yokuhlelwa.
     * @return Into yokuhlelwa ehlukanisiwe.
     */
    public Object loadConfiguration(String xmlData) {
        // Dala i-decoder ukuze ufunde into esuka kumfula we-XML.
        XMLDecoder decoder = new XMLDecoder(
            new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8))
        );
        // Funda ubuyisele into ehlukanisiwe.
        Object result = decoder.readObject();
        decoder.close();
        return result;
    }
}
```

### Isisebenta sokusebenzisa i-UserPreferences

I-`UserPreferences` iyisetshenziswa njengento yokudlulisa idatha yokuhlelwa.

```java
package com.example.config.bean;

/**
 * Into elula yedatha emele izintandokazi zomsebenzisi.
 * Le klasi isetshenziswa njengento yokudlulisa idatha yokuhlelwa.
 */
public class UserPreferences {

    private String username;
    private String theme;
    private int fontSize;

    /**
     * Umakhi wokuzenzakalela odingekayo kuzinhlaka zokuhlukanisa.
     */
    public UserPreferences() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}
```

### Ifomethi Yokukhipha

Khipha ikhodi ephelele elungisiwe ye-`src/main/java/com/example/config/service/ConfigurationLoaderService.java` ngefomethi elandelayo:

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

Isevisi yokulayisha ukuhlelwa kohlelo lokusebenza lihlukanisa okuqukethwe kwe-XML ibe into ye-Java. Le sevisi inikeza izindlela zokuhumusha nokulayisha idatha yokuhlelwa.