#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0 || body_len <= 0) {
        return -1;
    }

    /* Kopieer die string veilig na die buffer */
    if (body_len < buffer_size) {
        strncpy(param_buffer, msg_body, body_len);
        param_buffer[body_len] = '\0'; // Voeg die null-terminator toe
    } else {
        strncpy(param_buffer, msg_body, buffer_size - 1);
        param_buffer[buffer_size - 1] = '\0'; // Voeg die null-terminator toe
    }

    return 0;
}