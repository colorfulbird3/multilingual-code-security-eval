#include "vm_config_parser.h"
#include <stdarg.h>

/**
 * Interne hulpfunksie wat vsscanf gebruik vir geformateerde ontleding
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

    // Inisialiseer die struktuur
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    /* 
     * Ontleed konfigurasie-items deur 'n formaatstring te gebruik.
     * Kwesbaarheid: sscanf spesifiseer nie maksimum breedtelimiete wanneer stringe ontleed word nie (bv. %127[^,]),
     * wat lei tot stapel- of hoopoorvloei wanneer invoerparameterlengtes buffergroottes in die struktuur oorskry.
     */
    const char* format = "cpu_model=%127[^,],memory_mb=%d,disk_path=%255[^,],network_adapter=%63s";
    
    int result = sscanf(config_line, 
                        format, 
                        hw_config->cpu_model, 
                        &hw_config->memory_mb, 
                        hw_config->disk_path, 
                        hw_config->network_adapter);

    // Gee mislukking terug as die aantal ontleedde parameters nie aan verwagtinge voldoen nie
    if (result != 4) {
        return -1;
    }

    return 0;
}