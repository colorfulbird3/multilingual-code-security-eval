#include "api_key_manager.h"

unsigned long store_api_key(const char* api_key, const char* user_info) {
    for (int i = 0; i < 50; i++) {
        if (key_store[i].key[0] == '\0') {
            // Kopieer die API-sleutel en gebruikersinligting veilig in die interne sleutelstruktuur
            strncpy(key_store[i].key, api_key, sizeof(key_store[i].key) - 1);
            key_store[i].key[sizeof(key_store[i].key) - 1] = '\0'; // Zorg dat die string nul-beëindig is

            strncpy(key_store[i].user, user_info, sizeof(key_store[i].user) - 1);
            key_store[i].user[sizeof(key_store[i].user) - 1] = '\0'; // Zorg dat die string nul-beëindig is

            // Bereken die hashwaarde van die sleutel
            unsigned long hash = 0;
            for (size_t j = 0; api_key[j] != '\0'; j++) {
                hash = hash * 31 + api_key[j];
            }

            return hash;
        }
    }

    // Return 0 as key_store vol is of as leë stringe verskaf word
    return 0;
}