#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }
    
    size_t total_alloc_size = 0;
    for (int i = 0; i < record_count; i++) {
        if (field_sizes[i] <= 0 || csv_data[i] == NULL) {
            return -1;
        }
        total_alloc_size += (size_t)field_sizes[i] + 1;
    }
    
    if (total_alloc_size > 1024 * 1024 * 100) {
        return -1;
    }
    
    *parsed_buffer = (char*)malloc(total_alloc_size);
    if (*parsed_buffer == NULL) {
        return -1;
    }
    
    char* current_pos = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        size_t field_len = (size_t)field_sizes[i];
        if (strlen(csv_data[i]) < field_len) {
            free(*parsed_buffer);
            *parsed_buffer = NULL;
            return -1;
        }
        strncpy(current_pos, csv_data[i], field_len);
        current_pos[field_len] = '\0';
        current_pos += field_len + 1;
    }
    
    return 0;
}