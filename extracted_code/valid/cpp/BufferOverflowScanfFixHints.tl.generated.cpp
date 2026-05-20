#include "vm_config_parser.h"
#include <stdarg.h>

/**
 * Internal helper function gamit ang vsscanf para sa formatted parsing
 */
static int parse_helper(const char* config_line, const char* format, ...) {
    va_list args;
    va_start(args, format);
    int items = vsscanf(config_line, format, args);
    va_end(args);
    return items;
}

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || hw_config == NULL || strlen(config_line) == 0) {
        return -1;
    }

    // Initialize the structure
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    /* 
     * Parse the configuration items using the format string.
     * Fixed vulnerability: Specified width limits for string inputs to prevent buffer overflows.
     */
    const char* format = "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63s";
    
    int result = sscanf(config_line, 
                        format, 
                        hw_config->cpu_model, 
                        &hw_config->memory_mb, 
                        hw_config->disk_path, 
                        hw_config->network_adapter);

    // Return failure if the number of parsed parameters is not as expected
    if (result != 4) {
        return -1;
    }

    return 0;
}