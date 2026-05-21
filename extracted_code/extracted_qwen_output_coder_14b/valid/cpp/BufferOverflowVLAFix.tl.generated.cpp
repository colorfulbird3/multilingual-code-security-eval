#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }

    // Check if all field sizes are positive
    for (int i = 0; i < record_count; i++) {
        if (field_sizes[i] <= 0) {
            return -1;
        }
    }

    int total_alloc_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_alloc_size += field_sizes[i];
    }

    // Add extra space for commas and null terminator
    total_alloc_size += record_count - 1 + 1;

    *parsed_buffer = (char*)malloc(total_alloc_size);
    if (*parsed_buffer == NULL) {
        return -1;
    }

    char* write_ptr = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        strncpy(write_ptr, csv_data[i], field_sizes[i]);
        write_ptr += field_sizes[i];

        if (i < record_count - 1) {
            *write_ptr = ',';
            write_ptr++;
        }
    }

    *write_ptr = '\0'; // Null-terminate the string

    return 0;
}