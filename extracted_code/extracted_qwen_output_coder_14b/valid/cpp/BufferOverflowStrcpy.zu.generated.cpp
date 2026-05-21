#include "api_key_manager.h"

unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL) {
        return 0; // Ibuyisela u-0 ukuba kufuneka ukhophazana kwintambo
    }

    for (int i = 0; i < 50; i++) {
        if (key_store[i].permissions == 0) { // Check if the slot is empty
            strncpy(key_store[i].key, api_key, sizeof(key_store[i].key) - 1);
            key_store[i].key[sizeof(key_store[i].key) - 1] = '\0'; // Ensure null termination
            strncpy(key_store[i].user, user_info, sizeof(key_store[i].user) - 1);
            key_store[i].user[sizeof(key_store[i].user) - 1] = '\0'; // Ensure null termination
            key_store[i].permissions = 1; // Mark as used
            return (unsigned long)i; // Return the index as the hash
        }
    }

    return 0; // Ibuyisela u-0 ukuba kunikezwe izintambo ezingenalutho
}