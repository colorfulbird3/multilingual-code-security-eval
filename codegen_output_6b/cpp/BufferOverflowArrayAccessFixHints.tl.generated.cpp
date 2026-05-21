
    arr[index] = value;  // Potensyal na out-of-bounds access
}
```

## pag-parse
Dapat kapar sa pag-parse ng isang layer ng image sa pagproseso.

```c
// ❌ Masamang halimbawa: pag-parse ng layer ng image sa pagproseso, sa pag-parse ng mga layer ng image sa pagproseso sa mga array, at maa-pag-parse ng mga layer ng image sa pagproseso
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size);

// ❌ Masamang halimbawa: pag-parse ng layer ng image sa pagproseso, sa pagproseso ng mga layer ng image sa pagproseso sa mga array, at maa-pag-parse ng mga layer ng image sa pagproseso
int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size);
```


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#include "container_layer_parser.h"

#define MAX_LAYER_COUNT 3
#define MAX_LAYER_SIZE 64

int main(void) {
    int index = 0;
    char* layer_data[MAX_LAYER_COUNT] = {"layer0", "layer1", "layer2"};
    int layer_count = MAX_LAYER_COUNT;
    int layer_index = 0;
    int layer_size = MAX_LAYER_SIZE;
    
    char* layer_buffer = calloc(layer_size, sizeof(char));
    
    layer_count = get_user_input();
    if (layer_count > 0) {
        while (layer_count > 0) {
            layer_index = get_user_input();
            layer_size = parse_container_layers(&layer_data[0], layer_count, layer_index,