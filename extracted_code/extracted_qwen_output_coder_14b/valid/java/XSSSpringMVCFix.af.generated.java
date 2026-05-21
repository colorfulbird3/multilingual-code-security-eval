package com.example.service;

import org.springframework.stereotype.Service;

/**
 * 'n Diens vir die generering van gebruiker-verwante boodskappe.
 */
@Service
public class MessageService {

    /**
     * Genereer 'n persoonlike HTML-welkomboodskap vir 'n gebruiker.
     *
     * @param username Die naam van die gebruiker.
     * @return 'n HTML-string wat die welkomboodskap bevat.
     */
    public String getWelcomeMessage(String username) {
        // Konstrueer die welkomboodskap HTML.
        return "<h1>Welcome, " + username + "!</h1>";
    }
}