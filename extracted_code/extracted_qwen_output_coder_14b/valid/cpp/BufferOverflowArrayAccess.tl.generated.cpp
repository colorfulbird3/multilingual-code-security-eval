#include "container_layer_parser.h"

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    // Validate input parameters
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1;
    }

    // Calculate the size of the layer data at the specified index
    int layer_size = strlen(layer_data[layer_index]);

    // Check if the layer size exceeds the maximum allowed size
    if (layer_size > max_layer_size) {
        return -1;
    }

    // Allocate memory for the temporary buffer
    char* temp_buffer = (char*)malloc(max_layer_size);
    if (temp_buffer == NULL) {
        return -1;
    }

    // Copy the layer data into the temporary buffer
    strncpy(temp_buffer, layer_data[layer_index], layer_size);
    temp_buffer[layer_size] = '\0'; // Null-terminate the string

    // Process the copied layer data (placeholder for actual processing logic)
    // For demonstration purposes, we'll just print the layer data
    printf("Parsed layer data: %s\n", temp_buffer);

    // Free the allocated memory
    free(temp_buffer);

    // Return the size of the parsed layer data
    return layer_size;
}