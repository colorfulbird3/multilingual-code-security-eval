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

    // I-initialize ang structure
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    /* 
     * I-parse ang configuration items gamit ang format string.
     * Vulnerability: Hindi tinukoy ng sscanf ang maximum width limits kapag nag-parse ng strings (hal., %127[^,]),
     * na nagdudulot ng stack o