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