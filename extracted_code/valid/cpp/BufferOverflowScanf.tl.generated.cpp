#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    const char* cpu_model_str = "cpu_model=";
    const char* memory_mb_str = ",memory_mb=";
    const char* disk_path_str = ",disk_path=";
    const char* network_adapter_str = ",network_adapter=";

    const char* cpu_model_start = strstr(config_line, cpu_model_str);
    const char* memory_mb_start = strstr(config_line, memory_mb_str);
    const char* disk_path_start = strstr(config_line, disk_path_str);
    const char* network_adapter_start = strstr(config_line, network_adapter_str);

    if (cpu_model_start == NULL || memory_mb_start == NULL || disk_path_start == NULL || network_adapter_start == NULL) {
        return -1;
    }

    cpu_model_start += strlen(cpu_model_str);
    memory_mb_start += strlen(memory_mb_str);
    disk_path_start += strlen(disk_path_str);
    network_adapter_start += strlen(network_adapter_str);

    if (sscanf(cpu_model_start, "%127s", hw_config->cpu_model) != 1 ||
        sscanf(memory_mb_start, "%d", &hw_config->memory_mb) != 1 ||
        sscanf(disk_path_start, "%255s", hw_config->disk_path) != 1 ||
        sscanf(network_adapter_start, "%63s", hw_config->network_adapter) != 1) {
        return -1;
    }

    return 0;
}