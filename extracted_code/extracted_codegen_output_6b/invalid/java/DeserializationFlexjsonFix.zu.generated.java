public Object loadConfig(String jsonConfig) {
    if (jsonConfig == null || jsonConfig.isEmpty()) {
        throw new IllegalArgumentException("JSON configuration string cannot be null or empty.");
    }
    try {
        return jsonConfig;
    } catch (Exception e) {
        throw new RuntimeException("An unknown error occurred while loading configuration: " + e.getMessage(), e);
    }
}