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
    if (buffer == NULL || buffer_size <= 0 || params == NULL || param_count <= 0) {
        return -1;
    }

    int current_index = 0;
    int param_index = 0;

    while (current_index < buffer_size && param_index < param_count) {
        params[param_index] = &buffer[current_index];

        // Find the end of the current parameter
        while (current_index < buffer_size && buffer[current_index] != '\0') {
            current_index++;
        }

        // Move to the next parameter or the end of the buffer
        current_index++;

        // Check if we have processed all parameters
        param_index++;
    }

    // Ensure that all parameters were processed
    if (param_index != param_count) {
        return -1;
    }

    return param_count;
}
            ]]>
        </content>
    </code>
</result>
```