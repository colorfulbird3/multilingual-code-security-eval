#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    if (query_result == NULL || output_buffer == NULL) {
        return -1;
    }

    if (result_len > buffer_size) {
        return -1;
    }

    // Copy the database result data into the output buffer
    memcpy(output_buffer, query_result, result_len);

    return 0;
}