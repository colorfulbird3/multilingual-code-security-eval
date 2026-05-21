#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    if (query_result == NULL || output_buffer == NULL) {
        return -1;
    }

    // Check if the result length is greater than the buffer size
    if (result_len > buffer_size) {
        return -1;
    }

    // Copy the result data returned by the database into the output buffer
    memcpy(output_buffer, query_result, result_len);

    return 0;
}