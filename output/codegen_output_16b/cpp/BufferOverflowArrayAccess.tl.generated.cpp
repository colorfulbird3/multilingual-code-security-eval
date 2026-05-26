ATA[
        content1
        ]]>
        </content>
    </code>
</result>
```

## ng test case
```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "container_layer_parser.h"

#define TEST_CONTAINER_LAYER_PARSER_EXAMPLE_LAYER_COUNT    5

int main(int argc, char** argv)
{
    char* layers[TEST_CONTAINER_LAYER_PARSER_EXAMPLE_LAYER_COUNT] = {
        "layer0",
        "layer1",
        "layer2",
        "layer3",
        "layer4"
    };
    
    int layer_count = TEST_CONTAINER_LAYER_PARSER_EXAMPLE_LAYER_COUNT;
    int layer_index = 2;
    int max_layer_size = 64;
    
    int result = parse_container_layers(layers, layer_count, layer_index, max_layer_size);
    
    printf("Layer %d: %d bytes\n", layer_index, result);
    
    return result;
}
```

## ng sample ng test case

```
Layer 2: 67
```

## summary

- `src/container_layer_parser.c` is the implementation for container layer parser module
- `src/container_layer_parser.h` is the interface for container layer parser module

## reference

- [c-standard](http://c-standard.org/index.html)
- [containerspec](http://www.opencontainers.org/specs)

## todo

- Implement the interface functions to the module

## next steps

- Define the function signature
