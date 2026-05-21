public Object loadConfig(String jsonConfig) {
    return new JSONDeserializer<>(UserPreferences.class).deserialize(jsonConfig);
}