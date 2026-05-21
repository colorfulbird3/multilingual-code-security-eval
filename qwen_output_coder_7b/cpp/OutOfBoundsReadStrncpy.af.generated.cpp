```xml
<result>
    <code>
        <path>src/protocol_handler.c</path>
        <content><![CDATA[
#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || body_len < 0 || buffer_size <= 0) {
        return -1;
    }

    // Find the start of the parameter value
    const char* param_start = strstr(msg_body, "param=");
    if (param_start == NULL) {
        return -1;
    }

    // Move past the "param=" part to get to the actual value
    param_start += 6;

    // Calculate the length of the parameter value
    int param_len = strcspn(param_start, "\0");

    // Ensure there is enough space in the buffer
    if (param_len >= buffer_size) {
        return -1;
    }

    // Copy the parameter value to the buffer
    strncpy(param_buffer, param_start, param_len);
    param_buffer[param_len] = '\0';

    return 0;
}
]]>
        </content>
    </code>
</result>
```