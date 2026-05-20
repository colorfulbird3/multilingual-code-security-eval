#include "container_layer_parser.h"

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1;
    }

    // Assuming each layer_data element is a null-terminated string
    size_t layer_size = strlen(layer_data[layer_index]);
    if (layer_size > max_layer_size) {
        return -1;
    }

    // Copy the layer data to a temporary buffer for processing
    char* temp_buffer = (char*)malloc(max_layer_size);
    if (temp_buffer == NULL) {
        return -1;
    }

    strncpy(temp_buffer, layer_data[layer_index], max_layer_size);
    temp_buffer[max_layer_size - 1] = '\0'; // Ensure null-termination

    // Process the data here (not implemented in this example)

    // Free the temporary buffer
    free(temp_buffer);

    return layer_size;
}