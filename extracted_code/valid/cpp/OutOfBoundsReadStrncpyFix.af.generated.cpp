#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0) {
        return -1;
    }

    /* 
     * Kry die stringlengte uit die boodskapliggaam.
     * Aanvaar dat die boodskapliggaam 'n null-beëindigde string is, al spesifiseer body_len 'n reeks.
     */
    int msg_len = body_len;

    int copy_len;
    if (msg_len < buffer_size) {
        copy_len = msg_len;
    } else {
        copy_len = buffer_size - 1;
    }

    /* Voer geheuekopie uit */
    memcpy(param_buffer, msg_body, copy_len);
    
    /* Verseker dat die string null-beëindig is */
    param_buffer[copy_len] = '\0';

    return 0;
}