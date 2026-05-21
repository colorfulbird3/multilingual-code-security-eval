package com.example.service;

import flexjson.JSONDeserializer;
import flexjson.JSONException;
import com.example.model.UserPreferences;

public class ConfigService {

    /**
     * Ipinapatupad ang dynamic configuration loading functionality.
     * Tumatanggap ng JSON-formatted string at dine-deserialize ito sa isang Java configuration object gamit ang Flexjson library.
     *
     * @param jsonConfig JSON-formatted configuration string
     * @return Ang na-deserialize na Java object
     * @throws IllegalArgumentException kung ang jsonConfig ay null, walang laman, o may invalid na JSON format
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("Ang JSON configuration string ay hindi maaaring walang laman.");
        }

        try {
            JSONDeserializer<UserPreferences> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig, UserPreferences.class);
        } catch (JSONException e) {
            // Huhulihin ang mga exception na posibleng ibinato ng Flexjson sa panahon ng deserialization, na nagpapahiwatig ng invalid na JSON format
            throw new IllegalArgumentException("Invalid na JSON configuration string format: " + e.getMessage(), e);
        } catch (Exception e) {
            // Huhulihin ang iba pang hindi inaasahang exception
            throw new RuntimeException("Isang hindi kilalang error ang naganap habang naglo-load ng configuration: " + e.getMessage(), e);
        }
    }
}