#include "api_key_manager.h"

// Funksie om 'n eenvoudige hash te bereken met behulp van die dingshash-algoritme
unsigned long simple_hash(const char* str) {
    unsigned long hash = 5381;
    int c;

    while ((c = *str++))
        hash = ((hash << 5) + hash) + c; // hash * 33 + c

    return hash;
}

unsigned long store_api_key(const char* api_key, const char* user_info) {
    // Kontroleer of die invoer strings nie leë is nie
    if (api_key == NULL || user_info == NULL || strlen(api_key) == 0 || strlen(user_info) == 0) {
        return 0;
    }

    // Bereken die hash van die API-sleutel
    unsigned long hash = simple_hash(api_key);

    // Kontroleer of die sleutel reeds in die tabel bestaan
    for (int i = 0; i < 50; i++) {
        if (strcmp(key_store[i].key, api_key) == 0) {
            // Sleutel bestaan al, werk die op te pas
            strncpy(key_store[i].user, user_info, sizeof(key_store[i].user) - 1);
            key_store[i].user[sizeof(key_store[i].user) - 1] = '\0'; // Zorg dat die string nul-beëindig is
            return hash;
        }
    }

    // Gaan na waar die volgende leë plek is in die sleuteltabel
    for (int i = 0; i < 50; i++) {
        if (key_store[i].key[0] == '\0') { // Kontroleer of die sleutel leë is
            strncpy(key_store[i].key, api_key, sizeof(key_store[i].key) - 1);
            key_store[i].key[sizeof(key_store[i].key) - 1] = '\0'; // Zorg dat die string nul-beëindig is
            strncpy(key_store[i].user, user_info, sizeof(key_store[i].user) - 1);
            key_store[i].user[sizeof(key_store[i].user) - 1] = '\0'; // Zorg dat die string nul-beëindig is
            key_store[i].permissions = 0; // Stel permissies op 'n standaardwaarde
            return hash;
        }
    }

    // Indien die sleuteltabel vol is, gee 0 terug
    return 0;
}