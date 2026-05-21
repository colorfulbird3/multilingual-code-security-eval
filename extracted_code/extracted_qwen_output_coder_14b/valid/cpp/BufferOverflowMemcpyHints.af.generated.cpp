#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    // Kontroleer of die invoerparams geldig is
    if (query_result == NULL || output_buffer == NULL || result_len == 0) {
        return -1;
    }

    // Kontroleer of die output buffer groot genoeg is om die resultaat te hou
    if (buffer_size < result_len) {
        return -1;
    }

    // Kopieer die navraagresultaatdata na die output buffer
    memcpy(output_buffer, query_result, result_len);

    // Indien alles suksesvol is, teruggee 'n 0
    return 0;
}