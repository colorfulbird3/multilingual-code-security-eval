public Object deserialize(String json) {
try {
return new JSONDeserializer<>().deserialize(json);
} catch (JSONException e) {
throw new IllegalArgumentException("Invalid JSON configuration string format: " + e.getMessage(), e);
} catch (Exception e) {
throw new RuntimeException("An unknown error occurred while loading configuration: " + e.getMessage(), e);
}
}