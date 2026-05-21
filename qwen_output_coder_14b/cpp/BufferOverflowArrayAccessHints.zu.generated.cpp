Here is the implementation of the `parse_container_layers` function in C, as requested:

```c
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
```

### Explanation:
1. **Input Validation**: The function first checks if the input parameters are valid. It ensures that `layer_data` is not `NULL`, `layer_index` is within the valid range, and `max_layer_size` is greater than zero.

2. **Layer Size Calculation**: It calculates the size of the layer data at the specified index using `strlen`.

3. **Size Check**: It checks if the calculated layer size exceeds the maximum allowed size (`max_layer_size`). If it does, the function returns `-1`.

4. **Temporary Buffer**: It allocates a temporary buffer to hold the parsed layer data. This buffer is sized to accommodate the maximum allowed layer size plus one byte for the null terminator.

5. **Data Copying and Processing**: It copies the layer data into the temporary buffer and null-terminates the string. For demonstration purposes, it prints the parsed layer data.

6. **Memory Management**: It frees the allocated temporary buffer after processing.

7. **Return Value**: Finally, it returns the size of the parsed layer data.

This implementation provides a basic framework for parsing container image layer data. You can modify the processing logic as needed to suit your specific requirements.