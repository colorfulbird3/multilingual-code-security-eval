```c
#include <stdio.h>
#include <string.h>

#define MAX_LAYER_COUNT 10
#define MAX_LAYER_SIZE 256

typedef struct {
    char data[MAX_LAYER_SIZE];
} Layer;

int parse_container_layer(Layer *layer_data, int layer_count, int layer_index, const char *target_layer) {
    char temp_buffer[MAX_LAYER_SIZE];
    
    // Vulnerability 1: Missing boundary check for layer_index (CWE-129)
    Layer *selected_layer = &layer_data[layer_index];
    
    // Vulnerability 2 & 3: Stack-based buffer overflow and unsafe strcpy (CWE-121, CWE-120)
    strcpy(temp_buffer, target_layer);
    
    printf("Selected layer: %s\n", selected_layer->data);
    printf("Target layer: %s\n", temp_buffer);
    
    return 0;
}
```