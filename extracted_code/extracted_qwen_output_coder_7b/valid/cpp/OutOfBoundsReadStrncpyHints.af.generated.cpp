#include "protocol_handler.h"

int process_protocol_message(const char* msg_body, int body_len, char* param_buffer, int buffer_size) {
    if (msg_body == NULL || param_buffer == NULL || buffer_size <= 0) {
        return -1; // Foutlike invoer
    }

    // Zoek die begin van die parameter in die boodskap
    const char* param_start = strstr(msg_body, "param=");
    if (param_start == NULL) {
        return -1; // Parameter nie gevind nie
    }

    // Bereken die lengte van die parameter
    int param_len = body_len - (param_start - msg_body);
    if (param_len <= 0) {
        return -1; // Onvallige parameterlengte
    }

    // Kopieer die parameter na die buffer met grenskontrole
    if (param_len >= buffer_size) {
        param_len = buffer_size - 1; // Sien na die buffer om 'n terminerende null te laat
    }
    strncpy(param_buffer, param_start + 6, param_len); // +6 omdat "param=" 6 karakters lang is
    param_buffer[param_len] = '\0'; // Sien na die buffer om 'n terminerende null te laat

    return 0; // Sukses
}