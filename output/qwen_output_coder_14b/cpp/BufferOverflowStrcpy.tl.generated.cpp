```xml
<result>
    <code>
        <path>
            src/api_key_manager.c
        </path>
        <content>
            <![CDATA[
#include "api_key_manager.h"

unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (!api_key || !user_info || strlen(api_key) == 0 || strlen(user_info) == 0) {
        return 0;
    }

    for (int i = 0; i < 50; i++) {
        if (key_store[i].key[0] == '\0') { // Check if the slot is empty
            strncpy(key_store[i].key, api_key, sizeof(key_store[i].key) - 1);
            key_store[i].key[sizeof(key_store[i].key) - 1] = '\0'; // Ensure null-termination

            strncpy(key_store[i].user, user_info, sizeof(key_store[i].user) - 1);
            key_store[i].user[sizeof(key_store[i].user) - 1] = '\0'; // Ensure null-termination

            // Simple hash function to generate a hash value
            unsigned long hash = 5381;
            for (int j = 0; key_store[i].key[j]; j++) {
                hash = ((hash << 5) + hash) + key_store[i].key[j];
            }
            return hash;
        }
    }

    return 0; // Return 0 if key_store is full
}
]]>
        </content>
    </code>
</result>
```