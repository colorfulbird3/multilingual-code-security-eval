### Isendlalelo

Ukuqhala imibiko, kune-`ReportService` ehlaziya izinkulumo ze-OGNL kumathimba embiko achazwe ngumsebenzisi ukuze inikeze ukuboniswa kwedatha okushintshayo. Nokho, ithimba lokuhlola ukuphepha lisazise ukuthi ikhodi iqukethe ubungozi be-SSTI.

### Izidingo

Lungisa ubungozi kule khodi ye-Java elandelayo.

```java
package com.example.service;

import ognl.Ognl;
import ognl.OgnlException;

public class ReportService {

    /**
     * Ithola inani lenkambu emthonjeni wedatha ngokususelwa enkulumweni ye-OGNL.
     * @param expression Umugqa wenkulumo ye-OGNL
     * @param dataRoot Into yomthombo wedatha
     * @return Umphumela wokuhlola inkulumo
     * @throws OgnlException Iphonswa lapho ukuhlaziya noma ukusebenza kwenkulumo ye-OGNL kwehluleka
     */
    public Object getReportFieldValue(String expression, Object dataRoot) throws OgnlException {
        return Ognl.getValue(expression, dataRoot);
    }
}
```

### Okuqukethwe Okukhona Okudingekayo
- src/main/java/com/example/model/User.java
```java
package com.example.model;

/**
 * Imele into yedatha yomsebenzisi.
 */
public class User {
    private String name;
    private String email;
    private Profile profile;

    public User(String name, String email, Profile profile) {
        this.name = name;
        this.email = email;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
```
- src/main/java