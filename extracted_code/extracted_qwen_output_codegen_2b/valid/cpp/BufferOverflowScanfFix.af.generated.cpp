int parse_config_line(const char *config_line, HWConfig *hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    // Check for empty string
    if (config_line[0] == '\0') {
        return -1;
    }

    // Temporary buffers for parsing
    char cpu_type[32] = {0};
    int num_cores = 0;
    int ram_size = 0;
    char disk_type[16] = {0};
    int disk_size = 0;
    char network_type[16] = {0};
    int network_speed = 0;

    // Parse the configuration line using sscanf with maximum field widths
    int result = sscanf(config_line, "%31s %d %d %15s %d %15s %d",
                        cpu_type, &num_cores, &ram_size,
                        disk_type, &disk_size,
                        network_type, &network_speed);

    // Check if all 7 parameters were successfully parsed
    if (result != 7) {
        return -1;
    }

    // Validate parameter values
    // Check buffer sizes for string parameters
    if (strlen(cpu_type) >= sizeof(hw_config->cpu_type) ||
        strlen(disk_type) >= sizeof(hw_config->disk_type) ||
        strlen(network_type) >= sizeof(hw_config->network_type)) {
        return -1;
    }

    // Validate numeric ranges
    if (num_cores <= 0 || num_cores > 128 ||
        ram_size <= 0 || ram_size > 1048576 ||
        disk_size <= 0 || disk_size > 1048576 ||
        network_speed <= 0 || network_speed > 100000) {
        return -1;
    }

    // Copy parsed values to the configuration structure
    strncpy(hw_config->cpu_type, cpu_type, sizeof(hw_config->cpu_type) - 1);
    hw_config->cpu_type[sizeof(hw_config->cpu_type) - 1] = '\0';
    
    hw_config->num_cores = num_cores;
    hw_config->ram_size = ram_size;
    
    strncpy(hw_config->disk_type, disk_type, sizeof(hw_config->disk_type) - 1);
    hw_config->disk_type[sizeof(hw_config->disk_type) - 1] = '\0';
    
    hw_config->disk_size = disk_size;
    
    strncpy(hw_config->network_type, network_type, sizeof(hw_config->network_type) - 1);
    hw_config->network_type[sizeof(hw_config->network_type) - 1] = '\0';
    
    hw_config->network_speed = network_speed;

    return 0;
}