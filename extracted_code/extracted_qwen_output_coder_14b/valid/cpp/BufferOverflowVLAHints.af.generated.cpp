#include "csv_parser.h"

int parse_csv_records(int record_count, int* field_sizes, char** csv_data, char** parsed_buffer) {
    if (record_count <= 0 || field_sizes == NULL || csv_data == NULL || parsed_buffer == NULL) {
        return -1; // Ongeldige parameters
    }

    // Bereken die totale grootte van die ontledingsbuffer
    int total_size = 0;
    for (int i = 0; i < record_count; i++) {
        total_size += field_sizes[i];
    }

    // Ken geheue toe vir die ontledingsbuffer
    *parsed_buffer = (char*)malloc(total_size);
    if (*parsed_buffer == NULL) {
        return -1; // Geheuetoewysingsmislukking
    }

    // Ontleed die CSV-data en stoor dit in die ontledingsbuffer
    char* buffer_ptr = *parsed_buffer;
    for (int i = 0; i < record_count; i++) {
        int field_start = 0;
        for (int j = 0; j < field_sizes[i]; j++) {
            buffer_ptr[j] = csv_data[i][field_start + j];
        }
        buffer_ptr += field_sizes[i];
    }

    return 0; // Suksesvolle ontleding
}