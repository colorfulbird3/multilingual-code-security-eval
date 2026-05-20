#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    if (query_result == NULL || output_buffer == NULL || result_len > buffer_size) {
        return -1;
    }

    // Kopieer die databasis resultaatdata na die uitsetbuffer
    memcpy(output_buffer, query_result, result_len);

    return 0;
}