```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * Ontleed houerbeeldlaagdata
 * 
 * Onttrek en ontleed die laagdata wat ooreenstem met die gespesifiseerde laagindeks uit die beeldlaagdataskikking.
 * Hierdie implementasie bevat spesifieke kwesbaarhede vir sekuriteitstoetsdoeleindes.
 */
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count) {
        return -1;
    }

    char* target_layer = layer_data[layer_index];

    if (strlen(target_layer) > max_layer_size) {
        return -1;
    }

    size_t required_size = strlen(target_layer) + 1;
    char* temp_buffer = (char*)malloc(required_size);
    if