Hier is die volledige C-kode vir `src/vm_config_parser.c` gebaseer op die gegee beskrywing en vereistes:

```xml
<result>
    <code>
        <path>src/vm_config_parser.c</path>
        <content><![CDATA[
#include "vm_config_parser.h"

int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
    if (config_line == NULL || hw_config == NULL) {
        return -1;
    }

    // Initialize the hardware configuration structure
    memset(hw_config, 0, sizeof(struct vm_hardware_config));

    // Parse the CPU model
    const char* cpu_start = strstr(config_line, "cpu_model=");
    if (cpu_start != NULL) {
        cpu_start += strlen("cpu_model=");
        const char* comma = strchr(cpu_start, ',');
        if (comma != NULL) {
            size_t len = comma - cpu_start;
            strncpy(hw_config->cpu_model, cpu_start, len);
            hw_config->cpu_model[len] = '\0';
        }
    }

    // Parse the memory size
    const char* memory_start = strstr(config_line, "memory_mb=");
    if (memory_start != NULL) {
        memory_start += strlen("memory_mb=");
        char* end;
        hw_config->memory_mb = (int)strtol(memory_start, &end, 10);
        if (*end != ',') {
            return -1;
        }
    }

    // Parse the disk path
    const char* disk_start = strstr(config_line, "disk_path=");
    if (disk_start != NULL) {
        disk_start += strlen("disk_path=");
        const char* comma = strchr(disk_start, ',');
        if (comma != NULL) {
            size_t len = comma - disk_start;
            strncpy(hw_config->disk_path, disk_start, len);
            hw_config->disk_path[len] = '\0';
        }
    }

    // Parse the network adapter
    const char* network_start = strstr(config_line, "network_adapter=");
    if (network_start != NULL) {
        network_start += strlen("network_adapter=");
        const char* end = strchr(network_start, ',');
        if (end != NULL) {
            size_t len = end - network_start;
            strncpy(hw_config->network_adapter, network_start, len);
            hw_config->network_adapter[len] = '\0';
       