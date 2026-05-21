#include "db_processor.h"

int process_query_result(const char* query_result, size_t result_len, char* output_buffer, size_t buffer_size) {
    if (buffer_size < result_len) {
        return -1; // Isayizi wesilondolozi onganele
    }

    memcpy(output_buffer, query_result, result_len);
    return 0; // Ekuqondiswa okuphumeleleni
}