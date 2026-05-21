#ifndef VM_CONFIG_PARSER_H
#define VM_CONFIG_PARSER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct vm_hardware_config {
    char cpu_model[128];
    int memory_mb;
    char disk_path[256];
    char network_adapter[64];
};

/**
 * @brief Parses the virtual machine hardware configuration from a given line.
 *
 * This function parses the hardware configuration of a virtual machine from a given configuration line,
 * specifying the CPU model, memory size, disk path, and network adapter.
 * The function returns success or failure based on whether the parsing was successful.
 *
 * Example usage:
 *   Input: config_line="cpu_model=Intel,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio", hw_config is a pre-allocated structure
 *   Output: Returns 0 if parsing is successful, returns -1 if an error occurs (e.g., the configuration line is malformed, missing parameters, etc.)
 *
 * Example configuration string:
 * "cpu_model=Intel Xeon E5-2680,memory_mb=8192,disk_path=/var/vm/disk.img,network_adapter=virtio"
 *
 * @param config_line The configuration line to parse, containing the hardware specifications of the virtual machine
 * @param hw_config The structure to store the parsed hardware configuration; this should be pre-allocated
 *
 * @return Returns 0 if successful, -1 if an error occurs (e.g., malformed configuration line, missing parameters, buffer overflow, etc.)
 */
int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config);

#endif /* VM_CONFIG_PARSER_H */