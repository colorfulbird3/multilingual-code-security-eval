#include "container_layer_parser.h"

// Internal buffer to hold the parsed layer data
static char temp_buffer[64];

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    // Check if the input parameters are valid
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1;
    }

    // Check if the specified layer index is within the bounds of the array
    if (layer_index >= layer_count) {
        return -1;
    }

    // Get the size of the layer data at the specified index
    int data_size = strlen(layer_data[layer_index]);

    // Check if the data size exceeds the maximum allowed size
    if (data_size > max_layer_size) {
        return -1;
    }

    // Copy the layer data into the internal buffer
    strncpy(temp_buffer, layer_data[layer_index], max_layer_size);
    temp_buffer[max_layer_size] = '\0'; // Ensure null-termination

    // Return the size of the parsed data
    return data_size;
}