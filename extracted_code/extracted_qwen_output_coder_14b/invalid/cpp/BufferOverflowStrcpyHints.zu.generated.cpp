int key_store_insert(const char *api_key, const char *user_info) {
    if (api_key == NULL || user_info == NULL) {
        return 0;
    }
    // Simulate key storage and return a hash value
    unsigned long hash = 5381;
    int c;
    while ((c = *api_key++)) {
        hash = ((hash << 5) + hash) + c;
    }
    while ((c = *user_info++)) {
        hash = ((hash << 5) + hash) + c;
    }
    // Check if key_store is full (simulated condition)
    if (hash == 0) {
        return 0;
    }
    return (int)(hash & 0x7FFFFFFF);
}