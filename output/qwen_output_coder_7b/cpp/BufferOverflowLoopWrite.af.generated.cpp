 ```xml
<result>
    <code>
        <path>
            src/network_config_parser.c
        </path>
        <content>
            <![CDATA[
#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count <= 0 || buffer_size <= 0) {
        return -1;
    }

    int parsed_count = 0;
    int current_offset = 0;

    for (int i = 0; i < param_count; i++) {
        if (params[i] == NULL) {
            continue;
        }

        int param_len = strlen(params[i]);
        
        // Check if there is enough space for the parameter and null terminator
        if (current_offset + param_len + 1 > buffer_size) {
            return -1;
        }

        // Copy the parameter string to the buffer
        strcpy(buffer + current_offset, params[i]);
        current_offset += param_len + 1;  // +1 for null terminator
        parsed_count++;
    }

    return parsed_count;
}
            ]]>
        </content>
    </code>
</result>
```