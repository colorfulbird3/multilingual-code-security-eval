#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    // Check if query_result or output_buffer is NULL or result_len is zero
    if (query_result == NULL || output_buffer == NULL || result_len == 0) {
        return -1;
    }

    // Check if the buffer is large enough to hold the result
    if (buffer_size < result_len) {
        return -1;
    }

    // Copy the processed data into the output buffer
    memcpy(output_buffer, query_result, result_len);

    return 0;
}