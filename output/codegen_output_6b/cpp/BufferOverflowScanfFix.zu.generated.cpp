 char* format,...)
{
    va_list args;
    va_start(args, format);
    int result = vsscanf(config_line, format, args);
    va_end(args);
    return result;
}

/**
 * Umsebenzi umsebenzi wokumisa okufanele ukuhlazya sokubuwumwa yosayizi kufanele
 */
static int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config)
{
    int result;
    va_list args;
    va_start(args, config_line);
    // Ubuukhulu we-fscanf yokuye ezihlaziwo
    result = parse_helper(config_line, "%s", hw_config->cpu_model);
    va_end(args);
    return result;
}

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config)
{
    return 0;
}

#include "zalat.h"

#endif /* VM_CONFIG_PARSER_H */
`
