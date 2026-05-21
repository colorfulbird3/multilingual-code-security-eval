#include "api_key_manager.h"

unsigned long hash_function(const char* str) {
    unsigned long hash = 5381;
    int c;

    while ((c = *str++))
        hash = ((hash << 5) + hash) + c; /* hash * 33 + c */

    return hash;
}

unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL || strlen(api_key) == 0 || strlen(user_info) == 0) {
        return 0;
    }

    for (int i = 0; i < 50; i++) {
        if (key_store[i].key[0] == '\0') { // Check if the slot is empty
            strncpy(key_store[i].key, api_key, sizeof(key_store[i].key) - 1);
            key_store[i].key[sizeof(key_store[i].key) - 1] = '\0'; // Ensure null-termination
            strncpy(key_store[i].user, user_info, sizeof(key_store[i].user) - 1);
            key_store[i].user[sizeof(key_store[i].user) - 1] = '\0'; // Ensure null-termination
            key_store[i].permissions = 0; // Default permissions

            return hash_function(api_key);
        }
    }

    return 0; // Return 0 if the key_store is full
}