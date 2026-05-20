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
    memset(hw_config, 0, sizeof(struct