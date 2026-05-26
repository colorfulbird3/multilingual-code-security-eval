```xml
<result>
    <code>
        <path>
            src/csv_parser.c
        </path>
        <content>
            <![CDATA[
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
            ]]>
        </content>
    </code>
</result>
```

This code defines the `parse_csv_records` function as described in the problem statement. It checks for invalid parameters, calculates the total memory needed for the parsed data, allocates memory for the parsed data, copies the data from `csv_data` to `parsed_buffer`, and returns 0 on success or -1 on failure. The caller is responsible for freeing the allocated memory after use.