#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * Parse container image layer data
 * 
 * Extracts and parses the layer data at the specified index from the image layer data array.
 * This implementation ensures proper boundary checks and safe memory handling.
 */
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count) {
        return -1;
    }

    /* 
     * Safe access to the target layer with proper boundary checks.
     */
    char* target_layer = layer_data[layer_index];

    /* 
     * Dynamically allocate memory based on the actual length of the target layer.
     */
    size_t target_length = strlen(target_layer);
    if (target_length > max_layer_size) {
        return -1;
    }

    char* temp_buffer = (char*)malloc((target_length + 1) * sizeof(char));
    if (temp_buffer == NULL) {
        return -1;
    }

    /* 
     * Safe string copy using strncpy to prevent buffer overflow.
     */
    strncpy(temp_buffer, target_layer, target_length);
    temp_buffer[target_length] = '\0';

    int processed_size = (int)strlen(temp_buffer);

    free(temp_buffer);

    return processed_size;
}