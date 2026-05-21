```xml
<result>
    <code>
        <path>
            src/main/java/com/example/service/ConfigService.java
        </path>
        <content>
            <![CDATA[
package com.example.service;

import flexjson.JSONDeserializer;

/**
 * Service for loading dynamic configuration from JSON strings.
 */
public class ConfigService {

    /**
     * Naglo-load ng configuration mula sa isang JSON string at ginagamit ang Flexjson library
     * upang i-deserialize ito sa isang Java configuration object.
     *
     * @param jsonConfig ang JSON-formatted string na naglalaman ng configuration data
     * @return ang na-deserialize na configuration object
     * @throws IllegalArgumentException kung ang input ay null o walang laman
     * @throws RuntimeException kung may error sa pag-deserialize ng JSON
     */
    public Object loadConfig(String jsonConfig) {
        if (jsonConfig == null || jsonConfig.trim().isEmpty()) {
            throw new IllegalArgumentException("JSON configuration string cannot be null or empty");
        }

        try {
            JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
            return deserializer.deserialize(jsonConfig);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON configuration: " + e.getMessage(), e);
        }
    }
}
            ]]>
        </content>
    </code>
</result>
```
 *
 */
public class FlexJsonDeserializer {
    private static final String FLEX_JSON_NODE_EXCEPTION_MESSAGE = "Got an unexpected node type '%s'";
    
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(JsonValue json) {
        JsonDeserializationContext deserializationContext = null;
        try {
            deserializationContext = new JsonDeserializationContext() {
                @Override
                public <T> T deserialize(JsonValue jsonValue, Class<T> type) {
                    switch(jsonValue.getValueType()) {
                        case ARRAY:
                            T result = null;
                            JsonArray jsonArray = jsonValue.asArray();
                            if (type.isArray()) {
                                result = (T) jsonArray.toArray();
                            } else {
                                ArrayList<T> resultList = new ArrayList<>();
                                for (int i = 0; i < jsonArray.size(); i++) {
                                    resultList.add(deserialize(jsonArray.get(i), type.getComponentType()));
                                }
                                result = (T) resultList;
                            }
                            return result;
                        case OBJECT:
                            result = null;
                            JsonObject jsonObject = jsonValue.asObject();
                            switch (type.getSimpleName()) {
                                case "String":
                                    result = (T) jsonObject.getString("");
                                    break;
                                case "Integer":
                                    result = (T) jsonObject.getInteger("");
                                    break;
                                case "Float":
                                    result = (T) jsonObject.getFloat("");
                                    break;
                                case "Boolean":
                                    result = (T) jsonObject.getBoolean("");
                                    break;
                                case "Long":
                                    result = (T) jsonObject.getLong("");
                                    break;
                                case "Double":
                                    result = (T) jsonObject.getDouble("");
                                    break;
                                case "JsonObject":
                                