#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    // Kontroleer of die invoer geldig is
    if (msg_body == NULL || param_buffer == NULL || body_len <= 0 || buffer_size <= 0) {
        return -1;
    }

    // Kontroleer of die boodskaplengte groter is as die buffergrootte
    if (body_len > buffer_size) {
        return -1;
    }

    // Kopieer die boodskapliggaam veilig na die buffer
    strncpy(param_buffer, msg_body, body_len);
    param_buffer[body_len] = '\0'; // Voeg nul-terminering toe om 'n geldige C-teks te sorg voor

    return 0;
}