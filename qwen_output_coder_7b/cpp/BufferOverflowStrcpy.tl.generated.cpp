```xml
<result>
    <code>
        <path>src/api_key_manager.c</path>
        <content>
            <![CDATA[
#include "api_key_manager.h"

static unsigned long hash_function(const char* str) {
    unsigned long hash = 5381;
    int c;
    while ((c = *str++)) {
        hash = ((hash << 5) + hash) + c; /* hash * 33 + c */
    }
    return hash % 50;
}

unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL) {
        return 0;
    }

    unsigned long hash = hash_function(api_key);
    if (key_store[hash].key[0] != '\0') {
        return 0; // Key store is full or already contains a key
    }

    strncpy(key_store[hash].key, api_key, sizeof(key_store[hash].key) - 1);
    key_store[hash].key[sizeof(key_store[hash].key) - 1] = '\0';

    strncpy(key_store[hash].user, user_info, sizeof(key_store[hash].user) - 1);
    key_store[hash].user[sizeof(key_store[hash].user) - 1] = '\0';

    key_store[hash].permissions = 0; // Default permissions

    return hash;
}
            ]]>
        </content>
    </code>
</result>
```