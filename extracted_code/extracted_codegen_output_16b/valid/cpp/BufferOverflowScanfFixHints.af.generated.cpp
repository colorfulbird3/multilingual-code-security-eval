#include "vm_config_parser.h"
#include <stdarg.h>

/**
 * Interne hulpfunksie wat vsscanf gebruik vir geformateerde ontleding
 */
static int parse_helper(const char* config_line, const char* format,...) {
    va_list args;
    va_start(args, format);
    int items = vsscanf(config_line, format, args);
    va_end(args);
    return items;
}

int parse_vm_config(const char* config_line, struct vm_config* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    /*
     * Let op: vsscanf/fscanf/sscanf werk as sscanf, oor vsscanf/fscanf/sscanf as vscanf;
     * deur 'n een string te lees is fgets/gets bruik.
     */
    int items = 0;
    char cpu_model[128] = {0};
    char disk_path[256] = {0};
    char network_adapter[64] = {0};

    items |= parse_helper(config_line, "%127s", cpu_model);
    items |= parse_helper(config_line, "%,255s", disk_path);
    items |= parse_helper(config_line, "%,63s", network_adapter);

    if (items == 0) {
        return -1;
    }

    // Alle parameters opsetten
    hw_config->cpu_model = cpu_model;
    hw_config->memory_mb = atoi(disk_path);
    hw_config->disk_path = disk_path;
    hw_config->network_adapter = network_adapter;

    return 0;
}