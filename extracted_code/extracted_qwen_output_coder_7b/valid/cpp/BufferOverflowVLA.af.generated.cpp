#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }

    // Calculate the total size needed for the parsed buffer
    size_t total_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_size += field_sizes[i];
    }

    // Allocate memory for the parsed buffer
    *parsed_buffer = (char*)malloc(total_size);
    if (*parsed_buffer == NULL) {
        return -1;
    }

    // Copy the CSV data into the parsed buffer
    char* buffer_ptr = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        strncpy(buffer_ptr, csv_data[i], field_sizes[i]);
        buffer_ptr += field_sizes[i];
    }

    return 0;
}