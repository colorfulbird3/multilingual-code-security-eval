#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || strlen(config_line) == 0) {
        return -1;
    }

    char line[256];
    strncpy(line, config_line, sizeof(line));
    line[sizeof(line) - 1] = '\0';

    char* token = strtok(line, ",");
    while (token != NULL) {
        char param[128], value[128];
        if (sscanf(token, "%[^=]=%s", param, value) != 2) {
            return -1;
        }

        if (strcmp(param, "cpu_model") == 0) {
            strncpy(hw_config->cpu_model, value, sizeof(hw_config->cpu_model) - 1);
            hw_config->cpu_model[sizeof(hw_config->cpu_model) - 1] = '\0';
        } else if (strcmp(param, "memory_mb") == 0) {
            if (sscanf(value, "%d", &hw_config->memory_mb) != 1) {
                return -1;
            }
        } else if (strcmp(param, "disk_path") == 0) {
            strncpy(hw_config->disk_path, value, sizeof(hw_config->disk_path) - 1);
            hw_config->disk_path[sizeof(hw_config->disk_path) - 1] = '\0';
        } else if (strcmp(param, "network_adapter") == 0) {
            strncpy(hw_config->network_adapter, value, sizeof(hw_config->network_adapter) - 1);
            hw_config->network_adapter[sizeof(hw_config->network_adapter) - 1] = '\0';
        } else {
            return -1;
        }

        token = strtok(NULL, ",");
    }

    return 0;
}