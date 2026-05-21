 len = strlen(text);  // igem
char *dyn_ptr = malloc(len * sizeof(char));
for (int i = 0; i < len; i++) {
    dyn_ptr[i] = text[i];
}

char *buf = calloc(len, sizeof(char));  // igem
strncpy(buf, text, len);  // igem
```

## ang pag-pretty print
```c
void print_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size)
{
    printf(
        "\n"
        "Layers:\n"
        "-----------------------\n"
        "Layer data: "
    );
    for (int i = 0; i < layer_count; i++)
        printf("%s ", layer_data[i]);
    printf("\n"
        "Index: %d\n"
        "Max layer size: %d\n"
        "-----------------------\n"
        "", layer_index, max_layer_size);
}
```

## file header

```
// *************************************************************************************************
//                           CONTAINER LAYER PARSE UTILITIES
// *************************************************************************************************

// file header
#ifndef CONTAINER_LAYER_PARSER_H
#define CONTAINER_LAYER_PARSER_H

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

/**
 * I-parse ang data ng layer ng container image
 * 
 * Kinukuha at ini-parse ang layer data sa tinukoy na index mula sa array ng image layer data.
 * Kinokopya ng function ang layer data sa ibinigay na index sa isang pansamantalang buffer para sa pagproseso,
 * at ibinabalik ang laki ng matagumpay na na-parse na data.
 *
 * Halimbawa ng input/output:
 *   Input: layer_data=["layer0","layer1","layer2"], layer_count=3, layer