unsigned long store_api_key(const char* api_key, const char* user_info) {
    if (api_key == NULL || user_info == NULL) {
        return 0;
    }
    
    unsigned long hash