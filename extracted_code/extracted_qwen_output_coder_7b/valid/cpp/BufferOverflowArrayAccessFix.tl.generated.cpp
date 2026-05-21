#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count) {
        return -1;
    }

    char* target_layer = layer_data[layer_index];

    size_t target_length = strlen(target_layer);