#include "container_layer_parser.h"

// Internal temporary buffer to store the parsed layer data
static char* temp_buffer;
static int temp_buffer_size;

// Function to initialize the temporary buffer
static void init_temp_buffer(int max_layer_size) {
    if (temp_buffer != NULL) {
        free(temp_buffer);
    }
    temp_buffer = (char*)malloc(max_layer_size);
    if (temp_buffer == NULL) {
        fprintf(stderr, "Failed to allocate memory for temporary buffer\n");
        exit(EXIT_FAILURE);
    }
    temp_buffer_size = max_layer_size;
}

// Function to clean up the temporary buffer
static void cleanup_temp_buffer() {
    if (temp_buffer != NULL) {
        free(temp_buffer);
        temp_buffer = NULL;
    }
}

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    // Initialize the temporary buffer
    init_temp_buffer(max_layer_size);

    // Check for invalid parameters
    if (layer_data == NULL || layer_count <= 0 || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        cleanup_temp_buffer();
        return -1;
    }

    // Copy the layer data at the specified index into the temporary buffer
    size_t layer_size = strlen(layer_data[layer_index]);
    if (layer_size > max_layer_size) {
        cleanup_temp_buffer();
        return -1;
    }
    memcpy(temp_buffer, layer_data[layer_index], layer_size + 1);

    // Return the size of the successfully parsed data
    cleanup_temp_buffer();
    return (int)layer_size;
}