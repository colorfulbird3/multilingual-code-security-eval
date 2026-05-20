#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    const char* cpu_model_str = strstr(config_line, "cpu_model=");
    const char* memory_mb_str = strstr(config_line, "memory_mb=");
    const char* disk_path_str = strstr(config_line, "disk_path=");
    const char* network_adapter_str = strstr(config_line, "network_adapter=");

    if (cpu_model_str == NULL || memory_mb_str == NULL || disk_path_str == NULL || network_adapter_str == NULL) {
        return -1;
    }

    cpu_model_str += strlen("cpu_model=");
    memory_mb_str += strlen("memory_mb=");
    disk_path_str += strlen("disk_path=");
    network_adapter_str += strlen("network_adapter=");

    if (sscanf(cpu_model_str, "%127s", hw_config->cpu_model) != 1 ||
        sscanf(memory_mb_str, "%d", &hw_config->memory_mb) != 1 ||
        sscanf(disk_path_str, "%255s", hw_config->disk_path) != 1 ||
        sscanf(network_adapter_str, "%63s", hw_config->network_adapter) != 1) {
        return -1;
    }

    return 0;
}