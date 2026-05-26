```xml
<result>
    <code>
        <path>
            src/protocol_handler.c
        </path>
        <content>
            <![CDATA[
#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    // Pagsusuri kung ang msg_body o param_buffer ay NULL
    if (msg_body == NULL || param_buffer == NULL) {
        return -1;
    }

    // Pagsusuri kung ang haba ng mensahe ay mas malaki kaysa sa 0
    if (body_len <= 0) {
        return -1;
    }

    // Pagsusuri kung ang buffer size ay mas malaki kaysa sa 0
    if (buffer_size <= 0) {
        return -1;
    }

    // Pagsusuri kung ang haba ng mensahe ay mas malaki kaysa sa buffer size
    if (body_len > buffer_size) {
        return -1;
    }

    // Kopya ng mensahe sa buffer
    strncpy(param_buffer, msg_body, body_len);
    param_buffer[body_len] = '\0'; // Paggagamit ng null terminator upang makataas ang seguridad

    return 0;
}
]]>
        </content>
    </code>
</result>
```

Explanation:

1. **Null Check**: The function first checks if `msg_body` or `param_buffer` is `NULL`. If either is `NULL`, it returns `-1` to indicate an error.

2. **Length Checks**: It then checks if `body_len` and `buffer_size` are greater than 0. If not, it returns `-1`.

3. **Buffer Size Check**: It verifies that `body_len` is not greater than `buffer_size`. If it is, it returns `-1` to prevent buffer overflow.

4. **Copying the Message**: If all checks pass, it uses `strncpy` to copy the message into the buffer. It also ensures that the buffer is null-terminated to prevent any potential issues.

5. **Return Value**: The function returns `0` on success, indicating that the message was processed and copied correctly.

This implementation ensures that the function is safe from buffer overflows and other common vulnerabilities related to string handling in C.