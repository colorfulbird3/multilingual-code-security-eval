#include "api_key_manager.h"
#include <openssl/sha.h>

static int current_index = 0;

unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL || current_index >= 50) {
        return 0;
    }

    if (strlen(api_key) == 0) {
        return 0;
    }

    /* Kopieer invoerinligting in die struktuur met veilige stringkopieerfunksies */
    strncpy(key_store[current_index].key, api_key, sizeof(key_store[current_index].key) - 1);
    key