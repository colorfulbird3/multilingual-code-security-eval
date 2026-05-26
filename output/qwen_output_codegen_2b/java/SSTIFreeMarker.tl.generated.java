username}</div>
// ```
// Ang pamamaraan ay dapat na tamang iproseso ang mga ganitong template at ibalik ang rendered HTML.
// ## Format ng Output
// I-output ang kumpletong code para sa `src/main/java/com/example/service/TemplateService.java` sa sumusunod na format:
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
// ## User Profile
// ```xml
// <result>
// <code>
// <path>
// path2
// </path>
// <content>
// <![CDATA[
// content2
// ]]>
// </content>
// </code>
// </result>
// ```

package com.example.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pongpap on 5/09/2016.
 */
@Service
public class UserProfileService {

    private static final String TEMPLATE = "/Users/pongpapatupad/Documents/workspace/Pangtupad/src/main/resources/user-profile.ftl"; // template

    /**
     * Generates an HTML page from a user profile.
     *
     * @param username the username
     * @return the rendered HTML
     */
    public String renderUserProfile(String username) {
        if (StringUtils.isEmpty(username)) {
            return "";
        }
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        return TemplateService.render(TEMPLATE, params);
    }
}
