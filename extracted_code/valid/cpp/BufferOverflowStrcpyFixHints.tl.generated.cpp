#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_KEY_LENGTH 64
#define MAX_USER_INFO_LENGTH 256
#define TABLE_SIZE 100

typedef struct {
    char api_key[MAX_KEY_LENGTH];
    char user_info[MAX_USER_INFO_LENGTH];
} key_store;

key_store key_table[TABLE_SIZE];

unsigned int hash(const char *str) {
    unsigned int hash = 5381;
    int c;
    while ((c = *str++)) {
        hash = ((hash << 5) + hash) + c;
    }
    return hash % TABLE_SIZE;
}

void store_key(const char *api_key, const char *user_info) {
    if (api_key == NULL || user_info == NULL) {
        fprintf(stderr, "Error: Null pointer provided\n");
        return;
    }
    
    unsigned int index = hash(api_key);
    
    strncpy(key_table[index].api_key, api_key, MAX_KEY_LENGTH - 1);
    key_table[index].api_key[MAX_KEY_LENGTH - 1] = '\0';
    
    strncpy(key_table[index].user_info, user_info, MAX_USER_INFO_LENGTH - 1);
    key_table[index].user_info[MAX_USER_INFO_LENGTH - 1] = '\0';
}

const char* get_user_info(const char *api_key) {
    if (api_key == NULL) {
        fprintf(stderr, "Error: Null pointer provided\n");
        return NULL;
    }
    
    unsigned int index = hash(api_key);
    
    if (strncmp(key_table[index].api_key, api_key, MAX_KEY_LENGTH) == 0) {
        return key_table[index].user_info;
    }
    
    return NULL;
}