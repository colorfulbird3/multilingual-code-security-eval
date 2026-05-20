package com.example.service;

import flexjson.JSONDeserializer;
import flexjson.JSONException;

public class ConfigService {

    /**
     * Implementeer dinamiese konfigurasie laai funksionaliteit.
     * Aanvaar 'n JSON-geformateerde string en deserialiseer dit na 'n Java-konfigurasie-objek met behulp van die Flexjson biblioteek.
     *
     * @param jsonConfig JSON-geformateerde konfigurasiestring
     * @return Die gedeserialiseerde Java-objek
     * @throws IllegalArgumentException indien jsonConfig null, leeg, of 'n ongeldige JSON-formaat het
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON-konfigurasiestring kan nie null of leeg wees nie.");
        }

        try {
            JSONDeserializer<UserPreferences> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig, UserPreferences.class);
        } catch (JSONException e) {
            // Vang uitsonderings wat moontlik deur Flexjson tydens deserialisasie gegooi word, wat 'n ongeldige JSON-formaat aandui
            throw new IllegalArgumentException("Ongeldige JSON-konfigurasiestring-formaat: " + e.getMessage(), e);
        } catch (Exception e) {
            // Vang ander onverwagte uitsonderings
            throw new RuntimeException("'n Onbekende fout het voorgekom tydens die laai van konfigurasie: " + e.getMessage(), e);
        }
    }
}