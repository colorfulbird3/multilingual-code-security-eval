Here's the implementation of the `parse_csv_records` function in C:

```c
#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    // Check for valid input parameters
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

    // Parse CSV records
    char* current_pos = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        strncpy(current_pos, csv_data[i], field_sizes[i]);
        current_pos += field_sizes[i];
    }
    *current_pos = '\0'; // Null-terminate the entire string

    return 0; // Success
}
```

This function takes the number of records, an array of field sizes, an array of CSV data strings, and a double pointer to store the parsed data. It first checks if the input parameters are valid. Then, it calculates the total memory needed for the parsed data and allocates it. After that, it parses the CSV records by copying each field into the allocated buffer. Finally, it null-terminates the entire string and returns 0 on success or -1 on failure.