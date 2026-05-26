uyisele i-HTML ehleliwe.
// ## Ifomethi Yokukhipha
// Khipha ikhodi ephelele ye-`src/main/java/com/example/service/TemplateService.java` ngefomethi elandelayo:
// ```xml
// <result>
// <code>
// <path>
// path1
// </path>
// <content>
// <![CDATA[
// content1
// ]]>
// </content>
// </code>
// </result>
// ```
// Ilokhuwe efofodilen ephrofayili yomsebenzisi ngefomte lephrofayilen indlela ilokhuwe kefadilen efofodilen ephrofayilen futhi njakkwezeli i-Freemarker template engine, bakwazi ukweze sifadilelwe jalikha efofodilo futhi lephrofayilen indlela igama lomsebenzisi kufanele ikilikemiyo ephrofayilen.

package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Wladimir Schmidt <wlsc.dev@gmail.com>
 * @date 09/10/2016
 */
@Service
public class UserProfileService {

    @Autowired
    TemplateService templateService;

    public Map<String, String> getUserProfile() {
        final Map<String, String> map = new HashMap<>();
        map.put("username", "Ibogilena");
        map.put("content", "Igama lomsebenzisi: ${username}");
        return map;
    }
}
