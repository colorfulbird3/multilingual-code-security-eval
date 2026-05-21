#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0) {
        return -1;
    }

    /* 
     * Kunin ang haba ng string mula sa message body.
     * Ipagpalagay na ang message body ay isang null-terminated string, kahit na ang body_len ay tumutukoy sa isang range.
     */
    int msg_len = (int)strlen(msg_body);

    if (msg_len >= buffer_size) {
        return -1; // Hindi maaari na makuha ang buong string dahil hindi sapat ang buffer size
    }

    /* Isagawa ang memory copy */
    strncpy(param_buffer, msg_body, buffer_size - 1);
    
    /* Siguraduhing ang string ay null-terminated */
    param_buffer[buffer_size - 1] = '\0';

    return 0;
}