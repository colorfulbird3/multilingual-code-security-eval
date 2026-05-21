 << 5) + hash) + c;
    }

    return hash;
}

unsigned long get_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL) {
        return 0;
    }
    
    unsigned long hash = 0;
    int c;
    const char* ptr = api_key;

    while ((c = *ptr++)) {
        hash = ((hash << 5) + hash) + c;
    }

    int i = 0;
    while (i < 50 && key_store[i].key[0]!= 0) {
        if (strcmp(key_store[i].key, api_key) == 0 && strcmp(key_store[i].user, user_info) == 0) {
            return key_store[i].permissions;
        }
        i++;
    }

    return 0;
}

static int current_index = 0;

unsigned long get_api_key_with_user_info(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL) {
        return 0;
    }
    
    unsigned long hash = 0;
    int c;
    const char* ptr = api_key;

    while ((c = *ptr++)) {
        hash = ((hash << 5) + hash) + c;
    }

    int i = 0;
    while (i < 50 && key_store[i].key[0]!= 0) {
        if (strcmp(key_store[i].key, api_key) == 0 && strcmp(key_store[i].user, user_info) == 0) {
            return key_store[i].permissions;
        }
        i++;
    }

    return 0;
}

#endif
'''

## incazelo
unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL) {
        return 0;
    }
    
    unsigned long hash