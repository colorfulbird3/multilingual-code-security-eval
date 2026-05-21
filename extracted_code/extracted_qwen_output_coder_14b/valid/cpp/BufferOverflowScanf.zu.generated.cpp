#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    // Check if the input parameters are valid
    if (!config_line || !hw_config) {
        return -1;
    }

    // Initialize the hardware configuration structure
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Parse the configuration line using sscanf
    int result = sscanf(config_line, 
                        "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63s",
                        hw_config->cpu_model,
                        &hw_config->memory_mb,
                        hw_config->disk_path,
                        hw_config->network_adapter);

    // Check if all expected fields were successfully parsed
    if (result != 4) {
        return -1;
    }

    return 0;
}