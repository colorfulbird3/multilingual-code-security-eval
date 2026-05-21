#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    // Check if the input parameters are valid
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0) {
        return -1;
    }

    // Find the position of the first space character in the message body
    const char* space_pos = strchr(msg_body, ' ');
    if (space_pos == NULL) {
        return -1; // No space found, invalid message format
    }

    // Calculate the length of the parameter
    int param_len = space_pos - msg_body;

    // Ensure the parameter length does not exceed the buffer size
    if (param_len >= buffer_size) {
        return -1;
    }

    // Copy the parameter to the buffer
    strncpy(param_buffer, msg_body, param_len);
    param_buffer[param_len] = '\0'; // Null-terminate the string

    return 0; // Success
}