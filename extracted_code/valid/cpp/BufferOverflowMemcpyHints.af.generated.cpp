#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    if (query_result == NULL || output_buffer == NULL) {
        return -1; // Ongeldige parameter
    }

    if (result_len > buffer_size) {
        return -1; // Onvoldoende buffergrootte
    }

    // Kopieer die navraagresultaatdata na die output_buffer
    memcpy(output_buffer, query_result, result_len);
    output_buffer[result_len] = '\0'; // Slegs vir tekenreeks, as nodig

    return 0; // Suksesvolle kopiëring
}