```xml
<result>
    <code>
        <path>src/network_config_parser.c</path>
        <content>
            <![CDATA[
#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count <= 0 || buffer_size <= 0) {
        return -1;
    }

    int total_length = 0;
    for (int i = 0; i < param_count; i++) {
        if (params[i] == NULL) {
            return -1;
        }
        total_length += strlen(params[i]) + 1; // Add 1 for the null terminator
    }

    if (total_length > buffer_size) {
        return -1;
    }

    char* current_position = buffer;
    for (int i = 0; i < param_count; i++) {
        strcpy(current_position, params[i]);
        current_position += strlen(params[i]) + 1;
    }

    return param_count;
}
            ]]>
        </content>
    </code>
</result>
```