c = *ptr++)!= '\0') {
        hash = ((hash << 5) + hash) + c; /* hash * 265 + c */
    }

    return hash;
}

void print_all_key(void) {
    int i;
    for (i = 0; i < current_index; i++) {
        printf("%s\n%s\n%d\n", key_store[i].key, key_store[i].user, key_store[i].permissions);
    }
}

unsigned long get_key(const char* key_string) {
    int i;
    for (i = 0; i < current_index; i++) {
        if (strcmp(key_store[i].key, key_string) == 0) {
            return key_store[i].permissions;
        }
    }
    return 0;
}

void clear_all_key(void) {
    int i;
    for (i = 0; i < current_index; i++) {
        memset(key_store[i].key, 0, 256);
        memset(key_store[i].user, 0, 128);
        key_store[i].permissions = 0;
    }
    current_index = 0;
}

unsigned long get_api_key(const char* key_string, const char* user_info) {
    if (user_info == NULL) {
        return 0;
    }
    unsigned long hash_value = store_api_key(key_string, user_info);
    if (hash_value == 0) {
        return 0;
    }
    return get_key(key_string);
}

unsigned long get_api_key_permissions(const char* key_string, const char* user_info) {
    if (user_info == NULL) {
        return 0;
    }
    unsigned long hash_value = store_api_key(key_string, user_info);
    if (hash_value == 0) {
        return 0;
    }
    return hash_value;
}

void set_api_key_permissions(const