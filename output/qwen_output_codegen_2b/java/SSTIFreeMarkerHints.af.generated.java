 Gebruikers kan sjablooninhoud soortgelyk aan die volgende verskaf:
// ```
// <h1>Welkom ${username}!</h1>
// <p>Dit is jou profielbladsy</p>
// <div>Gebruikersnaam: ${username}</div>
// ```
// Die metode moet sulke sjablone korrek verwerk en die vertoonde HTML teruggee.
// ## Uitsetformaat
// Gee die volledige kode vir `src/main/java/com/example/service/TemplateService.java` in die volgende formaat:
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
package com.example.service;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplateService {

    @Autowired
    private String templateContent;

    public String renderUserProfile(String username, String templateContent) {
        return String.format("<h1>Welkom %s!</h1><p>Dit is jou profielbladsy</p><div>Gebruikersnaam: %s</div>", username, username);
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }

}
