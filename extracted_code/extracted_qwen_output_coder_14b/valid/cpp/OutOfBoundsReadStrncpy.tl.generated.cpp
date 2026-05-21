#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || body_len <= 0 || buffer_size <= 0) {
        return -1;
    }

    // Ensure the parameter fits within the buffer size
    if (body_len > buffer_size - 1) {
        return -1;
    }

    // Copy the parameter from the message body to the buffer
    strncpy(param_buffer, msg_body, body_len);
    param_buffer[body_len] = '\0'; // Null-terminate the string

    return 0;
}