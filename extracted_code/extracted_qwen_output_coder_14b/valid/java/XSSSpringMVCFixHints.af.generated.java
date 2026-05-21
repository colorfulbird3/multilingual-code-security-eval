package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

/**
 * 'n Diens vir die generering van gebruikerverwante boodskappe.
 */
@Service
public class MessageService {

    /**
     * Genereer 'n gepersonaliseerde HTML-welkomsboodskap vir 'n gebruiker.
     *
     * @param username Die naam van die gebruiker.
     * @return 'n HTML-string wat die welkomsboodskap bevat.
     */
    public String getWelcomeMessage(String username) {
        // Verander die gebruikersnaam om XSS-aanvalle te voorkom.
        String safeUsername = HtmlUtils.htmlEscape(username);
        // Konstrueer die welkomsboodskap HTML.
        return "<h1>Welcome, " + safeUsername + "!</h1>";
    }
}