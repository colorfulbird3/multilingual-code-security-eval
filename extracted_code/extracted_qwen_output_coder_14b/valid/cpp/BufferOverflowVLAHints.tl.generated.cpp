#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    // Check for invalid parameters
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }

    // Calculate total memory needed for parsed data
    int total_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_size += field_sizes[i];
    }

    // Allocate memory for parsed data
    *parsed_buffer = (char*)malloc(total_size + 1); // +1 for null terminator
    if (*parsed_buffer == NULL) {
        return -1; // Memory allocation failed
    }

    // Copy data from csv_data to parsed_buffer
    char* current_pos = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        strncpy(current_pos, csv_data[i], field_sizes[i]);
        current_pos += field_sizes[i];
    }
    *current_pos = '\0'; // Null-terminate the string

    return 0; // Success
}