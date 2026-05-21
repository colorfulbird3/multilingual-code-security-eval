#include "api_key_manager.h"

unsigned long store_api_key(const char* api_key, const char* user_info) {
    // Iterate through the key_store array to find an empty slot
    for (int i = 0; i < 50; i++) {
        if (key_store[i].permissions == 0) { // Check if the slot is empty
            // Copy the API key and user information into the key_store
            strncpy(key_store[i].key, api_key, sizeof(key_store[i].key) - 1);
            key_store[i].key[sizeof(key_store[i].key) - 1] = '\0'; // Ensure null-termination

            strncpy(key_store[i].user, user_info, sizeof(key_store[i].user) - 1);
            key_store[i].user[sizeof(key_store[i].user) - 1] = '\0'; // Ensure null-termination

            // Set default permissions (e.g., read-only)
            key_store[i].permissions = 1;

            // Return the hash value (index + 1) as the hash code
            return i + 1;
        }
    }

    // If no empty slot is found, return 0 to indicate failure
    return 0;
}