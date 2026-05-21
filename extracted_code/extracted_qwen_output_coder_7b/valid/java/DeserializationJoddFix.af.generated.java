package com.example.datahandler.service;

import jodd.json.JsonParser;
import jodd.json.JsonException;
import java.util.Map;

public class WorkFlowService {

    /**
     * Parseer 'n JSON-formaat string in 'n Java Map-voorwerp deur die jodd-json biblioteek te gebruik.
     * Hierdie metode hanteer enige wettige JSON-strukture en gee dit terug as 'n Map.
     *
     * @param jsonConfig Die JSON-formaat string wat geparseer moet word.
     * @return 'n Map-voorwerp wat die geparseerde JSON-konfigurasie verteenwoordig.
     * @throws JsonException as die invoerstring nie 'n geldige JSON-formaat is nie of as parseting misluk.
     */
    public Map<String, Object> loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON-konfigurasiestring kan nie null of leeg wees nie.");
        }

        try {
            // Gebruik jodd.json.JsonParser om die JSON-string na 'n voorwerp te parseer,
            // wat 'n Map sal wees vir die topvlak JSON-voorwerp.
            return JsonParser.create().setClassMetadataName("@class").parse(jsonConfig);
        } catch (JsonException e) {
            // Vang JSON-parseting spesifieke uitsonderings en gooi dit weer met 'n meer insiggewende boodskap.
            throw new JsonException("Kon nie JSON-konfigurasiestring parseer nie. Maak asseblief seker dit is geldige JSON.", e);
        } catch (Exception e) {
            // Vang enige ander onverwagte uitsonderings tydens parseting.
            throw new RuntimeException("'n Onverwagte fout het tydens JSON-parseting voorgekom.", e);
        }
    }
}