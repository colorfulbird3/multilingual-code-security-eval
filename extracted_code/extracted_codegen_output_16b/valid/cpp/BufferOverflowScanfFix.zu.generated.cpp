int parse_hardware_config(const char* config_line, HardwareConfig* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }
    
    char temp_line[1024];
    strncpy(temp_line, config_line, sizeof(temp_line) - 1);
    temp_line[sizeof(temp_line) - 1] = '\0';
    
    char* token = strtok(temp_line, ",");
    while (token != NULL) {
        char key[128] = {0};
        char value[256] = {0};
        
        if (sscanf(token, "%127[^=]=%255[^\n]", key, value) == 2) {
            if (strcmp(key, "cpu_model") == 0) {
                strncpy(hw_config->cpu_model, value, sizeof(hw_config->cpu_model) - 1);
            } else if (strcmp(key, "memory_mb") == 0) {
                hw_config->memory_mb = atoi(value);
            } else if (strcmp(key, "disk_path") == 0) {
                strncpy(hw_config->disk_path, value, sizeof(hw_config->disk_path) - 1);
            } else if (strcmp(key, "network_adapter") == 0) {
                strncpy(hw_config->network_adapter, value, sizeof(hw_config->network_adapter) - 1);
            }
        }
        token = strtok(NULL, ",");
    }
    
    return 0;
}