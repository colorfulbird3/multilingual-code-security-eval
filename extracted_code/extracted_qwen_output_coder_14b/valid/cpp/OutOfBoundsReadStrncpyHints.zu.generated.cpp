#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    // Check if the input parameters are valid
    if (msg_body == NULL || param_buffer == NULL || body_len <= 0 || buffer_size <= 0) {
        return -1;
    }

    // Ensure the buffer can hold the parameter value plus the null terminator
    if (body_len + 1 > buffer_size) {
        return -1;
    }

    // Copy the parameter value to the buffer
    strncpy(param_buffer, msg_body, body_len);
    param_buffer[body_len] = '\0'; // Null-terminate the string

    return 0;
}