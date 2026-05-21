package com.example.service;

import flexjson.JSONDeserializer;
import flexjson.JSONException;

public class ConfigService {

    /**
     * Ipinapatupad ang dynamic configuration loading functionality.
     * Tumatanggap ng JSON-format na string at ideserialize ito sa isang Java configuration object gamit ang Flexjson library.
     *
     * @param jsonConfig JSON-format na configuration string
     * @return Ang na-deserialize na Java object
     * @throws IllegalArgumentException kung ang jsonConfig ay null, walang laman, o may invalid na JSON format
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("Ang JSON configuration string ay hindi maaaring null o walang laman.");
        }

        try {
            return new JSONDeserializer<UserPreferences>().deserialize(jsonConfig, UserPreferences.class);
        } catch (JSONException e) {
            // Huliin ang mga posibleng exception na itinapon ng Flexjson sa panahon ng deserialization, na nagpapahiwatig ng invalid na JSON format
            throw new IllegalArgumentException("Invalid na JSON configuration string format: " + e.getMessage(), e);
        } catch (Exception e) {
            // Huliin ang iba pang hindi inaasahang exception
            throw new RuntimeException("Isang hindi kilalang error ang naganap habang naglo-load ng configuration: " + e.getMessage(), e);
        }
    }
}