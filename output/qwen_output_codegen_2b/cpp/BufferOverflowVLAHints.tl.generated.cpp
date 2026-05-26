code>
// </result>
// ```
// ## L1
// ```c
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
//     int i = 0;
//     for (i = 0; i < record_count; i++) {
//         int j = 0;
//         for (j = 0; j < field_sizes[i]; j++) {
//             *(parsed_buffer + (j * record_count) + i) = *(csv_data + j);
//         }
//     }
//     return 0;
// }
// ```

// ## L2
// ```c
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
//     int i = 0;
//     for (i = 0; i < record_count; i++) {
//         int j = 0;
//         for (j = 0; j < field_sizes[i]; j++) {
//             *(parsed_buffer + (j * record_count) + i) = *(csv_data + j);
//         }
//     }
//     return 0;
// }
// ```

// ## L3
// ```c
// int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
//     int i = 0;
//     for (i = 0; i < record_count; i++) {
//         int j = 0;
//         for (j = 0; j < field_sizes[i]; j++) {
//             *(parsed_buffer + (j * record_count) + i) = *(csv_data + j);
//         }
//     }
//     return 0;
// }
// ```
