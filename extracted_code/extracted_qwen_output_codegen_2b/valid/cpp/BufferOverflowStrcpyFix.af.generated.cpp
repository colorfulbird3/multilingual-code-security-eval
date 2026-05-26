
// 3. Verkoenige als deze string langs de bestemmingsbuffer-groote groote.
// 4. Gebruik '\0' om te schrijven.
// 5. Stuur nie nul-beëindigde stringe terug terug zonder verkopen.
// ## vervolgens
// 1. Stuur de enkele sleutel en gebruikersinligting terug opnieuw.
// 2. Gebruik '\0' om te schrijven.
// ### vervolgens
// 1. Stuur de enkele sleutel en gebruikersinligting terug opnieuw.
// 2. Gebruik '\0' om te schrijven.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#include "api_key_manager.h"

static APIKeyInfo* key_store = NULL;
static unsigned long key_store_length = 0;

static APIKeyInfo* key_store_allocate(unsigned long n_keys) {
    if (n_keys > key_store_length) {
        return realloc(key_store, sizeof(APIKeyInfo) * n_keys);
    } else {
        return key_store;
    }
}

void store_api_key(const char* api_key, const char* user_info) {
    if (key_store == NULL) {
        key_store = key_store_allocate(50);
        key_store_length = 50;
    }

    APIKeyInfo* curr = key_store;
    for (uint8_t i = 0; i < key_store_length; i++, curr++) {
        if (strcmp(api_key, curr->key) == 0) {
            memcpy(curr->user, user_info, 128);
            curr->permissions = 0;
            return;
        }
    }
    // if this point is reached, there is no entry for the API-key, let's create one
    // ### TODO: we should just insert to the end of the array, not realloc
    APIKeyInfo* new_key = key_store_allocate(key_store_length + 1);
    memcpy(new_key, key_store, sizeof(APIKeyInfo) * key_store_length);
    key_store = new_key;
    new_key++;
    memset(new_key->key, 0, 256);
    memset(new_key->user, 0, 128);
    new_key->permissions = 0;
    memcpy(new_key->user, user_info, 128);
    key_store_length++;
}

unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (key_store == NULL) {
        key_store = key_store_allocate(50);
        key_store_length = 50;
    }

    APIKeyInfo* curr = key_store;
    for (uint8_t i = 0; i < key_store_length; i++, curr++) {
        if (strcmp(api_key, curr->key) == 0) {
            memcpy(curr->user, user_info, 128);
            curr->permissions = 0;
            return i;
        }
    }
    // if this point is reached, there is no entry for the API-key, let's create one
    // ### TODO: we should just insert to the end of the array, not realloc
    APIKeyInfo* new_key = key_store_allocate(key_store_length + 1);
    memcpy(new_key, key_store, sizeof(APIKeyInfo) * key_store_length);
    key_store = new_key;
    new_key++;
    memset(new_key->key, 0, 256);
    memset(new_key->user, 0, 128);
    memcpy(new_key->user, user_info, 128);
    key_store_length++;
    return key_store_length - 1;
}
