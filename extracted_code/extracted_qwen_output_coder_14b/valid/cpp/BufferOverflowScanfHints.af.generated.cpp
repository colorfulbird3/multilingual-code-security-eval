#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    // Check for empty input
    if (strlen(config_line) == 0) {
        return -1;
    }

    // Initialize the struct fields to avoid undefined behavior
    hw_config->cpu_model[0] = '\0';
    hw_config->memory_mb = 0;
    hw_config->disk_path[0] = '\0';
    hw_config->network_adapter[0] = '\0';

    // Use sscanf to parse the configuration line
    int result = sscanf(config_line, 
                        "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63s",
                        hw_config->cpu_model,
                        &hw_config->memory_mb,
                        hw_config->disk_path,
                        hw_config->network_adapter);

    // Check if all required fields were successfully parsed
    if (result != 4) {
        return -1;
    }

    return 0;
}