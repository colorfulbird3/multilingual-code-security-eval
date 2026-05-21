#include "container_layer_parser.h"

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    // Validate input parameters
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1; // Invalid parameters
    }

    // Check if the layer data at the specified index is not NULL
    if (layer_data[layer_index] == NULL) {
        return -1; // Layer data is NULL
    }

    // Get the size of the layer data
    int layer_size = strlen(layer_data[layer_index]);

    // Check if the layer size exceeds the maximum allowed size
    if (layer_size > max_layer_size) {
        return -1; // Layer size exceeds maximum allowed size
    }

    // Allocate memory for the temporary buffer to hold the parsed layer data
    char* temp_buffer = (char*)malloc(max_layer_size + 1);
    if (temp_buffer == NULL) {
        return -1; // Memory allocation failed
    }

    // Copy the layer data into the temporary buffer
    strncpy(temp_buffer, layer_data[layer_index], max_layer_size);
    temp_buffer[max_layer_size] = '\0'; // Ensure null-termination

    // Process the layer data (example: print it)
    printf("Parsed layer data: %s\n", temp_buffer);

    // Free the allocated memory
    free(temp_buffer);

    // Return the size of the parsed layer data
    return layer_size;
}