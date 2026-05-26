#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int parse_csv(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }

    int total_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_size += field_sizes[i];
    }

    *parsed_buffer = (char*)malloc(total_size);
    if (*parsed_buffer == NULL) {
        return -1;
    }

    char* current_pos = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        char* token = strtok(csv_data[i], ",");
        int field_index = 0;
        while (token != NULL && field_index < record_count) {
            strncpy(current_pos, token, field_sizes[field_index] - 1);
            current_pos[field_sizes[field_index] - 1] = '\0';
            current_pos += field_sizes[field_index];
            token = strtok(NULL, ",");
            field_index++;
        }
    }

    return 0;
}