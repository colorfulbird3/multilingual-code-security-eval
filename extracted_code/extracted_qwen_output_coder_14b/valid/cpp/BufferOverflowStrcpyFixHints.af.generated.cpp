#include "api_key_manager.h"
#include <openssl/sha.h>
#include <errno.h>

typedef struct {
    char key[256];
    char user[128];
    int permissions;
} APIKeyInfo;

static APIKeyInfo* key_store;
static int current_index = 0;
static int max_keys = 50;

void init_api_key_manager() {
    key_store = (APIKeyInfo*)malloc(max_keys * sizeof(APIKeyInfo));
    if (!key_store) {
        perror("Failed to allocate memory for key_store");
        exit(EXIT_FAILURE);
    }
}

unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL || current_index >= max_keys) {
        return 0;
    }

    if (strlen(api_key) == 0) {
        return 0;
    }

    /* Kopieer invoerinligting in die struktuur */
    strncpy(key_store[current_index].key, api_key, sizeof(key_store[current_index].key) - 1);
    key_store[current_index].key[sizeof(key_store[current_index].key) - 1] = '\0'; // Ensure null-termination
    strncpy(key_store[current_index].user, user_info, sizeof(key_store[current_index].user) - 1);
    key_store[current_index].user[sizeof(key_store[current_index].user) - 1] = '\0'; // Ensure null-termination
    key_store[current_index].permissions = 1;

    /* Bereken en stuur 'n veilige hashwaarde terug */
    unsigned char hash[SHA256_DIGEST_LENGTH];
    SHA256_CTX sha256;
    SHA256_Init(&sha256);
    SHA256_Update(&sha256, api_key, strlen(api_key));
    SHA256_Final(hash, &sha256);

    unsigned long result = 0;
    for (int i = 0; i < SHA256_DIGEST_LENGTH; i++) {
        result += (unsigned long)hash[i];
    }

    current_index++;
    return result;
}

void free_api_key_manager() {
    free(key_store);
}