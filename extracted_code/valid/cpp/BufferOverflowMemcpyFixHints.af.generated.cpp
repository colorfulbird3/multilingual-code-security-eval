#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    if (query_result == NULL || output_buffer == NULL) {
        return -1;
    }

    // Kontroleer of die resultaatlengte kleiner is as of gelyk is aan die buffergrootte
    if (result_len > buffer_size) {
        return -1;
    }

    // Kopieer die resultaatdata wat deur die databasis teruggegee word na die uitsetbuffer
    memmove(output_buffer, query_result, result_len);

    return 0;
}