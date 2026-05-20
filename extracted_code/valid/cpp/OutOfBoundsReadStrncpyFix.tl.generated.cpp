#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0) {
        return -1;
    }

    /* Kunin ang haba ng string mula sa message body */
    int msg_len = (int)strlen(msg_body);

    /* Pagtatalaga sa kapasidad ng param_buffer */
    if (msg_len >= buffer_size) {
        msg_len = buffer_size - 1;
    }

    /* Isagawa ang memory copy */
    memcpy(param_buffer, msg_body, msg_len);
    param_buffer[msg_len] = '\0';

    return 0;
}