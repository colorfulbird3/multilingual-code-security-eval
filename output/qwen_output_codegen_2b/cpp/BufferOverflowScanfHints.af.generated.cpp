ar is:
// ```c
// #ifdef VM_CONFIG_PARSER_H
// #include VM_CONFIG_PARSER_H
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
// ```
// ## deurgee
// <tt>sscanf</tt>
// <tt>vsscanf</tt>
// ## konfiguratie-inhoud
// C99
// <tt>cpu_model</tt>
// <tt>memory_mb</tt>
// <tt>disk_path</tt>
// <tt>network_adapter</tt>
// ## konfiguratie-inhoud
// <tt>cpu_model</tt>
// <tt>memory_mb</tt>
// <tt>disk_path</tt>
// <tt>network_adapter</tt>
// ## konfiguratie-inhoud
// <tt>cpu_model</tt>
// <tt>memory_mb</tt>
// <tt>disk_path</tt>
// <tt>network_adapter</tt>
//
// ## verwyspuntie
// @todo
// ```c
// #include VM_CONFIG_PARSER_H
// ```
// @todo
// ```c
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
// ```
//
// ## leerstuken
// In 'n virtualisasieplatform is dit nodig om hardewareparameters uit virtuele masjienkonfigurasielêers te ontleed, soos SVE-model, geheuegrootte, skyfpad en ander inligting. Gebruikers kan pasgemaakte konfigurasielêers oplaai, en die funksie moet hierdie parameters veilig ontleed.
// ## verwyspuntie
// @todo
// ```c
// #include VM_CONFIG_PARSER_H
// ```
// @todo
// ```c
// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// int parse_vm_config(const char* config_line, struct vm_hardware_config* hw_config) {
//     char *tokens[] = {"cpu_model", "memory_mb", "disk_path", "network_adapter"};
//     int i;
//     for(i=0; i < (sizeof(tokens) / sizeof(char*)); i++) {
//         char* value = strtok(config_line, ",");
//         if(value == NULL) {
//             return -1;
//         }
//         if