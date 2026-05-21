int get_device_config_param(const char *param_name, const char *config_list) {
    const char *p = config_list;
    int param_value = -1;
    int found = 0;
    
    while (*p != '\0' && !found) {
        // Skip leading spaces
        while (*p == ' ') p++;
        
        // Check if this parameter matches
        const char *name_start = p;
        while (*p != '=' && *p != '\0' && *p != ' ') p++;
        
        if (*p == '=') {
            // Compare parameter name
            size_t name_len = p - name_start;
            if (strncmp(name_start, param_name, name_len) == 0 && strlen(param_name) == name_len) {
                p++; // Skip '='
                
                // Skip spaces after '='
                while (*p == ' ') p++;
                
                // Extract integer value
                param_value = 0;
                int sign = 1;
                if (*p == '-') {
                    sign = -1;
                    p++;
                }
                while (*p >= '0' && *p <= '9') {
                    param_value = param_value * 10 + (*p - '0');
                    p++;
                }
                param_value *= sign;
                found = 1;
            }
        }
        
        // Move to next parameter (skip to next space or end)
        while (*p != ' ' && *p != '\0') p++;
        if (*p == ' ') p++;
    }
    
    return found ? param_value : -1;
}