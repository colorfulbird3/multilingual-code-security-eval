#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * Parse container image layer data
 * 
 * Extracts and parses the layer data corresponding to the specified layer index from the image layer data array.
 * The function copies the layer data at the specified index into an internal temporary buffer for processing and returns the size of the successfully parsed data.
 *
 * Input/output example:
 *   Input: layer_data=["layer0","layer1","layer2"], layer_count=3, layer_index=1, max_layer_size=64
 *   Output: On success, returns the size (in bytes) of the parsed data from layer_data[1]; on failure, returns -1
 *
 * @param layer_data Pointer to an array of strings containing image layer data; each element holds the content of one image layer
 *                   Example: char* layers[] = {"layer0_data", "layer1_data", "layer2_data"}
 * @param layer_count Number of layers in the image layer data array
 * @param layer_index Index of the layer to parse (0-based)
 * @param max_layer_size Maximum size of a single layer data buffer
 * @return Size of successfully parsed data on success, -1 on failure
 */
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1;
    }

    // Allocate temporary buffer for processing
    char* temp_buffer = (char*)malloc(max_layer_size);
    if (temp_buffer == NULL) {
        return -1;
    }

    // Copy the layer data at the specified index into the temporary buffer
    size_t data_len = strlen(layer_data[layer_index]);
    if (data_len >= (size_t)max_layer_size) {
        free(temp_buffer);
        return -1;
    }

    strcpy(temp_buffer, layer_data[layer_index]);

    // Parse the data (simple validation for demonstration)
    // In a real implementation, this would contain actual parsing logic
    int parsed_size = (int)data_len;

    // Clean up
    free(temp_buffer);

    return parsed_size;
}