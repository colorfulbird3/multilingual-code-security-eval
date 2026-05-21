#include "container_layer_parser.h"

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    // Check for invalid input parameters
    if (layer_data == NULL || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1;
    }

    // Get the size of the layer data at the specified index
    int layer_size = strlen(layer_data[layer_index]);

    // Check if the layer size exceeds the maximum allowed size
    if (layer_size > max_layer_size) {
        return -1;
    }

    // Create a temporary buffer to hold the parsed layer data
    char* temp_buffer = (char*)malloc(max_layer_size + 1);
    if (temp_buffer == NULL) {
        return -1;
    }

    // Copy the layer data into the temporary buffer
    strncpy(temp_buffer, layer_data[layer_index], layer_size);
    temp_buffer[layer_size] = '\0'; // Null-terminate the string

    // Process the layer data (for demonstration, we'll just print it)
    printf("Parsed Layer Data:\n%s\n", temp_buffer);

    // Free the temporary buffer
    free(temp_buffer);

    // Return the size of the parsed layer data
    return layer_size;
}