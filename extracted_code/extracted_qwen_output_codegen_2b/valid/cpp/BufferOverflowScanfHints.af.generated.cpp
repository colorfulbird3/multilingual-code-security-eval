// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// struct vm_hardware_config hw_config
//
// int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
//     char *tokens[] = {"cpu_model", "memory_mb", "disk_path", "network_adapter"};
//     int i;
//     for(i=0; i < (sizeof(tokens) / sizeof(char*)); i++) {
//         char* value = strtok(config_line, ",");
//         if(value == NULL) {
//             return -1;
//         }
//         if(strcmp(tokens[i], value) == 0) {
//             return i;
//         }
//     }
//     return -1;
// }
//