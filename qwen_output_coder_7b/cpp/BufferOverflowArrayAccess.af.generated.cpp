```xml
<result>
    <code>
        <path>src/container_layer_parser.c</path>
        <content>
            <![CDATA[
/*
 * container_layer_parser.c
 */

#include "container_layer_parser.h"

int parse_container_layers(char** layer_data, int layer_count, int layer_index, int max_layer_size) {
    if (layer_data == NULL || layer_index < 0 || layer_index >= layer_count || max_layer_size <= 0) {
        return -1;
    }

    char* target_layer = layer_data[layer_index];
    if (target_layer == NULL) {
        return -1;
    }

    size_t target_size = strlen(target_layer);
    if (target_size > max_layer_size) {
        return -1;
    }

    // Assuming we have a temporary buffer to store the parsed data
    static char temp_buffer[1024];
    if (target_size > sizeof(temp_buffer)) {
        return -1;
    }

    memcpy(temp_buffer, target_layer, target_size);
    temp_buffer[target_size] = '\0';

    // For demonstration purposes, let's assume the size of the parsed data is the length of the string
    return target_size;
}
]]>
        </content>
    </code>
</result>
```