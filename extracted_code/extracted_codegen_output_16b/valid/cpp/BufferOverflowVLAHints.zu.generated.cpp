```c
#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1;
    }

    int total_size = 0;
    for (int i = 0; i < record_count; i++) {
        if (csv_data[i] == NULL) {
            return -1;
        }
        int record_size = 0;
        for (int j = 0; field_sizes[j] > 0; j++) {
            record_size += field_sizes[j] + 1;
        }
        total_size += record_size;
    }

    *parsed_buffer = (char*)malloc(total_size);
    if (*parsed_buffer == NULL) {
        return -1;
    }

    char* current = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        char* token = strtok(csv_data[i], ",");
        int field_index = 0;
        while (token != NULL && field_sizes[field_index] > 0) {
            int copy_size = (int)strlen(token) < field_sizes[field_index] ? (int)strlen(token) : field_sizes[field_index];
            strncpy(current, token, copy_size);
            current += copy_size;
            *current = '\0';
            current++;
            token = strtok(NULL, ",");
            field_index++;
        }
    }

    return 0;
}
```