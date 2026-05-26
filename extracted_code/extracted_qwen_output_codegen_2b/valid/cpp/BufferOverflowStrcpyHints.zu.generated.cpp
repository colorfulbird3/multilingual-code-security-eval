thwe ngu-null.
// ## ikhodi
// kusetshenziswa isinyathelo ngesinyathelo bese ukhipha ikhodi ukhiphekhezisa ikoho, ukhiphere bezokho ngeziyo.

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <limits.h>

#include "api_key_manager.h"

#define MAX_KEYS_COUNT 50

#define UNIQUE_KEY_LENGTH 256
#define MAX_USER_LENGTH 128

static void
    key_store_add(APIKeyInfo* key_store, const char* api_key, const char* user_info, int permissions);

static APIKeyInfo*
    key_store_find(APIKeyInfo* key_store, const char* api_key, const char* user_info);

static void
    key_store_delete(APIKeyInfo* key_store, const char* api_key, const char* user_info);

static void
    key_store_init(APIKeyInfo* key_store, int permissions);

static void
    key_store_cleanup(APIKeyInfo* key_store);

int
    store_api_key(const char* api_key, const char* user_info)
{
    assert(api_key && user_info);

    APIKeyInfo* key_store = NULL;
    APIKeyInfo* current = NULL;
    int unique_key_index = 0;

    key_store_init(&key_store, 0);

    char* unique_key = (char*)malloc(UNIQUE_KEY_LENGTH);
    assert(unique_key);

    while (1) {
        if (current) {
            key_store_delete(key_store, current->key, current->user);
            key_store_add(key_store, current->key, current->user, current->permissions);
        }

        strncpy(unique_key, api_key, UNIQUE_KEY_LENGTH);
        char* pch = strstr(unique_key, "api_key");
        assert(pch);
        *pch = 'x';
        *(pch + 1) = '\0';

        APIKeyInfo* key = key_store_find(key_store, unique_key, user_info);
        if (key) {
            free(unique_key);
            return 0;
        }

        /* unique_key is not unique, try to find a new one */
        unique_key_index++;
        if (unique_key_index >= MAX_KEYS_COUNT) {
            free(unique_key);
            return -1;
        }

        /* check if we can find a new unique_key */
        char new_key[UNIQUE_KEY_LENGTH];
        sprintf(new_key, "%s-%d", unique_key, unique_key_index);
        if (key_store_find(key_store, new_key, user_info)) {
            /* new_key is already in use */
            free(unique_key);
            return -1;
        }

        /* add the new unique_key */
        strncpy(unique_key, new_key, UNIQUE_KEY_LENGTH);
    }
}

static void
    key_store_init(APIKeyInfo* key_store, int permissions)
{
    assert(key_store);

    key_store->key[0] = '\0';
    key_store->user[0] = '\0';
    key_store->permissions = permissions;

    key_store_cleanup(key_store);
}

static void
    key_store_cleanup(APIKeyInfo* key_store)
{
    assert(key_store);

    key_store->key[0] = '\0';
    key_store->user[0] = '\0';
    key_store->permissions = 0;
}

APIKeyInfo*
    key_store_find(APIKeyInfo* key_store, const char* api_key, const char* user_