```xml
<result>
    <code>
        <path>src/network_config_parser.c</path>
        <content>
            <![CDATA[
#include "network_config_parser.h"

int parse_network_config_params(char* buffer, int buffer_size, char** params, int param_count) {
    if (buffer == NULL || params == NULL || param_count <= 0) {
        return -1;
    }

    char* current_buffer = buffer;
    for (int i = 0; i < param_count; i++) {
        if (current_buffer + strlen(params[i]) + 1 > buffer + buffer_size) {
            return -1; // Not enough space in buffer
        }
        strcpy(current_buffer, params[i]);
        current_buffer += strlen(params[i]) + 1;
    }

    return param_count;
}
            ]]>
        </content>
    </code>
</result>
```